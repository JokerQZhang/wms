package com.joker.wms.webapp.action;

import com.opensymphony.xwork2.Preparable;
import com.joker.wms.service.GeoManager;
import com.joker.wms.dao.SearchException;
import com.joker.wms.model.Geo;
import com.joker.wms.webapp.action.BaseAction;

import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class GeoAction extends BaseAction implements Preparable {
    private GeoManager geoManager;
    private List geoes;
    private Geo geo;
    private Long geoId;
    private String query;

    public void setGeoManager(GeoManager geoManager) {
        this.geoManager = geoManager;
    }

    public List getGeoes() {
        return geoes;
    }

    /**
     * Grab the entity from the database before populating with request parameters
     */
    public void prepare() {
        if (getRequest().getMethod().equalsIgnoreCase("post")) {
            // prevent failures on new
            String geoId = getRequest().getParameter("geo.geoId");
            if (geoId != null && !geoId.equals("")) {
                geo = geoManager.get(new Long(geoId));
            }
        }
    }

    public void setQ(String q) {
        this.query = q;
    }

    public String list() {
        try {
        	Map condition = new HashMap();
            geoes = geoManager.search(condition, Geo.class, getPage());
        } catch (SearchException se) {
            addActionError(se.getMessage());
            geoes = geoManager.getAll(getPage());
        }
        if(query != null){
        	getRequest().setAttribute("showForm", "showData");
        }
        return SUCCESS;
    }

    public void setGeoId(Long geoId) {
        this.geoId = geoId;
    }

    public Geo getGeo() {
        return geo;
    }

    public void setGeo(Geo geo) {
        this.geo = geo;
    }

    public String delete() {
        geoManager.remove(geo.getGeoId());
        saveMessage(getText("geo.deleted"));

        return SUCCESS;
    }

    public String edit() {
        if (geoId != null) {
            geo = geoManager.get(geoId);
        } else {
            geo = new Geo();
        }

        return SUCCESS;
    }

    public String save() throws Exception {
        if (cancel != null) {
            super.setJsonResult("取消保存");
            return "jsonResult";
        }

        if (delete != null) {
            geoManager.remove(geo.getGeoId());
        	super.setJsonResult("删除成功");
            return "jsonResult";
        }

        boolean isNew = (geo.getGeoId() == null);

        geo = geoManager.save(geo);

        String key = (isNew) ? "geo.added" : "geo.updated";
        saveMessage(getText(key));

        super.setJsonResult("SaveSuccess");
        return "jsonResult";
    }
}