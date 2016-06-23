package com.joker.wms.webapp.action;

import com.opensymphony.xwork2.Preparable;
import com.joker.wms.service.EnumerationTypeManager;
import com.joker.wms.dao.SearchException;
import com.joker.wms.model.EnumerationType;
import com.joker.wms.webapp.action.BaseAction;

import java.util.Date;
import java.util.List;

public class EnumerationTypeAction extends BaseAction implements Preparable {
    private EnumerationTypeManager enumerationTypeManager;
    private List enumerationTypes;
    private EnumerationType enumerationType;
    private Long enumTypeId;
    private String query;

    public void setEnumerationTypeManager(EnumerationTypeManager enumerationTypeManager) {
        this.enumerationTypeManager = enumerationTypeManager;
    }

    public List getEnumerationTypes() {
        return enumerationTypes;
    }

    /**
     * Grab the entity from the database before populating with request parameters
     */
    public void prepare() {
        if (getRequest().getMethod().equalsIgnoreCase("post")) {
            // prevent failures on new
            String enumerationTypeId = getRequest().getParameter("enumerationType.enumTypeId");
            if (enumerationTypeId != null && !enumerationTypeId.equals("")) {
                enumerationType = enumerationTypeManager.get(new Long(enumerationTypeId));
            }
        }
    }

    public void setQ(String q) {
        this.query = q;
    }

    public String list() {
        try {
            enumerationTypes = enumerationTypeManager.search(query, EnumerationType.class, getPage());
        } catch (SearchException se) {
            addActionError(se.getMessage());
            enumerationTypes = enumerationTypeManager.getAll(getPage());
        }
        if(query != null){
        	getRequest().setAttribute("showForm", "showData");
        }
        return SUCCESS;
    }

    public void setEnumTypeId(Long enumTypeId) {
        this.enumTypeId = enumTypeId;
    }

    public EnumerationType getEnumerationType() {
        return enumerationType;
    }

    public void setEnumerationType(EnumerationType enumerationType) {
        this.enumerationType = enumerationType;
    }

    public String delete() {
        enumerationTypeManager.remove(enumerationType.getEnumTypeId());
        saveMessage(getText("enumerationType.deleted"));

        return SUCCESS;
    }

    public String edit() {
        if (enumTypeId != null) {
            enumerationType = enumerationTypeManager.get(enumTypeId);
        } else {
            enumerationType = new EnumerationType();
        }

        return SUCCESS;
    }

    public String save() throws Exception {
        if (cancel != null) {
            super.setJsonResult("取消保存");
            return "jsonResult";
        }

        if (delete != null) {
            enumerationTypeManager.remove(enumerationType.getEnumTypeId());
        	super.setJsonResult("删除成功");
            return "jsonResult";
        }

        boolean isNew = (enumerationType.getEnumTypeId() == null);
        if(isNew){
        	enumerationType.setCreatedByUser(getCurrentUser().getId());
        	enumerationType.setCreatedTime(new Date());
        }else{
        	enumerationType.setLastUpdatedByUser(getCurrentUser().getId());
        	enumerationType.setLastUpdatedTime(new Date());
        }
        enumerationTypeManager.save(enumerationType);

        String key = (isNew) ? "enumerationType.added" : "enumerationType.updated";
        saveMessage(getText(key));

        super.setJsonResult("保存成功");
        return "jsonResult";
    }
}