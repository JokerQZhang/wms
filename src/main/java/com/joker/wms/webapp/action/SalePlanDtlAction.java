package com.joker.wms.webapp.action;

import com.opensymphony.xwork2.Preparable;
import com.joker.wms.service.SalePlanDtlManager;
import com.joker.wms.service.SalePlanManager;
import com.joker.wms.service.ShipmentManager;
import com.joker.wms.dao.SearchException;
import com.joker.wms.model.Facility;
import com.joker.wms.model.Product;
import com.joker.wms.model.SalePlan;
import com.joker.wms.model.SalePlanDtl;
import com.joker.wms.model.Shipment;
import com.joker.wms.webapp.action.BaseAction;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SalePlanDtlAction extends BaseAction implements Preparable {
    private SalePlanDtlManager salePlanDtlManager;
    private List salePlanDtls;
    private SalePlanDtl salePlanDtl;
    private Long salePlanDtlId;
    private String query;
    private String salePlanId;
    private SalePlanManager salePlanManager;
    private ShipmentManager shipmentManager;

    public void setShipmentManager(ShipmentManager shipmentManager) {
		this.shipmentManager = shipmentManager;
	}

	public void setSalePlanManager(SalePlanManager salePlanManager) {
		this.salePlanManager = salePlanManager;
	}

	public String getSalePlanId() {
		return salePlanId;
	}

	public void setSalePlanId(String salePlanId) {
		this.salePlanId = salePlanId;
	}

	public void setSalePlanDtlManager(SalePlanDtlManager salePlanDtlManager) {
        this.salePlanDtlManager = salePlanDtlManager;
    }

    public List getSalePlanDtls() {
        return salePlanDtls;
    }

    /**
     * Grab the entity from the database before populating with request parameters
     */
    public void prepare() {
        if (getRequest().getMethod().equalsIgnoreCase("post")) {
            // prevent failures on new
            String salePlanDtlId = getRequest().getParameter("salePlanDtl.salePlanDtlId");
            if (salePlanDtlId != null && !salePlanDtlId.equals("")) {
                salePlanDtl = salePlanDtlManager.get(new Long(salePlanDtlId));
            }
        }
    }

    public void setQ(String q) {
        this.query = q;
    }

    public String list() {
        try {
            //salePlanDtls = salePlanDtlManager.search(query, SalePlanDtl.class, getPage());
            Map condition = new HashMap();
            condition.put("salePlanId", salePlanId);
            condition.put("query", query);
            List multSalePlanDtls = salePlanDtlManager.searchByCondition(condition, null);
            Map facilityMap = new HashMap();
            Map productMap = new HashMap();
            Map salePlanMap = new HashMap();
            if(multSalePlanDtls!=null && multSalePlanDtls.size()>0){
            	for(int i=0; i<multSalePlanDtls.size(); i++){
            		Object[] obs = (Object[])multSalePlanDtls.get(i);
            		SalePlanDtl oSalePlanDtl = (SalePlanDtl)obs[0];
            		Facility oFacility = (Facility)obs[1];
            		Product oProduct = (Product)obs[2];
            		facilityMap.put(oFacility.getFacilityId(), oFacility);
            		productMap.put(oProduct.getProductId(), oProduct);
            		String keyFPPlan = oFacility.getFacilityId() + "-" + oProduct.getProductId();
            		salePlanMap.put(keyFPPlan, oSalePlanDtl);
            	}
            }
            getRequest().setAttribute("facilityMap", facilityMap);
            getRequest().setAttribute("productMap", productMap);
            getRequest().setAttribute("salePlanMap", salePlanMap);
            getRequest().setAttribute("showForm", "showData");
            //salePlanDtls
            //获取客户列表和商品列表
            //获取目前库存
            SalePlan salePlan = salePlanManager.get(Long.valueOf(salePlanId));
            List fi = salePlanManager.facilityInventory(salePlan.getFacilityId().toString(), null);
            Map invertoryMap = new HashMap();
            if(fi!=null && fi.size()>0){
            	for(int i=0; i<fi.size(); i++){
            		Object[] robs = (Object[])fi.get(i);
            		String productId = (robs[0]).toString();
            		if(robs[1] == null){
            			invertoryMap.put(productId, "0");
            		}else{
            			invertoryMap.put(productId, robs[1].toString());
            		}
            	}
            }
            getRequest().setAttribute("invertoryMap", invertoryMap);
        } catch (SearchException se) {
            addActionError(se.getMessage());
            salePlanDtls = salePlanDtlManager.getAll(getPage());
        }
        if(query != null){
        	getRequest().setAttribute("showForm", "showData");
        }
        return SUCCESS;
    }

    public void setSalePlanDtlId(Long salePlanDtlId) {
        this.salePlanDtlId = salePlanDtlId;
    }

    public SalePlanDtl getSalePlanDtl() {
        return salePlanDtl;
    }

    public void setSalePlanDtl(SalePlanDtl salePlanDtl) {
        this.salePlanDtl = salePlanDtl;
    }

    public String delete() {
        salePlanDtlManager.remove(salePlanDtl.getSalePlanDtlId());
        saveMessage(getText("salePlanDtl.deleted"));

        return SUCCESS;
    }

    public String edit() {
        if (salePlanDtlId != null) {
            salePlanDtl = salePlanDtlManager.get(salePlanDtlId);
        } else {
            salePlanDtl = new SalePlanDtl();
        }

        return SUCCESS;
    }

    public String save() throws Exception {
        if (cancel != null) {
            super.setJsonResult("取消保存");
            return "jsonResult";
        }
        
        SalePlan salePlan = salePlanManager.get(salePlanDtl.getSalePlanId());
        if(salePlan!=null && salePlan.getStatusId()!=null && salePlan.getStatusId()==2){
        	super.setJsonResult("已经发货，所有货运信息不允许修改！");
            return "jsonResult";
        }
        
        if (delete != null) {
            salePlanDtlManager.remove(salePlanDtl.getSalePlanDtlId());
        	super.setJsonResult("删除成功");
            return "jsonResult";
        }

        boolean isNew = (salePlanDtl.getSalePlanDtlId() == null);
        if(isNew){
        	salePlanDtl.setCreatedByUser(getCurrentUser().getId());
        	salePlanDtl.setCreatedTime(new Date());
        }else{
        	salePlanDtl.setLastUpdatedByUser(getCurrentUser().getId());
        	salePlanDtl.setLastUpdatedTime(new Date());
        	//修改相应的货运信息
        	Shipment shipment = shipmentManager.getShipmentBySPD(salePlanDtl);
        	shipment.setLastUpdatedByUser(getCurrentUser().getId());
        	shipment.setLastUpdatedTime(new Date());
        	shipment.setNum(salePlanDtl.getNum());
        	shipmentManager.save(shipment);
        }
        salePlanDtl = salePlanDtlManager.save(salePlanDtl);

        String key = (isNew) ? "salePlanDtl.added" : "salePlanDtl.updated";
        saveMessage(getText(key));

        super.setJsonResult("保存成功");
        return "jsonResult";
    }
}