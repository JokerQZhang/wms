package com.joker.wms.webapp.action;

import com.opensymphony.xwork2.Preparable;
import com.joker.wms.service.FacilityTransitionManager;
import com.joker.wms.service.SalePlanManager;
import com.joker.wms.dao.SearchException;
import com.joker.wms.model.FacilityTransition;
import com.joker.wms.webapp.action.BaseAction;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class FacilityTransitionAction extends BaseAction implements Preparable {
    private FacilityTransitionManager facilityTransitionManager;
    private List facilityTransitions;
    private FacilityTransition facilityTransition;
    private Long facilityTransitionId;
    private String query;
    private SalePlanManager salePlanManager;

    public void setSalePlanManager(SalePlanManager salePlanManager) {
		this.salePlanManager = salePlanManager;
	}

	public void setFacilityTransitionManager(FacilityTransitionManager facilityTransitionManager) {
        this.facilityTransitionManager = facilityTransitionManager;
    }

    public List getFacilityTransitions() {
        return facilityTransitions;
    }

    /**
     * Grab the entity from the database before populating with request parameters
     */
    public void prepare() {
        if (getRequest().getMethod().equalsIgnoreCase("post")) {
            // prevent failures on new
            String facilityTransitionId = getRequest().getParameter("facilityTransition.facilityTransitionId");
            if (facilityTransitionId != null && !facilityTransitionId.equals("")) {
                facilityTransition = facilityTransitionManager.get(new Long(facilityTransitionId));
            }
        }
    }

    public void setQ(String q) {
        this.query = q;
    }

    public String list() {
        try {
            facilityTransitions = facilityTransitionManager.search(query, FacilityTransition.class, getPage());
        } catch (SearchException se) {
            addActionError(se.getMessage());
            facilityTransitions = facilityTransitionManager.getAll(getPage());
        }
        if(query != null){
        	getRequest().setAttribute("showForm", "showData");
        }
        return SUCCESS;
    }

    public void setFacilityTransitionId(Long facilityTransitionId) {
        this.facilityTransitionId = facilityTransitionId;
    }

    public FacilityTransition getFacilityTransition() {
        return facilityTransition;
    }

    public void setFacilityTransition(FacilityTransition facilityTransition) {
        this.facilityTransition = facilityTransition;
    }

    public String delete() {
        facilityTransitionManager.remove(facilityTransition.getFacilityTransitionId());
        saveMessage(getText("facilityTransition.deleted"));

        return SUCCESS;
    }

    public String edit() {
        if (facilityTransitionId != null) {
            facilityTransition = facilityTransitionManager.get(facilityTransitionId);
        } else {
            facilityTransition = new FacilityTransition();
        }
        String directlyModify = getRequest().getParameter("directlyModify");
        if(directlyModify!=null && !"".equals(directlyModify) && "directly".equals(directlyModify)){
        	String facilityId = getRequest().getParameter("facilityId");
        	String productId = getRequest().getParameter("productId");
        	if(facilityId==null || "".equals(facilityId)){
        		return ERROR;
        	}
        	if(productId==null || "".equals(productId)){
        		return ERROR;
        	}
        	facilityTransition.setFacilityId(Long.valueOf(facilityId));
        	facilityTransition.setProductId(Long.valueOf(productId));
        	facilityTransition.setBizType(2l);//biz_type==2标识操作业务类型为库存填报
        	getRequest().setAttribute("directlyModify", "directly");
        	//List invertoryList = salePlanManager.facilityInventory(facilityId, productId);
        }
        return SUCCESS;
    }

    public String save() throws Exception {
        if (cancel != null) {
            super.setJsonResult("取消保存");
            return "jsonResult";
        }

        if (delete != null) {
            facilityTransitionManager.remove(facilityTransition.getFacilityTransitionId());
        	super.setJsonResult("删除成功");
            return "jsonResult";
        }
        boolean isNew = (facilityTransition.getFacilityTransitionId() == null);
        if(isNew){
        	facilityTransition.setCreatedByUser(getCurrentUser().getId());
        	facilityTransition.setCreatedTime(new Date());
        }else{
        	facilityTransition.setLastUpdatedByUser(getCurrentUser().getId());
        	facilityTransition.setLastUpdatedTime(new Date());
        }
        //如果是修改库存咋要进行一系列的操作哦
        String directlyModify = getRequest().getParameter("directlyModify");
        if(directlyModify!=null && !"".equals(directlyModify) && "directly".equals(directlyModify)){
        	if(facilityTransition.getNum().compareTo(new BigDecimal("0"))==-1){
            	//填报数量不可以小雨0
            	return ERROR;
            }
        	String facilityId = facilityTransition.getFacilityId().toString();
        	String productId = facilityTransition.getProductId().toString();
        	List invertoryList = salePlanManager.facilityInventory(facilityId, productId);
        	//找到该库存中该产品的现有库存，然后和填报库存之间作减法，得出的结果正是本次填报需要新增的库存数量
        	//如果list中未有记录，则至哟呵facilityId和productId不为空都可以保存一条库存变化记录
        	if(invertoryList==null || invertoryList.isEmpty()){
        		facilityTransition.setInOutType(1l);
        	}else{
        		Object[] objs = (Object[])invertoryList.get(0);//只允许有一条记录，否则为错。 
        		//如果数量为空，标识该产品该仓库下还未有库存记录此时将新增的库存数量保存即可
        		if(objs[1] == null){
        			facilityTransition.setInOutType(1l);
        		}else{
        			//计算库存增量
            		BigDecimal nownum = new BigDecimal(objs[1].toString());
            		BigDecimal addition = facilityTransition.getNum().subtract(nownum);
            		int inOutType = addition.compareTo(new BigDecimal(0));
            		if(inOutType == -1){
            			//如果是负值转换成正值保存
            			addition = (new BigDecimal(0)).subtract(addition);
            		}
            		facilityTransition.setInOutType(Long.valueOf(inOutType));
            		facilityTransition.setNum(addition);
        		}
        	}
        	facilityTransition.setTranDate(new Date());
        }
        
        facilityTransition = facilityTransitionManager.save(facilityTransition);

        String key = (isNew) ? "facilityTransition.added" : "facilityTransition.updated";
        saveMessage(getText(key));

        super.setJsonResult("保存成功");
        return "jsonResult";
    }
}