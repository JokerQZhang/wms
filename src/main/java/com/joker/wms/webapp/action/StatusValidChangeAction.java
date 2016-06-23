package com.joker.wms.webapp.action;

import com.opensymphony.xwork2.Preparable;
import com.joker.wms.service.StatusValidChangeManager;
import com.joker.wms.dao.SearchException;
import com.joker.wms.model.StatusValidChange;
import com.joker.wms.webapp.action.BaseAction;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StatusValidChangeAction extends BaseAction implements Preparable {
    private StatusValidChangeManager statusValidChangeManager;
    private List statusValidChanges;
    private StatusValidChange statusValidChange;
    private Long svcId;
    private String query;
    private String selectedStatusTypeId;

    public String getSelectedStatusTypeId() {
		return selectedStatusTypeId;
	}

	public void setSelectedStatusTypeId(String selectedStatusTypeId) {
		this.selectedStatusTypeId = selectedStatusTypeId;
	}

    public void setStatusValidChangeManager(StatusValidChangeManager statusValidChangeManager) {
        this.statusValidChangeManager = statusValidChangeManager;
    }

    public List getStatusValidChanges() {
        return statusValidChanges;
    }

    /**
     * Grab the entity from the database before populating with request parameters
     */
    public void prepare() {
        if (getRequest().getMethod().equalsIgnoreCase("post")) {
            // prevent failures on new
            String statusValidChangeId = getRequest().getParameter("statusValidChange.svcId");
            if (statusValidChangeId != null && !statusValidChangeId.equals("")) {
                statusValidChange = statusValidChangeManager.get(new Long(statusValidChangeId));
            }
        }
    }

    public void setQ(String q) {
        this.query = q;
    }

    public String list() {
        try {
        	if(selectedStatusTypeId!=null && !"".equals(selectedStatusTypeId)){
        		List multiVC = statusValidChangeManager.searchByTypeId(selectedStatusTypeId, StatusValidChange.class, getPage());
        		if(multiVC!=null && multiVC.size()>0){
        			statusValidChanges = new ArrayList<StatusValidChange>();
        			Map vcExtends = new HashMap();
        			for(int i=0; i<multiVC.size(); i++){
        				Object[] lists = (Object[])multiVC.get(i);
        				StatusValidChange statusValidChange = (StatusValidChange)lists[0];
        				statusValidChanges.add(statusValidChange);
        				vcExtends.put(statusValidChange.getSvcId().toString(), lists);
        			}
        			getRequest().setAttribute("vcExtends", vcExtends);
        		}
        	}else{
        		statusValidChanges = statusValidChangeManager.search(query, StatusValidChange.class, getPage());
        	}
        } catch (SearchException se) {
            addActionError(se.getMessage());
            statusValidChanges = statusValidChangeManager.getAll(getPage());
        }
        if(query != null){
        	getRequest().setAttribute("showForm", "showData");
        }
        return SUCCESS;
    }

    public void setSvcId(Long svcId) {
        this.svcId = svcId;
    }

    public StatusValidChange getStatusValidChange() {
        return statusValidChange;
    }

    public void setStatusValidChange(StatusValidChange statusValidChange) {
        this.statusValidChange = statusValidChange;
    }

    public String delete() {
        statusValidChangeManager.remove(statusValidChange.getSvcId());
        saveMessage(getText("statusValidChange.deleted"));

        return SUCCESS;
    }

    public String edit() {
        if (svcId != null) {
            statusValidChange = statusValidChangeManager.get(svcId);
        } else {
            statusValidChange = new StatusValidChange();
        }

        return SUCCESS;
    }

    public String save() throws Exception {
        if (cancel != null) {
            super.setJsonResult("取消保存");
            return "jsonResult";
        }

        if (delete != null) {
            statusValidChangeManager.remove(statusValidChange.getSvcId());
        	super.setJsonResult("删除成功");
            return "jsonResult";
        }

        boolean isNew = (statusValidChange.getSvcId() == null);
        if(isNew){
        	statusValidChange.setCreatedByUser(getCurrentUser().getId());
        	statusValidChange.setCreatedTime(new Date());
        }else{
        	statusValidChange.setLastUpdatedByUser(getCurrentUser().getId());
        	statusValidChange.setLastUpdatedTime(new Date());
        }
        statusValidChangeManager.save(statusValidChange);

        String key = (isNew) ? "statusValidChange.added" : "statusValidChange.updated";
        saveMessage(getText(key));

        super.setJsonResult("保存成功");
        return "jsonResult";
    }
}