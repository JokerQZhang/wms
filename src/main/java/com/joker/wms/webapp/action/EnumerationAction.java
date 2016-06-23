package com.joker.wms.webapp.action;

import com.opensymphony.xwork2.Preparable;
import com.joker.wms.service.EnumerationManager;
import com.joker.wms.util.PinYinUtil;
import com.joker.wms.dao.SearchException;
import com.joker.wms.model.Enumeration;
import com.joker.wms.model.EnumerationType;
import com.joker.wms.webapp.action.BaseAction;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EnumerationAction extends BaseAction implements Preparable {
    private EnumerationManager enumerationManager;
    private List enumerations;
    private Enumeration enumeration;
    private Long enumId;
    private String query;
    private String enumTypeId;

    public String getEnumTypeId() {
		return enumTypeId;
	}

	public void setEnumTypeId(String enumTypeId) {
		this.enumTypeId = enumTypeId;
	}

	public void setEnumerationManager(EnumerationManager enumerationManager) {
        this.enumerationManager = enumerationManager;
    }

    public List getEnumerations() {
        return enumerations;
    }

    /**
     * Grab the entity from the database before populating with request parameters
     */
    public void prepare() {
        if (getRequest().getMethod().equalsIgnoreCase("post")) {
            // prevent failures on new
            String enumerationId = getRequest().getParameter("enumeration.enumId");
            if (enumerationId != null && !enumerationId.equals("")) {
                enumeration = enumerationManager.get(new Long(enumerationId));
            }
        }
    }

    public void setQ(String q) {
        this.query = q;
    }

    public String list() {
        try {
        	Map condition = new HashMap();
        	if(enumTypeId != null && !"".equals(enumTypeId)){
        		condition.put("enumTypeId", enumTypeId);
        	}
            enumerations = enumerationManager.search(condition, Enumeration.class, getPage());
        } catch (SearchException se) {
            addActionError(se.getMessage());
            enumerations = enumerationManager.getAll(getPage());
        }
        if(query != null){
        	getRequest().setAttribute("showForm", "showData");
        }
        return SUCCESS;
    }

    public void setEnumId(Long enumId) {
        this.enumId = enumId;
    }

    public Enumeration getEnumeration() {
        return enumeration;
    }

    public void setEnumeration(Enumeration enumeration) {
        this.enumeration = enumeration;
    }

    public String delete() {
        enumerationManager.remove(enumeration.getEnumId());
        saveMessage(getText("enumeration.deleted"));

        return SUCCESS;
    }

    public String edit() {
        if (enumId != null) {
            enumeration = enumerationManager.get(enumId);
        } else {
            enumeration = new Enumeration();
        }

        return SUCCESS;
    }

    public String save() throws Exception {
        if (cancel != null) {
            super.setJsonResult("取消保存");
            return "jsonResult";
        }

        if (delete != null) {
            enumerationManager.remove(enumeration.getEnumId());
        	super.setJsonResult("删除成功");
            return "jsonResult";
        }

        boolean isNew = (enumeration.getEnumId() == null);
        enumeration.setEnumTypeId(Long.valueOf(enumTypeId));
        if(isNew){
        	enumeration.setCreatedByUser(getCurrentUser().getId());
        	enumeration.setCreatedTime(new Date());
        }else{
        	enumeration.setLastUpdatedByUser(getCurrentUser().getId());
        	enumeration.setLastUpdatedTime(new Date());
        }
        try{
        	if(getRequest().getParameter("enumeration.pinyinName")==null || "".equals(getRequest().getParameter("enumeration.pinyinName"))){
        		enumeration.setPinyinName(PinYinUtil.getPinYinHeadChar(enumeration.getDescription()));
            }
        	enumerationManager.save(enumeration);
        }catch(Exception e){
        	e.printStackTrace();
        }

        String key = (isNew) ? "enumeration.added" : "enumeration.updated";
        saveMessage(getText(key));

        super.setJsonResult("保存成功");
        return "jsonResult";
    }
}