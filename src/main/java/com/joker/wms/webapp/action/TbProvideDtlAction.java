package com.joker.wms.webapp.action;

import com.opensymphony.xwork2.Preparable;
import com.joker.wms.service.TbProvideDtlManager;
import com.joker.wms.dao.SearchException;
import com.joker.wms.model.TbProvideDtl;
import com.joker.wms.webapp.action.BaseAction;

import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class TbProvideDtlAction extends BaseAction implements Preparable {
    private TbProvideDtlManager tbProvideDtlManager;
    private List tbProvideDtls;
    private TbProvideDtl tbProvideDtl;
    private Long provideDtlId;
    private String query;
    private String provideId;

    public String getProvideId() {
		return provideId;
	}

	public void setProvideId(String provideId) {
		this.provideId = provideId;
	}

	public void setTbProvideDtlManager(TbProvideDtlManager tbProvideDtlManager) {
        this.tbProvideDtlManager = tbProvideDtlManager;
    }

    public List getTbProvideDtls() {
        return tbProvideDtls;
    }

    /**
     * Grab the entity from the database before populating with request parameters
     */
    public void prepare() {
        if (getRequest().getMethod().equalsIgnoreCase("post")) {
            // prevent failures on new
            String tbProvideDtlId = getRequest().getParameter("tbProvideDtl.provideDtlId");
            if (tbProvideDtlId != null && !tbProvideDtlId.equals("")) {
                tbProvideDtl = tbProvideDtlManager.get(new Long(tbProvideDtlId));
            }
        }
    }

    public void setQ(String q) {
        this.query = q;
    }

    public String list() {
        try {
        	Map condition = new HashMap();
        	condition.put("provideId", provideId);
            tbProvideDtls = tbProvideDtlManager.search(condition, TbProvideDtl.class, getPage());
        } catch (SearchException se) {
            addActionError(se.getMessage());
            tbProvideDtls = tbProvideDtlManager.getAll(getPage());
        }
        if(query != null){
        	getRequest().setAttribute("showForm", "showData");
        }
        return SUCCESS;
    }

    public void setProvideDtlId(Long provideDtlId) {
        this.provideDtlId = provideDtlId;
    }

    public TbProvideDtl getTbProvideDtl() {
        return tbProvideDtl;
    }

    public void setTbProvideDtl(TbProvideDtl tbProvideDtl) {
        this.tbProvideDtl = tbProvideDtl;
    }

    public String delete() {
        tbProvideDtlManager.remove(tbProvideDtl.getProvideDtlId());
        saveMessage(getText("tbProvideDtl.deleted"));

        return SUCCESS;
    }

    public String edit() {
        if (provideDtlId != null) {
            tbProvideDtl = tbProvideDtlManager.get(provideDtlId);
        } else {
            tbProvideDtl = new TbProvideDtl();
        }

        return SUCCESS;
    }

    public String save() throws Exception {
        if (cancel != null) {
            super.setJsonResult("取消保存");
            return "jsonResult";
        }

        if (delete != null) {
            tbProvideDtlManager.remove(tbProvideDtl.getProvideDtlId());
        	super.setJsonResult("删除成功");
            return "jsonResult";
        }

        boolean isNew = (tbProvideDtl.getProvideDtlId() == null);

        tbProvideDtl = tbProvideDtlManager.save(tbProvideDtl);

        String key = (isNew) ? "tbProvideDtl.added" : "tbProvideDtl.updated";
        saveMessage(getText(key));

        super.setJsonResult("保存成功");
        return "jsonResult";
    }
}