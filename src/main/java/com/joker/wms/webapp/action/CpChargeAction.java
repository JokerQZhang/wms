package com.joker.wms.webapp.action;

import com.opensymphony.xwork2.Preparable;
import com.joker.wms.service.CpChargeManager;
import com.joker.wms.service.PartyGroupManager;
import com.joker.wms.dao.SearchException;
import com.joker.wms.model.CpCharge;
import com.joker.wms.model.PartyGroup;
import com.joker.wms.webapp.action.BaseAction;

import java.util.Date;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class CpChargeAction extends BaseAction implements Preparable {
    private CpChargeManager cpChargeManager;
    private List cpCharges;
    private CpCharge cpCharge;
    private Long cpChargeId;
    private String query;

	public void setCpChargeManager(CpChargeManager cpChargeManager) {
        this.cpChargeManager = cpChargeManager;
    }

    public List getCpCharges() {
        return cpCharges;
    }

    /**
     * Grab the entity from the database before populating with request parameters
     */
    public void prepare() {
        if (getRequest().getMethod().equalsIgnoreCase("post")) {
            // prevent failures on new
            String cpChargeId = getRequest().getParameter("cpCharge.cpChargeId");
            if (cpChargeId != null && !cpChargeId.equals("")) {
                cpCharge = cpChargeManager.get(new Long(cpChargeId));
            }
        }
    }

    public void setQ(String q) {
        this.query = q;
    }

    public String list() {
        try {
        	Map condition = new HashMap();
            cpCharges = cpChargeManager.search(condition, CpCharge.class, getPage());
        } catch (SearchException se) {
            addActionError(se.getMessage());
            cpCharges = cpChargeManager.getAll(getPage());
        }
        if(query != null){
        	getRequest().setAttribute("showForm", "showData");
        }
        return SUCCESS;
    }

    public void setCpChargeId(Long cpChargeId) {
        this.cpChargeId = cpChargeId;
    }

    public CpCharge getCpCharge() {
        return cpCharge;
    }

    public void setCpCharge(CpCharge cpCharge) {
        this.cpCharge = cpCharge;
    }

    public String delete() {
        cpChargeManager.remove(cpCharge.getCpChargeId());
        saveMessage(getText("cpCharge.deleted"));

        return SUCCESS;
    }

    public String edit() {
        if (cpChargeId != null) {
            cpCharge = cpChargeManager.get(cpChargeId);
        } else {
            cpCharge = new CpCharge();
        }
    	String operTypeOptions = super.getEnumerationSelector(8l, cpCharge.getOperType());
    	String accountTypeOptions = super.getEnumerationSelector(9l, cpCharge.getAccountType());
    	getRequest().setAttribute("operTypeOptions", operTypeOptions);
    	getRequest().setAttribute("accountTypeOptions", accountTypeOptions);
    	PartyGroup nowZhibu = getNowZhibu();
    	
    	//上下级党委支部options
    	if(nowZhibu==null){
    		return ERROR;
    	}else{
    		cpCharge.setPartyId(nowZhibu.getPartyId());//设置该条操作记录的组织机构partyId
    		List childrenDw = partyGroupManager.getPgByDwId(nowZhibu.getPartyId().toString());
    		PartyGroup parentDw = partyGroupManager.get(2L);
    		String parentOptions = "<option value='" + parentDw.getPartyId() + "'>" + parentDw.getGroupName() + "</option>";
    		String childrenOptions = "";
    		if(childrenDw!=null && childrenDw.size()>0){
    			for(int i=0; i<childrenDw.size(); i++){
    				PartyGroup childDw = (PartyGroup)childrenDw.get(i);
    				childrenOptions += "<option value='" + childDw.getPartyId() + "'>" + childDw.getGroupName() + "</option>";
    			}
    		}
    		getRequest().setAttribute("parentOptions", parentOptions);
        	getRequest().setAttribute("childrenOptions", childrenOptions);
    	}
        return SUCCESS;
    }

    public String save() throws Exception {
        if (cancel != null) {
            super.setJsonResult("取消保存");
            return "jsonResult";
        }

        if (delete != null) {
            cpChargeManager.remove(cpCharge.getCpChargeId());
        	super.setJsonResult("删除成功");
            return "jsonResult";
        }

        boolean isNew = (cpCharge.getCpChargeId() == null);
        if(isNew){
        	cpCharge.setCreatedByUser(super.getCurrentUser().getId());
        	cpCharge.setCreatedTime(new Date());
        	if(cpCharge.getOperType()==22||cpCharge.getOperType()==24){
        		cpCharge.setIoType(1L);
        	}else if(cpCharge.getOperType()==23||cpCharge.getOperType()==25){
        		cpCharge.setIoType(-1L);
        	}
        	//如果是下拨的话，相关账户是拨款账户，其他的都和操作账户一致
        	cpCharge.setRelateAccountType(cpCharge.getAccountType());
        	//如果操作员是党委 上缴党费 则需增加县委的 收纳党费
        	//如果操作员属于县委  操作类型属于 下拨 则需要增加党委的 上级拨入
        	//如果操作员不属于县委 操作类型属于 上级拨入则需要增加 县委的 下拨
        	if(cpCharge.getPartyId() == 2L){
        		if(cpCharge.getOperType() == 25L){
        			cpCharge.setRelateAccountType(27L);
        			CpCharge cpCharge2 = new CpCharge();
        			cpCharge2.setCreatedByUser(super.getCurrentUser().getId());
        			cpCharge2.setCreatedTime(new Date());
        			cpCharge2.setPartyId(cpCharge.getRelatePartyId());//相关的支部
        			cpCharge2.setCpTitle(cpCharge.getCpTitle());
        			cpCharge2.setBalance(cpCharge.getBalance());
        			cpCharge2.setAccountType(27L);//下拨到拨款账户
        			cpCharge2.setIoType(-cpCharge.getIoType());
        			cpCharge2.setMemo(cpCharge.getMemo());
        			cpCharge2.setOperPeople(cpCharge.getOperPeople());
        			cpCharge2.setRelateAccountType(cpCharge.getAccountType());//相关账户为当前操作的账户
        			cpCharge2.setRelatePartyId(2L);//相关组织机构为当前操作的机构id
        			cpCharge2.setOperType(24L);//上级拨入操作
        			cpChargeManager.save(cpCharge2);
        		}
        	}else{
        		if(cpCharge.getOperType() == 23L){
        			CpCharge cpCharge2 = new CpCharge();
        			cpCharge2.setCreatedByUser(super.getCurrentUser().getId());
        			cpCharge2.setCreatedTime(new Date());
        			cpCharge2.setPartyId(2L);//相关的支部
        			cpCharge2.setCpTitle(cpCharge.getCpTitle());
        			cpCharge2.setBalance(cpCharge.getBalance());
        			cpCharge2.setAccountType(cpCharge.getAccountType());//下拨到拨款账户
        			cpCharge2.setIoType(-cpCharge.getIoType());
        			cpCharge2.setMemo(cpCharge.getMemo());
        			cpCharge2.setOperPeople(cpCharge.getOperPeople());
        			cpCharge2.setRelateAccountType(cpCharge.getAccountType());//相关账户为当前操作的账户
        			cpCharge2.setRelatePartyId(cpCharge.getPartyId());//相关组织机构为当前操作的机构id
        			cpCharge2.setOperType(22L);//上级拨入操作
        			cpChargeManager.save(cpCharge2);
        		}else if(cpCharge.getOperType() == 24L){
        			CpCharge cpCharge2 = new CpCharge();
        			cpCharge2.setCreatedByUser(super.getCurrentUser().getId());
        			cpCharge2.setCreatedTime(new Date());
        			cpCharge2.setPartyId(2L);//相关的支部
        			cpCharge2.setCpTitle(cpCharge.getCpTitle());
        			cpCharge2.setBalance(cpCharge.getBalance());
        			cpCharge2.setAccountType(cpCharge.getAccountType());//下拨到拨款账户
        			cpCharge2.setIoType(-cpCharge.getIoType());
        			cpCharge2.setMemo(cpCharge.getMemo());
        			cpCharge2.setOperPeople(cpCharge.getOperPeople());
        			cpCharge2.setRelateAccountType(cpCharge.getAccountType());//相关账户为当前操作的账户
        			cpCharge2.setRelatePartyId(cpCharge.getPartyId());//相关组织机构为当前操作的机构id
        			cpCharge2.setOperType(25L);//上级拨入操作
        			cpChargeManager.save(cpCharge2);
        		}
        	}
        }else{
        	cpCharge.setLastUpdatedByUser(super.getCurrentUser().getId());
        	cpCharge.setLastUpdatedTime(new Date());
        }
        cpCharge = cpChargeManager.save(cpCharge);

        String key = (isNew) ? "cpCharge.added" : "cpCharge.updated";
        saveMessage(getText(key));

        super.setJsonResult("保存成功");
        return "jsonResult";
    }
    public String cpChargeOper(){
    	PartyGroup nowZhibu = getNowZhibu();
        if(nowZhibu!=null){
        	List chargeSumList = cpChargeManager.getChargeSumList(nowZhibu.getPartyId());
        	getRequest().setAttribute("chargeSumList", chargeSumList);
        }
    	return SUCCESS;
    }
    public String cpChargeSearch(){
    	PartyGroup nowZhibu = getNowZhibu();
        if(nowZhibu!=null){
        	List chargeSumList = cpChargeManager.getChargeSumList(nowZhibu.getPartyId());
        	getRequest().setAttribute("chargeSumList", chargeSumList);
        }
    	return SUCCESS;
    }
    
}