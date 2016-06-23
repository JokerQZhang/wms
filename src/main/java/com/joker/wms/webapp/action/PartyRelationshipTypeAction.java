package com.joker.wms.webapp.action;

import com.opensymphony.xwork2.Preparable;
import com.joker.wms.service.PartyRelationshipTypeManager;
import com.joker.wms.dao.SearchException;
import com.joker.wms.model.PartyRelationshipType;
import com.joker.wms.webapp.action.BaseAction;

import java.util.Date;
import java.util.List;

public class PartyRelationshipTypeAction extends BaseAction implements Preparable {
    private PartyRelationshipTypeManager partyRelationshipTypeManager;
    private List partyRelationshipTypes;
    private PartyRelationshipType partyRelationshipType;
    private Long partyRelationshipTypeId;
    private String query;

    public void setPartyRelationshipTypeManager(PartyRelationshipTypeManager partyRelationshipTypeManager) {
        this.partyRelationshipTypeManager = partyRelationshipTypeManager;
    }

    public List getPartyRelationshipTypes() {
        return partyRelationshipTypes;
    }

    /**
     * Grab the entity from the database before populating with request parameters
     */
    public void prepare() {
        if (getRequest().getMethod().equalsIgnoreCase("post")) {
            // prevent failures on new
            String partyRelationshipTypeId = getRequest().getParameter("partyRelationshipType.partyRelationshipTypeId");
            if (partyRelationshipTypeId != null && !partyRelationshipTypeId.equals("")) {
                partyRelationshipType = partyRelationshipTypeManager.get(new Long(partyRelationshipTypeId));
            }
        }
    }

    public void setQ(String q) {
        this.query = q;
    }

    public String list() {
        try {
            partyRelationshipTypes = partyRelationshipTypeManager.search(query, PartyRelationshipType.class, getPage());
        } catch (SearchException se) {
            addActionError(se.getMessage());
            partyRelationshipTypes = partyRelationshipTypeManager.getAll(getPage());
        }
        if(query != null){
        	getRequest().setAttribute("showForm", "showData");
        }
        return SUCCESS;
    }

    public void setPartyRelationshipTypeId(Long partyRelationshipTypeId) {
        this.partyRelationshipTypeId = partyRelationshipTypeId;
    }

    public PartyRelationshipType getPartyRelationshipType() {
        return partyRelationshipType;
    }

    public void setPartyRelationshipType(PartyRelationshipType partyRelationshipType) {
        this.partyRelationshipType = partyRelationshipType;
    }

    public String delete() {
        partyRelationshipTypeManager.remove(partyRelationshipType.getPartyRelationshipTypeId());
        saveMessage(getText("partyRelationshipType.deleted"));

        return SUCCESS;
    }

    public String edit() {
        if (partyRelationshipTypeId != null) {
            partyRelationshipType = partyRelationshipTypeManager.get(partyRelationshipTypeId);
        } else {
            partyRelationshipType = new PartyRelationshipType();
        }

        return SUCCESS;
    }

    public String save() throws Exception {
        if (cancel != null) {
            super.setJsonResult("取消保存");
            return "jsonResult";
        }

        if (delete != null) {
            partyRelationshipTypeManager.remove(partyRelationshipType.getPartyRelationshipTypeId());
        	super.setJsonResult("删除成功");
            return "jsonResult";
        }

        boolean isNew = (partyRelationshipType.getPartyRelationshipTypeId() == null);
        if(isNew){
        	partyRelationshipType.setCreatedByUser(getCurrentUser().getId());
        	partyRelationshipType.setCreatedTime(new Date());
        }else{
        	partyRelationshipType.setLastUpdatedByUser(getCurrentUser().getId());
        	partyRelationshipType.setLastUpdatedTime(new Date());
        }
        partyRelationshipTypeManager.save(partyRelationshipType);

        String key = (isNew) ? "partyRelationshipType.added" : "partyRelationshipType.updated";
        saveMessage(getText(key));

        super.setJsonResult("保存成功");
        return "jsonResult";
    }
}