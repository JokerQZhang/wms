package com.joker.wms.webapp.action;

import com.opensymphony.xwork2.Preparable;
import com.joker.wms.service.EnumerationManager;
import com.joker.wms.service.TbProvideManager;
import com.joker.wms.util.MyDateUtil;
import com.joker.wms.dao.SearchException;
import com.joker.wms.model.PartyGroup;
import com.joker.wms.model.TbProvide;
import com.joker.wms.webapp.action.BaseAction;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class TbProvideAction extends BaseAction implements Preparable {
    private TbProvideManager tbProvideManager;
    private List tbProvides;
    private TbProvide tbProvide;
    private Long provideId;
    private String query;
    private EnumerationManager enumerationManager;
    private String yfTypeId;

    public String getYfTypeId() {
		return yfTypeId;
	}

	public void setYfTypeId(String yfTypeId) {
		this.yfTypeId = yfTypeId;
	}

	public void setEnumerationManager(EnumerationManager enumerationManager) {
		this.enumerationManager = enumerationManager;
	}

	public void setTbProvideManager(TbProvideManager tbProvideManager) {
        this.tbProvideManager = tbProvideManager;
    }

    public List getTbProvides() {
        return tbProvides;
    }

    /**
     * Grab the entity from the database before populating with request parameters
     */
    public void prepare() {
        if (getRequest().getMethod().equalsIgnoreCase("post")) {
            // prevent failures on new
            String tbProvideId = getRequest().getParameter("tbProvide.provideId");
            if (tbProvideId != null && !tbProvideId.equals("")) {
                tbProvide = tbProvideManager.get(new Long(tbProvideId));
            }
        }
    }

    public void setQ(String q) {
        this.query = q;
    }

    public String list() {
        try {
            tbProvides = tbProvideManager.search(query, TbProvide.class, getPage());
        } catch (SearchException se) {
            addActionError(se.getMessage());
            tbProvides = tbProvideManager.getAll(getPage());
        }
        if(query != null){
        	getRequest().setAttribute("showForm", "showData");
        }
        return SUCCESS;
    }

    public void setProvideId(Long provideId) {
        this.provideId = provideId;
    }

    public TbProvide getTbProvide() {
        return tbProvide;
    }

    public void setTbProvide(TbProvide tbProvide) {
        this.tbProvide = tbProvide;
    }

    public String delete() {
    	tbProvide = tbProvideManager.get(provideId);
    	if(tbProvide.getValidFlag()!=0L){
    		super.setJsonResult("非正常状态的优抚资金发放不可删除！");
            return "jsonResult";
    	}
    	tbProvideManager.removeDtl(tbProvide.getProvideId());
        tbProvideManager.remove(tbProvide.getProvideId());
        saveMessage(getText("tbProvide.deleted"));

        return SUCCESS;
    }

    public String edit() {
    	setYFTypes();
    	//日期
    	String nowDate = MyDateUtil.getCurrDate("yyyy-MM-dd");
    	//部门
    	List pglist = super.getRelationPartyGroup();
    	//发放名称：部门名称+--+日期+--+优抚类型
    	String provideName = "";
    	if(pglist!=null && pglist.size()>0){
    		PartyGroup pg = (PartyGroup)pglist.get(0);
    		provideName = pg.getGroupName() + "--";
    	}else{
    		//用户归属部门为空，不允许操作.
    		
    	}
    	provideName += MyDateUtil.getCurrDate("yyyy年MM月") + "--";
    	
    	getRequest().setAttribute("nowDate", nowDate);
    	getRequest().setAttribute("tempprovideName", provideName);
        if (provideId != null) {
            tbProvide = tbProvideManager.get(provideId);
        } else {
            tbProvide = new TbProvide();
        }

        return SUCCESS;
    }

    public String save() throws Exception {
        if (cancel != null) {
            super.setJsonResult("取消保存");
            return "jsonResult";
        }

        if (delete != null) {
        	if(tbProvide.getValidFlag()!=0L){
        		super.setJsonResult("非正常状态的优抚资金发放不可删除！");
                return "jsonResult";
        	}
        	tbProvideManager.removeDtl(tbProvide.getProvideId());
        	tbProvideManager.remove(tbProvide.getProvideId());
        	super.setJsonResult("删除成功");
            return "jsonResult";
        }
        
        boolean isNew = (tbProvide.getProvideId() == null);
        //判断是否新增，如果是新增，判断发放中是否有已经重名的发放，已重名不允许重复发放。
        if(isNew){
        	tbProvide.setValidFlag(0L);//0：有效；1：已发放：-1：已删除
        	tbProvide.setCreatedByUser(getCurrentUser().getId());
        	tbProvide.setCreatedTime(new Date());
        	List pglist = super.getRelationPartyGroup();
        	if(pglist!=null && pglist.size()>0){
        		PartyGroup partyGroup = (PartyGroup)pglist.get(0);
        		tbProvide.setDepartmentId(partyGroup.getPartyId());
        	}
        	
        	boolean isNameExists = tbProvideManager.getProvideNameExists(tbProvide.getProvideName());
        	if(isNameExists){
        		super.setJsonResult("该机构的该项优抚发放已存在。");
                return "jsonResult";
        	}
        }
        tbProvide = tbProvideManager.save(tbProvide);
        if(isNew){
        	//保存完主表后要保存明细表tb_provide_dtl
            tbProvideManager.saveProvideDtl(tbProvide, yfTypeId);
            BigDecimal moneySum = tbProvideManager.getMoneySum(tbProvide.getProvideId());
            tbProvide.setProvideSum(moneySum);
            tbProvide = tbProvideManager.save(tbProvide);//更新总金额字段
        }
        String key = (isNew) ? "tbProvide.added" : "tbProvide.updated";
        saveMessage(getText(key));

        super.setJsonResult("保存成功");
        return "jsonResult";
    }
    public void setYFTypes(){
    	List yftypes = enumerationManager.getYFTypes();
    	super.getRequest().setAttribute("yftypes", yftypes);
    }
    public String sendMoney(){
    	if(provideId==null){
    		super.setJsonResult("未查到有效的发放信息。");
    		return "jsonResult";
    	}
    	tbProvide = tbProvideManager.get(provideId);
    	if(tbProvide.getValidFlag()!=0L){
    		super.setJsonResult("未查到有效的发放信息。");
    		return "jsonResult";
    	}
    	tbProvide.setLastUpdatedByUser(getCurrentUser().getId());
    	tbProvide.setLastUpdatedTime(new Date());
    	tbProvide.setValidFlag(1L);//资金已发放状态
    	tbProvide = tbProvideManager.save(tbProvide);
    	tbProvideManager.sendMoneyDtl(tbProvide);
    	super.setJsonResult("发放成功");
        return "jsonResult";
    }
}