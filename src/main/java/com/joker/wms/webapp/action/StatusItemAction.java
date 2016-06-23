package com.joker.wms.webapp.action;

import com.opensymphony.xwork2.Preparable;
import com.joker.wms.service.StatusItemManager;
import com.joker.wms.dao.SearchException;
import com.joker.wms.model.StatusItem;
import com.joker.wms.webapp.action.BaseAction;

import java.util.Date;
import java.util.List;

public class StatusItemAction extends BaseAction implements Preparable {
    private StatusItemManager statusItemManager;
    private List statusItems;
    private StatusItem statusItem;
    private Long statusId;
    private String query;
    private String selectedStatusTypeId;

    public String getSelectedStatusTypeId() {
		return selectedStatusTypeId;
	}

	public void setSelectedStatusTypeId(String selectedStatusTypeId) {
		this.selectedStatusTypeId = selectedStatusTypeId;
	}

	public void setStatusItemManager(StatusItemManager statusItemManager) {
        this.statusItemManager = statusItemManager;
    }

    public List getStatusItems() {
        return statusItems;
    }

    /**
     * Grab the entity from the database before populating with request parameters
     */
    public void prepare() {
        if (getRequest().getMethod().equalsIgnoreCase("post")) {
            // prevent failures on new
            String statusItemId = getRequest().getParameter("statusItem.statusId");
            if (statusItemId != null && !statusItemId.equals("")) {
                statusItem = statusItemManager.get(new Long(statusItemId));
            }
        }
    }

    public void setQ(String q) {
        this.query = q;
    }

    public String list() {
        try {
        	if(selectedStatusTypeId!=null && !"".equals(selectedStatusTypeId)){
        		statusItems = statusItemManager.searchByTypeId(selectedStatusTypeId, StatusItem.class, getPage());
        	}else{
        		statusItems = statusItemManager.search(query, StatusItem.class, getPage());
        	}
        } catch (SearchException se) {
            addActionError(se.getMessage());
            statusItems = statusItemManager.getAll(getPage());
        }
        if(query != null){
        	getRequest().setAttribute("showForm", "showData");
        }
        return SUCCESS;
    }

    public void setStatusId(Long statusId) {
        this.statusId = statusId;
    }

    public StatusItem getStatusItem() {
        return statusItem;
    }

    public void setStatusItem(StatusItem statusItem) {
        this.statusItem = statusItem;
    }

    public String delete() {
        statusItemManager.remove(statusItem.getStatusId());
        saveMessage(getText("statusItem.deleted"));

        return SUCCESS;
    }

    public String edit() {
        if (statusId != null) {
            statusItem = statusItemManager.get(statusId);
        } else {
            statusItem = new StatusItem();
        }

        return SUCCESS;
    }

    public String save() throws Exception {
        if (cancel != null) {
            super.setJsonResult("取消保存");
            return "jsonResult";
        }

        if (delete != null) {
            statusItemManager.remove(statusItem.getStatusId());
        	super.setJsonResult("删除成功");
            return "jsonResult";
        }

        boolean isNew = (statusItem.getStatusId() == null);
        if(isNew){
        	statusItem.setCreatedByUser(getCurrentUser().getId());
        	statusItem.setCreatedTime(new Date());
        }else{
        	statusItem.setLastUpdatedByUser(getCurrentUser().getId());
        	statusItem.setLastUpdatedTime(new Date());
        }
        statusItemManager.save(statusItem);

        String key = (isNew) ? "statusItem.added" : "statusItem.updated";
        saveMessage(getText(key));

        super.setJsonResult("保存成功");
        return "jsonResult";
    }
}