package com.joker.wms.webapp.action;

import com.opensymphony.xwork2.Preparable;
import com.joker.wms.service.PetitionFlowManager;
import com.joker.wms.dao.SearchException;
import com.joker.wms.model.PetitionFlow;
import com.joker.wms.webapp.action.BaseAction;

import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class PetitionFlowAction extends BaseAction implements Preparable {
    private PetitionFlowManager petitionFlowManager;
    private List petitionFlows;
    private PetitionFlow petitionFlow;
    private Long petitionFlowId;
    private String query;

    public void setPetitionFlowManager(PetitionFlowManager petitionFlowManager) {
        this.petitionFlowManager = petitionFlowManager;
    }

    public List getPetitionFlows() {
        return petitionFlows;
    }

    /**
     * Grab the entity from the database before populating with request parameters
     */
    public void prepare() {
        if (getRequest().getMethod().equalsIgnoreCase("post")) {
            // prevent failures on new
            String petitionFlowId = getRequest().getParameter("petitionFlow.petitionFlowId");
            if (petitionFlowId != null && !petitionFlowId.equals("")) {
                petitionFlow = petitionFlowManager.get(new Long(petitionFlowId));
            }
        }
    }

    public void setQ(String q) {
        this.query = q;
    }

    public String list() {
        try {
        	Map condition = new HashMap();
            petitionFlows = petitionFlowManager.search(condition, PetitionFlow.class, getPage());
        } catch (SearchException se) {
            addActionError(se.getMessage());
            petitionFlows = petitionFlowManager.getAll(getPage());
        }
        if(query != null){
        	getRequest().setAttribute("showForm", "showData");
        }
        return SUCCESS;
    }

    public void setPetitionFlowId(Long petitionFlowId) {
        this.petitionFlowId = petitionFlowId;
    }

    public PetitionFlow getPetitionFlow() {
        return petitionFlow;
    }

    public void setPetitionFlow(PetitionFlow petitionFlow) {
        this.petitionFlow = petitionFlow;
    }

    public String delete() {
        petitionFlowManager.remove(petitionFlow.getPetitionFlowId());
        saveMessage(getText("petitionFlow.deleted"));

        return SUCCESS;
    }

    public String edit() {
        if (petitionFlowId != null) {
            petitionFlow = petitionFlowManager.get(petitionFlowId);
        } else {
            petitionFlow = new PetitionFlow();
        }

        return SUCCESS;
    }

    public String save() throws Exception {
        if (cancel != null) {
            super.setJsonResult("取消保存");
            return "jsonResult";
        }

        if (delete != null) {
            petitionFlowManager.remove(petitionFlow.getPetitionFlowId());
        	super.setJsonResult("删除成功");
            return "jsonResult";
        }

        boolean isNew = (petitionFlow.getPetitionFlowId() == null);

        petitionFlow = petitionFlowManager.save(petitionFlow);

        String key = (isNew) ? "petitionFlow.added" : "petitionFlow.updated";
        saveMessage(getText(key));

        super.setJsonResult("保存成功");
        return "jsonResult";
    }
}