package com.joker.wms.webapp.action;

import com.opensymphony.xwork2.Preparable;
import com.joker.wms.service.ApprovalProjManager;
import com.joker.wms.dao.SearchException;
import com.joker.wms.model.ApprovalProj;
import com.joker.wms.webapp.action.BaseAction;

import java.util.Date;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class ApprovalProjAction extends BaseAction implements Preparable {
    private ApprovalProjManager approvalProjManager;
    private List approvalProjs;
    private ApprovalProj approvalProj;
    private Long approvalProjId;
    private String query;

    public void setApprovalProjManager(ApprovalProjManager approvalProjManager) {
        this.approvalProjManager = approvalProjManager;
    }

    public List getApprovalProjs() {
        return approvalProjs;
    }

    /**
     * Grab the entity from the database before populating with request parameters
     */
    public void prepare() {
        if (getRequest().getMethod().equalsIgnoreCase("post")) {
            // prevent failures on new
            String approvalProjId = getRequest().getParameter("approvalProj.approvalProjId");
            if (approvalProjId != null && !approvalProjId.equals("")) {
                approvalProj = approvalProjManager.get(new Long(approvalProjId));
            }
        }
    }

    public void setQ(String q) {
        this.query = q;
    }

    public String list() {
        try {
        	Map condition = new HashMap();
        	String partyId = getRequest().getParameter("partyId");
        	if(partyId!=null && !partyId.equals("")){
        		condition.put("partyId", partyId);
        	}
        	
            approvalProjs = approvalProjManager.search(condition, ApprovalProj.class, getPage());
        } catch (SearchException se) {
            addActionError(se.getMessage());
            approvalProjs = approvalProjManager.getAll(getPage());
        }
        if(query != null){
        	getRequest().setAttribute("showForm", "showData");
        }
        return SUCCESS;
    }

    public void setApprovalProjId(Long approvalProjId) {
        this.approvalProjId = approvalProjId;
    }

    public ApprovalProj getApprovalProj() {
        return approvalProj;
    }

    public void setApprovalProj(ApprovalProj approvalProj) {
        this.approvalProj = approvalProj;
    }

    public String delete() {
        approvalProjManager.remove(approvalProj.getApprovalProjId());
        saveMessage(getText("approvalProj.deleted"));

        return SUCCESS;
    }

    public String edit() {
        if (approvalProjId != null) {
            approvalProj = approvalProjManager.get(approvalProjId);
        } else {
            approvalProj = new ApprovalProj();
        }

        return SUCCESS;
    }

    public String save() throws Exception {
        if (cancel != null) {
            super.setJsonResult("取消保存");
            return "jsonResult";
        }

        if (delete != null) {
            approvalProjManager.remove(approvalProj.getApprovalProjId());
        	super.setJsonResult("删除成功");
            return "jsonResult";
        }

        boolean isNew = (approvalProj.getApprovalProjId() == null);
        if(isNew){
        	approvalProj.setCreatedByUser(super.getCurrentUser().getId());
        	approvalProj.setCreatedTime(new Date());
        }else{
        	approvalProj.setLastUpdatedByUser(super.getCurrentUser().getId());
        	approvalProj.setLastUpdatedTime(new Date());
        }
        approvalProj = approvalProjManager.save(approvalProj);

        String key = (isNew) ? "approvalProj.added" : "approvalProj.updated";
        saveMessage(getText(key));

        super.setJsonResult("保存成功");
        return "jsonResult";
    }
    public String approvalsearch(){
    	
    	return SUCCESS;
    }
}