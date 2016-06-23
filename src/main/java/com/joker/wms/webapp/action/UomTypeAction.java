package com.joker.wms.webapp.action;

import com.opensymphony.xwork2.Preparable;
import com.joker.wms.service.UomTypeManager;
import com.joker.wms.dao.SearchException;
import com.joker.wms.model.UomType;
import com.joker.wms.webapp.action.BaseAction;

import java.util.Date;
import java.util.List;

public class UomTypeAction extends BaseAction implements Preparable {
    private UomTypeManager uomTypeManager;
    private List uomTypes;
    private UomType uomType;
    private Long uomTypeId;
    private String query;

    public void setUomTypeManager(UomTypeManager uomTypeManager) {
        this.uomTypeManager = uomTypeManager;
    }

    public List getUomTypes() {
        return uomTypes;
    }

    /**
     * Grab the entity from the database before populating with request parameters
     */
    public void prepare() {
        if (getRequest().getMethod().equalsIgnoreCase("post")) {
            // prevent failures on new
            String uomTypeId = getRequest().getParameter("uomType.uomTypeId");
            if (uomTypeId != null && !uomTypeId.equals("")) {
                uomType = uomTypeManager.get(new Long(uomTypeId));
            }
        }
    }

    public void setQ(String q) {
        this.query = q;
    }

    public String list() {
        try {
            uomTypes = uomTypeManager.search(query, UomType.class, getPage());
        } catch (SearchException se) {
            addActionError(se.getMessage());
            uomTypes = uomTypeManager.getAll(getPage());
        }
        if(query != null){
        	getRequest().setAttribute("showForm", "showData");
        }
        return SUCCESS;
    }

    public void setUomTypeId(Long uomTypeId) {
        this.uomTypeId = uomTypeId;
    }

    public UomType getUomType() {
        return uomType;
    }

    public void setUomType(UomType uomType) {
        this.uomType = uomType;
    }

    public String delete() {
        uomTypeManager.remove(uomType.getUomTypeId());
        saveMessage(getText("uomType.deleted"));

        return SUCCESS;
    }

    public String edit() {
        if (uomTypeId != null) {
            uomType = uomTypeManager.get(uomTypeId);
        } else {
            uomType = new UomType();
        }

        return SUCCESS;
    }

    public String save() throws Exception {
        if (cancel != null) {
            super.setJsonResult("取消保存");
            return "jsonResult";
        }

        if (delete != null) {
            uomTypeManager.remove(uomType.getUomTypeId());
        	super.setJsonResult("删除成功");
            return "jsonResult";
        }

        boolean isNew = (uomType.getUomTypeId() == null);
        if(isNew){
        	uomType.setCreatedByUser(getCurrentUser().getId());
        	uomType.setCreatedTime(new Date());
        }else{
        	uomType.setLastUpdatedByUser(getCurrentUser().getId());
        	uomType.setLastUpdatedTime(new Date());
        }
        uomTypeManager.save(uomType);

        String key = (isNew) ? "uomType.added" : "uomType.updated";
        saveMessage(getText(key));

        super.setJsonResult("保存成功");
        return "jsonResult";
    }
}