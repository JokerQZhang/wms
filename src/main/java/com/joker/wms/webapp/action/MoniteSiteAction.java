package com.joker.wms.webapp.action;

import com.opensymphony.xwork2.Preparable;
import com.joker.wms.service.MoniteSiteManager;
import com.joker.wms.dao.SearchException;
import com.joker.wms.model.MoniteSite;
import com.joker.wms.webapp.action.BaseAction;

import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class MoniteSiteAction extends BaseAction implements Preparable {
    private MoniteSiteManager moniteSiteManager;
    private List moniteSites;
    private MoniteSite moniteSite;
    private Long siteId;
    private String query;

    public void setMoniteSiteManager(MoniteSiteManager moniteSiteManager) {
        this.moniteSiteManager = moniteSiteManager;
    }

    public List getMoniteSites() {
        return moniteSites;
    }

    /**
     * Grab the entity from the database before populating with request parameters
     */
    public void prepare() {
        if (getRequest().getMethod().equalsIgnoreCase("post")) {
            // prevent failures on new
            String moniteSiteId = getRequest().getParameter("moniteSite.siteId");
            if (moniteSiteId != null && !moniteSiteId.equals("")) {
                moniteSite = moniteSiteManager.get(new Long(moniteSiteId));
            }
        }
    }

    public void setQ(String q) {
        this.query = q;
    }

    public String list() {
        try {
        	Map condition = new HashMap();
            moniteSites = moniteSiteManager.search(condition, MoniteSite.class, getPage());
        } catch (SearchException se) {
            addActionError(se.getMessage());
            moniteSites = moniteSiteManager.getAll(getPage());
        }
        if(query != null){
        	getRequest().setAttribute("showForm", "showData");
        }
        return SUCCESS;
    }

    public void setSiteId(Long siteId) {
        this.siteId = siteId;
    }

    public MoniteSite getMoniteSite() {
        return moniteSite;
    }

    public void setMoniteSite(MoniteSite moniteSite) {
        this.moniteSite = moniteSite;
    }

    public String delete() {
        moniteSiteManager.remove(moniteSite.getSiteId());
        saveMessage(getText("moniteSite.deleted"));

        return SUCCESS;
    }

    public String edit() {
        if (siteId != null) {
            moniteSite = moniteSiteManager.get(siteId);
        } else {
            moniteSite = new MoniteSite();
        }

        return SUCCESS;
    }

    public String save() throws Exception {
        if (cancel != null) {
            super.setJsonResult("取消保存");
            return "jsonResult";
        }

        if (delete != null) {
            moniteSiteManager.remove(moniteSite.getSiteId());
        	super.setJsonResult("删除成功");
            return "jsonResult";
        }

        boolean isNew = (moniteSite.getSiteId() == null);

        moniteSite = moniteSiteManager.save(moniteSite);

        String key = (isNew) ? "moniteSite.added" : "moniteSite.updated";
        saveMessage(getText(key));

        super.setJsonResult("SaveSuccess");
        return "jsonResult";
    }
}