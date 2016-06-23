package com.joker.wms.webapp.action;

import com.opensymphony.xwork2.Preparable;
import com.joker.wms.service.FacilityManager;
import com.joker.wms.service.PartyGroupManager;
import com.joker.wms.dao.SearchException;
import com.joker.wms.model.Facility;
import com.joker.wms.model.PartyGroup;
import com.joker.wms.webapp.action.BaseAction;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FacilityAction extends BaseAction implements Preparable {
    private FacilityManager facilityManager;
    private List facilities;
    private Facility facility;
    private Long facilityId;
    private String query;
    private String groupId;
    private PartyGroupManager partyGroupManager;

    public void setPartyGroupManager(PartyGroupManager partyGroupManager) {
		this.partyGroupManager = partyGroupManager;
	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public void setFacilityManager(FacilityManager facilityManager) {
        this.facilityManager = facilityManager;
    }

    public List getFacilities() {
        return facilities;
    }

    /**
     * Grab the entity from the database before populating with request parameters
     */
    public void prepare() {
        if (getRequest().getMethod().equalsIgnoreCase("post")) {
            // prevent failures on new
            String facilityId = getRequest().getParameter("facility.facilityId");
            if (facilityId != null && !facilityId.equals("")) {
                facility = facilityManager.get(new Long(facilityId));
            }
        }
    }

    public void setQ(String q) {
        this.query = q;
    }

    public String list() {
        try {
        	if(groupId!=null && !"".equals(groupId)){
        		Map condition = new HashMap();
        		condition.put("groupId", groupId);
        		facilities = facilityManager.searchByCondition(condition, getPage());
        	}else{
        		facilities = facilityManager.search(query, Facility.class, getPage());
        	}
        } catch (SearchException se) {
            addActionError(se.getMessage());
            facilities = facilityManager.getAll(getPage());
        }
        if(query != null){
        	getRequest().setAttribute("showForm", "showData");
        }
        return SUCCESS;
    }

    public void setFacilityId(Long facilityId) {
        this.facilityId = facilityId;
    }

    public Facility getFacility() {
        return facility;
    }

    public void setFacility(Facility facility) {
        this.facility = facility;
    }

    public String delete() {
        facilityManager.remove(facility.getFacilityId());
        saveMessage(getText("facility.deleted"));

        return SUCCESS;
    }

    public String edit() {
        if (facilityId != null) {
            facility = facilityManager.get(facilityId);
        } else {
            facility = new Facility();
        }

        return SUCCESS;
    }

    public String save() throws Exception {
        if (cancel != null) {
            super.setJsonResult("取消保存");
            return "jsonResult";
        }

        if (delete != null) {
            facilityManager.remove(facility.getFacilityId());
        	super.setJsonResult("删除成功");
            return "jsonResult";
        }

        boolean isNew = (facility.getFacilityId() == null);
        if(isNew){
        	if(groupId!=null && !"".equals(groupId)){
        		PartyGroup partyGroup = partyGroupManager.get(Long.valueOf(groupId));
        		facility.setOwnerPartyId(partyGroup.getPartyId());
        	}
        }
        if(isNew){
        	facility.setCreatedByUser(getCurrentUser().getId());
        	facility.setCreatedTime(new Date());
        }else{
        	facility.setLastUpdatedByUser(getCurrentUser().getId());
        	facility.setLastUpdatedTime(new Date());
        }
        facilityManager.save(facility);

        String key = (isNew) ? "facility.added" : "facility.updated";
        saveMessage(getText(key));

        super.setJsonResult("保存成功");
        return "jsonResult";
    }
}