package com.joker.wms.webapp.action;

import com.opensymphony.xwork2.Preparable;
import com.joker.wms.service.SalePlanManager;
import com.joker.wms.service.ShipCarManager;
import com.joker.wms.service.ShipmentManager;
import com.joker.wms.dao.SearchException;
import com.joker.wms.model.Facility;
import com.joker.wms.model.Product;
import com.joker.wms.model.SalePlan;
import com.joker.wms.model.SalePlanDtl;
import com.joker.wms.model.ShipCar;
import com.joker.wms.model.Shipment;
import com.joker.wms.webapp.action.BaseAction;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShipmentAction extends BaseAction implements Preparable {
    private ShipmentManager shipmentManager;
    private List shipments;
    private Shipment shipment;
    private Long shipmentId;
    private String query;
    private String salePlanId;
    private SalePlanManager salePlanManager;
    private ShipCarManager shipCarManager;
    
    public void setShipCarManager(ShipCarManager shipCarManager) {
		this.shipCarManager = shipCarManager;
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

	public void setShipmentManager(ShipmentManager shipmentManager) {
        this.shipmentManager = shipmentManager;
    }

    public List getShipments() {
        return shipments;
    }

    /**
     * Grab the entity from the database before populating with request parameters
     */
    public void prepare() {
        if (getRequest().getMethod().equalsIgnoreCase("post")) {
            // prevent failures on new
            String shipmentId = getRequest().getParameter("shipment.shipmentId");
            if (shipmentId != null && !shipmentId.equals("")) {
                shipment = shipmentManager.get(new Long(shipmentId));
            }
        }
    }

    public void setQ(String q) {
        this.query = q;
    }

    public String list() {
        try {
            //shipments = shipmentManager.search(query, Shipment.class, getPage());
        	Map condition = new HashMap();
            condition.put("salePlanId", salePlanId);
            condition.put("query", query);
            List multiShipmentList = shipmentManager.searchByCondition(condition, null);
            Map facilityMap = new HashMap();
            Map productMap = new HashMap();
            Map shipmentMap = new HashMap();
            if(multiShipmentList!=null && multiShipmentList.size()>0){
            	for(int i=0; i<multiShipmentList.size(); i++){
            		Object[] obs = (Object[])multiShipmentList.get(i);
            		Shipment oShipment = (Shipment)obs[0];
            		Facility oFacility = (Facility)obs[1];
            		Product oProduct = (Product)obs[2];
            		facilityMap.put(oFacility.getFacilityId(), oFacility);
            		productMap.put(oProduct.getProductId(), oProduct);
            		String keyFPPlan = oFacility.getFacilityId() + "-" + oProduct.getProductId();
            		shipmentMap.put(keyFPPlan, oShipment);
            	}
            }
            getRequest().setAttribute("facilityMap", facilityMap);
            getRequest().setAttribute("productMap", productMap);
            getRequest().setAttribute("shipmentMap", shipmentMap);
            getRequest().setAttribute("showForm", "showData");
            
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
            			invertoryMap.put(productId, (robs[1]).toString());
            		}
            	}
            }
            getRequest().setAttribute("invertoryMap", invertoryMap);
        } catch (SearchException se) {
            addActionError(se.getMessage());
            shipments = shipmentManager.getAll(getPage());
        }
        if(query != null){
        	getRequest().setAttribute("showForm", "showData");
        }
        return SUCCESS;
    }

    public void setShipmentId(Long shipmentId) {
        this.shipmentId = shipmentId;
    }

    public Shipment getShipment() {
        return shipment;
    }

    public void setShipment(Shipment shipment) {
        this.shipment = shipment;
    }

    public String delete() {
        shipmentManager.remove(shipment.getShipmentId());
        saveMessage(getText("shipment.deleted"));

        return SUCCESS;
    }

    public String edit() {
        if (shipmentId != null) {
            shipment = shipmentManager.get(shipmentId);
        } else {
            shipment = new Shipment();
        }
        String shipCarOptions = "";
        List shipCarList = shipCarManager.getAll();
        if(shipCarList!=null && shipCarList.size()>0){
        	for(int i=0; i<shipCarList.size(); i++){
        		ShipCar shipCar = (ShipCar)shipCarList.get(i);
        		if(shipCar.getShipCarId() == shipment.getShipCarId()){
        			shipCarOptions += "<option value='" + shipCar.getShipCarId() + "' selected='selected'>"+ shipCar.getCarCardId() + shipCar.getConName() +"</option>";
        		}else{
        			shipCarOptions += "<option value='" + shipCar.getShipCarId() + "'>"+ shipCar.getCarCardId() + shipCar.getConName() +"</option>";
        		}
        	}
        }
        getRequest().setAttribute("shipCarOptions", shipCarOptions);
        return SUCCESS;
    }

    public String save() throws Exception {
        if (cancel != null) {
            super.setJsonResult("取消保存");
            return "jsonResult";
        }
        
        SalePlan salePlan = salePlanManager.get(shipment.getSalePlanId());
        if(salePlan!=null && salePlan.getStatusId()!=null && salePlan.getStatusId()==2){
        	super.setJsonResult("已经发货，所有货运信息不允许修改！");
            return "jsonResult";
        }
        
        if (delete != null) {
            shipmentManager.remove(shipment.getShipmentId());
        	super.setJsonResult("删除成功");
            return "jsonResult";
        }

        boolean isNew = (shipment.getShipmentId() == null);
        if(isNew){
        	shipment.setCreatedByUser(getCurrentUser().getId());
        	shipment.setCreatedTime(new Date());
        }else{
        	shipment.setLastUpdatedByUser(getCurrentUser().getId());
        	shipment.setLastUpdatedTime(new Date());
        }
        shipment = shipmentManager.save(shipment);

        String key = (isNew) ? "shipment.added" : "shipment.updated";
        saveMessage(getText(key));

        super.setJsonResult("保存成功");
        return "jsonResult";
    }
}