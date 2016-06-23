package com.joker.wms.webapp.action;

import com.opensymphony.xwork2.Preparable;
import com.joker.wms.service.FacilityManager;
import com.joker.wms.service.ProductManager;
import com.joker.wms.service.SalePlanManager;
import com.joker.wms.dao.SearchException;
import com.joker.wms.model.Facility;
import com.joker.wms.model.SalePlan;
import com.joker.wms.webapp.action.BaseAction;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SalePlanAction extends BaseAction implements Preparable {
    private SalePlanManager salePlanManager;
    private List salePlans;
    private SalePlan salePlan;
    private Long salePlanId;
    private String query;
    private FacilityManager facilityManager;
    private String facilityId;
    private ProductManager productManager;

    public void setProductManager(ProductManager productManager) {
		this.productManager = productManager;
	}

	public String getFacilityId() {
		return facilityId;
	}

	public void setFacilityId(String facilityId) {
		this.facilityId = facilityId;
	}

	public void setFacilityManager(FacilityManager facilityManager) {
		this.facilityManager = facilityManager;
	}

	public void setSalePlanManager(SalePlanManager salePlanManager) {
        this.salePlanManager = salePlanManager;
    }

    public List getSalePlans() {
        return salePlans;
    }

    /**
     * Grab the entity from the database before populating with request parameters
     */
    public void prepare() {
        if (getRequest().getMethod().equalsIgnoreCase("post")) {
            // prevent failures on new
            String salePlanId = getRequest().getParameter("salePlan.salePlanId");
            if (salePlanId != null && !salePlanId.equals("")) {
                salePlan = salePlanManager.get(new Long(salePlanId));
            }
        }
    }

    public void setQ(String q) {
        this.query = q;
    }

    public String list() {
        try {
            //salePlans = salePlanManager.search(query, SalePlan.class, getPage());
            Map condition = new HashMap();
            List facilityList = facilityManager.getFacilityByUserId(getCurrentUser().getId().toString());
            String facilityIds = "";
            if(facilityList!=null && facilityList.size()>0){
            	for(int i=0; i<facilityList.size(); i++){
            		Facility facility = (Facility)facilityList.get(i);
            		if(i == 0){
            			facilityIds += facility.getFacilityId();
            		}else{
            			facilityIds += "," + facility.getFacilityId();
            		}
            	}
            }
            condition.put("facilityIds", facilityIds);
            salePlans = salePlanManager.searchByCondition(condition, getPage());
        } catch (SearchException se) {
            addActionError(se.getMessage());
            salePlans = salePlanManager.getAll(getPage());
        }
        if(query != null){
        	getRequest().setAttribute("showForm", "showData");
        }
        return SUCCESS;
    }

    public void setSalePlanId(Long salePlanId) {
        this.salePlanId = salePlanId;
    }

    public SalePlan getSalePlan() {
        return salePlan;
    }

    public void setSalePlan(SalePlan salePlan) {
        this.salePlan = salePlan;
    }

    public String delete() {
        salePlanManager.remove(salePlan.getSalePlanId());
        saveMessage(getText("salePlan.deleted"));

        return SUCCESS;
    }

    public String edit() {
        if (salePlanId != null) {
            salePlan = salePlanManager.get(salePlanId);
        } else {
            salePlan = new SalePlan();
        }
        List facilityList = facilityManager.getFacilityByUserId(getCurrentUser().getId().toString());
        String facilityOptions = "";
        if(facilityList!=null && facilityList.size()>0){
        	for(int i=0; i<facilityList.size(); i++){
        		Facility facility = (Facility)facilityList.get(i);
        		if(salePlan.getFacilityId()!=null && salePlan.getFacilityId()==facility.getFacilityId()){
        			facilityOptions += "<option value='" + facility.getFacilityId() + "' selected='selected'>" + facility.getFacilityName() + "</option>";
        		}else{
        			facilityOptions += "<option value='" + facility.getFacilityId() + "'>" + facility.getFacilityName() + "</option>";
        		}
        	}
        }
        getRequest().setAttribute("facilityOptions", facilityOptions);
        return SUCCESS;
    }

    public String save() throws Exception {
        if (cancel != null) {
            super.setJsonResult("取消保存");
            return "jsonResult";
        }

        if (delete != null) {
            salePlanManager.remove(salePlan.getSalePlanId());
        	super.setJsonResult("删除成功");
            return "jsonResult";
        }

        boolean isNew = (salePlan.getSalePlanId() == null);
        if(isNew){
        	salePlan.setCreatedByUser(getCurrentUser().getId());
        	salePlan.setCreatedTime(new Date());
        	if(salePlan.getDate()==null){
        		salePlan.setDate(new Date());
        	}
        	salePlan.setStatusId(1l);
        }else{
        	salePlan.setLastUpdatedByUser(getCurrentUser().getId());
        	salePlan.setLastUpdatedTime(new Date());
        }
        salePlan = salePlanManager.save(salePlan);
        salePlanManager.saveNewDtl(salePlan);
        salePlanManager.saveNewShipMent(salePlan);
        String key = (isNew) ? "salePlan.added" : "salePlan.updated";
        saveMessage(getText(key));

        super.setJsonResult("保存成功");
        return "jsonResult";
    }
    public String shipSalePlan(){
    	prepare();
    	if(salePlan.getStatusId() == 2){
    		super.setJsonResult("已经发货，无需重复操作！");
            return "jsonResult";
    	}else{
    		salePlan.setStatusId(2l);
    		salePlan.setLastUpdatedByUser(getCurrentUser().getId());
        	salePlan.setLastUpdatedTime(new Date());
        	salePlanManager.save(salePlan);//修改销售计划信息的状态
        	//更新shipment的shipdate
        	salePlanManager.updateShipDate(salePlan);
        	//将shipment保存到transaction表中国，作出库操作
        	salePlanManager.transactionFacility(salePlan);
    	}
    	
    	super.setJsonResult("发货成功");
        return "jsonResult";
    }
    public String facilityfill(){
    	String facilityOptions = "";
    	List facilityList = facilityManager.getFacilityByUserId(getCurrentUser().getId().toString());
    	if(facilityList!=null && facilityList.size()>0){
        	for(int i=0; i<facilityList.size(); i++){
        		Facility facility = (Facility)facilityList.get(i);
        		facilityOptions += "<option value='" + facility.getFacilityId() + "'>" + facility.getFacilityName() + "</option>";
        	}
        }
    	getRequest().setAttribute("facilityOptions", facilityOptions);
    	return SUCCESS;
    }
    public String invertorys(){
    	List invertoryList = salePlanManager.facilityInventory(facilityId, null);
    	Map invertoryMap = new HashMap();
    	if(invertoryList!=null && !invertoryList.isEmpty()){
    		for(int i=0; i<invertoryList.size(); i++){
    			Object[] obs = (Object[])invertoryList.get(i);
    			String productId = (obs[0]).toString();
    			if(obs[1] == null){
    				invertoryMap.put(productId, "0");
    			}else{
    				invertoryMap.put(productId, (obs[1]).toString());
    			}
    		}
    		
    	}
    	getRequest().setAttribute("invertoryMap", invertoryMap);
    	List productList = productManager.getAll();
    	getRequest().setAttribute("productList", productList);
    	getRequest().setAttribute("showForm", "showData");
    	return SUCCESS;
    }
}