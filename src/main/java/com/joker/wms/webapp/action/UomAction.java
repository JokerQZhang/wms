package com.joker.wms.webapp.action;

import com.opensymphony.xwork2.Preparable;
import com.joker.wms.service.UomManager;
import com.joker.wms.util.PinYinUtil;
import com.joker.wms.dao.SearchException;
import com.joker.wms.model.Uom;
import com.joker.wms.webapp.action.BaseAction;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UomAction extends BaseAction implements Preparable {
    private UomManager uomManager;
    private List uoms;
    private Uom uom;
    private Long uomId;
    private String query;
    private String uomTypeId;

    public String getUomTypeId() {
		return uomTypeId;
	}

	public void setUomTypeId(String uomTypeId) {
		this.uomTypeId = uomTypeId;
	}

	public void setUomManager(UomManager uomManager) {
        this.uomManager = uomManager;
    }

    public List getUoms() {
        return uoms;
    }

    /**
     * Grab the entity from the database before populating with request parameters
     */
    public void prepare() {
        if (getRequest().getMethod().equalsIgnoreCase("post")) {
            // prevent failures on new
            String uomId = getRequest().getParameter("uom.uomId");
            if (uomId != null && !uomId.equals("")) {
                uom = uomManager.get(new Long(uomId));
            }
        }
    }

    public void setQ(String q) {
        this.query = q;
    }

    public String list() {
        try {
        	if(uomTypeId!=null && !"".equals(uomTypeId)){
        		Map condition = new HashMap();
        		condition.put("uomTypeId", uomTypeId);
        		uoms = uomManager.searchByCondition(condition, getPage());
        	}else{
        		uoms = uomManager.search(query, Uom.class, getPage());
        	}
        } catch (SearchException se) {
            addActionError(se.getMessage());
            uoms = uomManager.getAll(getPage());
        }
        if(query != null){
        	getRequest().setAttribute("showForm", "showData");
        }
        return SUCCESS;
    }

    public void setUomId(Long uomId) {
        this.uomId = uomId;
    }

    public Uom getUom() {
        return uom;
    }

    public void setUom(Uom uom) {
        this.uom = uom;
    }

    public String delete() {
        uomManager.remove(uom.getUomId());
        saveMessage(getText("uom.deleted"));

        return SUCCESS;
    }

    public String edit() {
        if (uomId != null) {
            uom = uomManager.get(uomId);
        } else {
            uom = new Uom();
        }

        return SUCCESS;
    }

    public String save() throws Exception {
        if (cancel != null) {
            super.setJsonResult("取消保存");
            return "jsonResult";
        }

        if (delete != null) {
            uomManager.remove(uom.getUomId());
        	super.setJsonResult("删除成功");
            return "jsonResult";
        }

        boolean isNew = (uom.getUomId() == null);
        if(getRequest().getParameter("uom.pinyinName")==null || "".equals(getRequest().getParameter("uom.pinyinName"))){
        	uom.setPinyinName(PinYinUtil.getPinYinHeadChar(uom.getDescription()));
        }
        if(isNew){
        	uom.setCreatedByUser(getCurrentUser().getId());
        	uom.setCreatedTime(new Date());
        }else{
        	uom.setLastUpdatedByUser(getCurrentUser().getId());
        	uom.setLastUpdatedTime(new Date());
        }
        uomManager.save(uom);

        String key = (isNew) ? "uom.added" : "uom.updated";
        saveMessage(getText(key));

        super.setJsonResult("保存成功");
        return "jsonResult";
    }
}