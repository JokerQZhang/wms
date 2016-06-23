package com.joker.wms.webapp.action;

import com.opensymphony.xwork2.Preparable;
import com.joker.wms.service.UomConversionManager;
import com.joker.wms.dao.SearchException;
import com.joker.wms.model.UomConversion;
import com.joker.wms.webapp.action.BaseAction;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UomConversionAction extends BaseAction implements Preparable {
    private UomConversionManager uomConversionManager;
    private List uomConversions;
    private UomConversion uomConversion;
    private Long uomConversionId;
    private String query;
    private String uomTypeId;

    public String getUomTypeId() {
		return uomTypeId;
	}

	public void setUomTypeId(String uomTypeId) {
		this.uomTypeId = uomTypeId;
	}

    public void setUomConversionManager(UomConversionManager uomConversionManager) {
        this.uomConversionManager = uomConversionManager;
    }

    public List getUomConversions() {
        return uomConversions;
    }

    /**
     * Grab the entity from the database before populating with request parameters
     */
    public void prepare() {
        if (getRequest().getMethod().equalsIgnoreCase("post")) {
            // prevent failures on new
            String uomConversionId = getRequest().getParameter("uomConversion.uomConversionId");
            if (uomConversionId != null && !uomConversionId.equals("")) {
                uomConversion = uomConversionManager.get(new Long(uomConversionId));
            }
        }
    }

    public void setQ(String q) {
        this.query = q;
    }

    public String list() {
        try {
        	if(uomTypeId!=null && !uomTypeId.equals("")){
        		Map condition = new HashMap();
        		condition.put("uomTypeId", uomTypeId);
        		List allUomCon = uomConversionManager.searchByCondition(condition, getPage());
        		if(allUomCon!=null && allUomCon.size()>0){
        			for(int i=0; i<allUomCon.size(); i++){
        				if(uomConversions == null){
        					uomConversions = new ArrayList();
        				}
        				Object[] obs = (Object[])allUomCon.get(i);
        				UomConversion gUC = (UomConversion)obs[0];
        				uomConversions.add(gUC);
        				Map uomExtend = new HashMap();
        				uomExtend.put(gUC.getUomConversionId(), obs);
        				getRequest().setAttribute("uomExtend", uomExtend);
        			}
        		}
        	}else{
        		uomConversions = uomConversionManager.search(query, UomConversion.class, getPage());
        	}
        } catch (SearchException se) {
            addActionError(se.getMessage());
            uomConversions = uomConversionManager.getAll(getPage());
        }
        if(query != null){
        	getRequest().setAttribute("showForm", "showData");
        }
        return SUCCESS;
    }

    public void setUomConversionId(Long uomConversionId) {
        this.uomConversionId = uomConversionId;
    }

    public UomConversion getUomConversion() {
        return uomConversion;
    }

    public void setUomConversion(UomConversion uomConversion) {
        this.uomConversion = uomConversion;
    }

    public String delete() {
        uomConversionManager.remove(uomConversion.getUomConversionId());
        saveMessage(getText("uomConversion.deleted"));

        return SUCCESS;
    }

    public String edit() {
        if (uomConversionId != null) {
            uomConversion = uomConversionManager.get(uomConversionId);
        } else {
            uomConversion = new UomConversion();
        }

        return SUCCESS;
    }

    public String save() throws Exception {
        if (cancel != null) {
            super.setJsonResult("取消保存");
            return "jsonResult";
        }

        if (delete != null) {
            uomConversionManager.remove(uomConversion.getUomConversionId());
        	super.setJsonResult("删除成功");
            return "jsonResult";
        }

        boolean isNew = (uomConversion.getUomConversionId() == null);
        if(isNew){
        	uomConversion.setCreatedByUser(getCurrentUser().getId());
        	uomConversion.setCreatedTime(new Date());
        }else{
        	uomConversion.setLastUpdatedByUser(getCurrentUser().getId());
        	uomConversion.setLastUpdatedTime(new Date());
        }
        uomConversionManager.save(uomConversion);

        String key = (isNew) ? "uomConversion.added" : "uomConversion.updated";
        saveMessage(getText(key));

        super.setJsonResult("保存成功");
        return "jsonResult";
    }
}