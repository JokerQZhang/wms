package com.joker.wms.webapp.action;

import com.opensymphony.xwork2.Preparable;
import com.joker.wms.service.ShipCarManager;
import com.joker.wms.dao.SearchException;
import com.joker.wms.model.ShipCar;
import com.joker.wms.webapp.action.BaseAction;

import java.util.Date;
import java.util.List;

public class ShipCarAction extends BaseAction implements Preparable {
    private ShipCarManager shipCarManager;
    private List shipCars;
    private ShipCar shipCar;
    private Long shipCarId;
    private String query;

    public void setShipCarManager(ShipCarManager shipCarManager) {
        this.shipCarManager = shipCarManager;
    }

    public List getShipCars() {
        return shipCars;
    }

    /**
     * Grab the entity from the database before populating with request parameters
     */
    public void prepare() {
        if (getRequest().getMethod().equalsIgnoreCase("post")) {
            // prevent failures on new
            String shipCarId = getRequest().getParameter("shipCar.shipCarId");
            if (shipCarId != null && !shipCarId.equals("")) {
                shipCar = shipCarManager.get(new Long(shipCarId));
            }
        }
    }

    public void setQ(String q) {
        this.query = q;
    }

    public String list() {
        try {
            shipCars = shipCarManager.search(query, ShipCar.class, getPage());
        } catch (SearchException se) {
            addActionError(se.getMessage());
            shipCars = shipCarManager.getAll(getPage());
        }
        if(query != null){
        	getRequest().setAttribute("showForm", "showData");
        }
        return SUCCESS;
    }

    public void setShipCarId(Long shipCarId) {
        this.shipCarId = shipCarId;
    }

    public ShipCar getShipCar() {
        return shipCar;
    }

    public void setShipCar(ShipCar shipCar) {
        this.shipCar = shipCar;
    }

    public String delete() {
        shipCarManager.remove(shipCar.getShipCarId());
        saveMessage(getText("shipCar.deleted"));

        return SUCCESS;
    }

    public String edit() {
        if (shipCarId != null) {
            shipCar = shipCarManager.get(shipCarId);
        } else {
            shipCar = new ShipCar();
        }

        return SUCCESS;
    }

    public String save() throws Exception {
        if (cancel != null) {
            super.setJsonResult("取消保存");
            return "jsonResult";
        }

        if (delete != null) {
            shipCarManager.remove(shipCar.getShipCarId());
        	super.setJsonResult("删除成功");
            return "jsonResult";
        }

        boolean isNew = (shipCar.getShipCarId() == null);
        
        shipCarManager.save(shipCar);

        String key = (isNew) ? "shipCar.added" : "shipCar.updated";
        saveMessage(getText(key));

        super.setJsonResult("保存成功");
        return "jsonResult";
    }
}