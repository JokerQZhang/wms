package com.joker.wms.webapp.action;

import com.opensymphony.xwork2.Preparable;
import com.joker.wms.service.StatusTypeManager;
import com.joker.wms.dao.SearchException;
import com.joker.wms.model.StatusType;
import com.joker.wms.webapp.action.BaseAction;

import java.util.Date;
import java.util.List;

public class StatusTypeAction extends BaseAction implements Preparable {
    private StatusTypeManager statusTypeManager;
    private List statusTypes;
    private StatusType statusType;
    private Long statusTypeId;
    private String query;

    public void setStatusTypeManager(StatusTypeManager statusTypeManager) {
        this.statusTypeManager = statusTypeManager;
    }

    public List getStatusTypes() {
        return statusTypes;
    }

    /**
     * Grab the entity from the database before populating with request parameters
     */
    public void prepare() {
        if (getRequest().getMethod().equalsIgnoreCase("post")) {
            // prevent failures on new
            String statusTypeId = getRequest().getParameter("statusType.statusTypeId");
            if (statusTypeId != null && !statusTypeId.equals("")) {
                statusType = statusTypeManager.get(new Long(statusTypeId));
            }
        }
    }

    public void setQ(String q) {
        this.query = q;
    }

    public String list() {
        try {
            statusTypes = statusTypeManager.search(query, StatusType.class, getPage());
        } catch (SearchException se) {
            addActionError(se.getMessage());
            statusTypes = statusTypeManager.getAll(getPage());
        }
        if(query != null){
        	getRequest().setAttribute("showForm", "showData");
        }
        return SUCCESS;
    }

    public void setStatusTypeId(Long statusTypeId) {
        this.statusTypeId = statusTypeId;
    }

    public StatusType getStatusType() {
        return statusType;
    }

    public void setStatusType(StatusType statusType) {
        this.statusType = statusType;
    }

    public String delete() {
        statusTypeManager.remove(statusType.getStatusTypeId());
        saveMessage(getText("statusType.deleted"));

        return SUCCESS;
    }

    public String edit() {
        if (statusTypeId != null) {
            statusType = statusTypeManager.get(statusTypeId);
        } else {
            statusType = new StatusType();
        }

        return SUCCESS;
    }

    public String save() throws Exception {
        if (cancel != null) {
            super.setJsonResult("取消保存");
            return "jsonResult";
        }

        if (delete != null) {
            statusTypeManager.remove(statusType.getStatusTypeId());
        	super.setJsonResult("删除成功");
            return "jsonResult";
        }

        boolean isNew = (statusType.getStatusTypeId() == null);
        if(isNew){
        	statusType.setCreatedByUser(getCurrentUser().getId());
        	statusType.setCreatedTime(new Date());
        }else{
        	statusType.setLastUpdatedByUser(getCurrentUser().getId());
        	statusType.setLastUpdatedTime(new Date());
        }
        statusTypeManager.save(statusType);

        String key = (isNew) ? "statusType.added" : "statusType.updated";
        saveMessage(getText(key));

        super.setJsonResult("保存成功");
        return "jsonResult";
    }
}