package com.joker.wms.webapp.action;

import com.opensymphony.xwork2.Preparable;
import com.joker.wms.service.PartyRelationshipManager;
import com.joker.wms.dao.SearchException;
import com.joker.wms.model.PartyRelationship;
import com.joker.wms.webapp.action.BaseAction;

import java.util.Date;
import java.util.List;

public class PartyRelationshipAction extends BaseAction implements Preparable {
    private PartyRelationshipManager partyRelationshipManager;
    private List partyRelationships;
    private PartyRelationship partyRelationship;
    private Long partyRelationshipId;
    private String query;
    private String vendorId;
    private String customerlist;

    public String getCustomerlist() {
		return customerlist;
	}

	public void setCustomerlist(String customerlist) {
		this.customerlist = customerlist;
	}

	public String getVendorId() {
		return vendorId;
	}

	public void setVendorId(String vendorId) {
		this.vendorId = vendorId;
	}

	public void setPartyRelationshipManager(PartyRelationshipManager partyRelationshipManager) {
        this.partyRelationshipManager = partyRelationshipManager;
    }

    public List getPartyRelationships() {
        return partyRelationships;
    }

    /**
     * Grab the entity from the database before populating with request parameters
     */
    public void prepare() {
        if (getRequest().getMethod().equalsIgnoreCase("post")) {
            // prevent failures on new
            String partyRelationshipId = getRequest().getParameter("partyRelationship.partyRelationshipId");
            if (partyRelationshipId != null && !partyRelationshipId.equals("")) {
                partyRelationship = partyRelationshipManager.get(new Long(partyRelationshipId));
            }
        }
    }

    public void setQ(String q) {
        this.query = q;
    }

    public String list() {
        try {
            partyRelationships = partyRelationshipManager.search(query, PartyRelationship.class, getPage());
        } catch (SearchException se) {
            addActionError(se.getMessage());
            partyRelationships = partyRelationshipManager.getAll(getPage());
        }
        if(query != null){
        	getRequest().setAttribute("showForm", "showData");
        }
        return SUCCESS;
    }

    public void setPartyRelationshipId(Long partyRelationshipId) {
        this.partyRelationshipId = partyRelationshipId;
    }

    public PartyRelationship getPartyRelationship() {
        return partyRelationship;
    }

    public void setPartyRelationship(PartyRelationship partyRelationship) {
        this.partyRelationship = partyRelationship;
    }

    public String delete() {
        partyRelationshipManager.remove(partyRelationship.getPartyRelationshipId());
        saveMessage(getText("partyRelationship.deleted"));

        return SUCCESS;
    }

    public String edit() {
        if (partyRelationshipId != null) {
            partyRelationship = partyRelationshipManager.get(partyRelationshipId);
        } else {
            partyRelationship = new PartyRelationship();
        }

        return SUCCESS;
    }

    public String save() throws Exception {
        if (cancel != null) {
            super.setJsonResult("取消保存");
            return "jsonResult";
        }

        if (delete != null) {
            partyRelationshipManager.remove(partyRelationship.getPartyRelationshipId());
        	super.setJsonResult("删除成功");
            return "jsonResult";
        }
        if(partyRelationship==null){
        	partyRelationship = new PartyRelationship();
        }
        boolean isNew = (partyRelationship.getPartyRelationshipId() == null);
        if(vendorId!=null && !"".equals(vendorId) && customerlist!=null && !"".equals(customerlist)){
        	partyRelationship.setPartyIdFrom(Long.valueOf(vendorId));
        	partyRelationship.setPartyIdTo(Long.valueOf(customerlist));
        	partyRelationship.setPartyRelationshipTypeId(2L);
        	partyRelationship.setStatusId(0L);
        	partyRelationship.setFromDate(new Date());
        	partyRelationship.setRoleTypeIdFrom(1l);
        	partyRelationship.setRoleTypeIdTo(1l);
        }
        if(isNew){
        	partyRelationship.setCreatedByUser(getCurrentUser().getId());
        	partyRelationship.setCreatedTime(new Date());
        }else{
        	partyRelationship.setLastUpdatedByUser(getCurrentUser().getId());
        	partyRelationship.setLastUpdatedTime(new Date());
        }
        partyRelationshipManager.save(partyRelationship);

        String key = (isNew) ? "partyRelationship.added" : "partyRelationship.updated";
        saveMessage(getText(key));

        super.setJsonResult("保存成功");
        return "jsonResult";
    }
}