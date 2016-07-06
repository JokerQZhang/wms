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
    public String saveGeoSitePoint(){
    	String currentPoint = super.getRequest().getParameter("currentPoint");
    	String currentGeoId = super.getRequest().getParameter("currentGeoId");
    	super.initJsonObj();
    	if(currentGeoId!=null && !"".equals(currentGeoId)){
    		geo = geoManager.get(Long.valueOf(currentGeoId));
    		geo.setGeoPoint(currentPoint);
    		geoManager.save(geo);
    		jsonObj.put("msg", geo.getGeoName()+"地理坐标保存成功");
    	}else{
    		jsonObj.put("msg", "地理坐标保存失败，请联系管理员。");
    	}
    	return JSON;
    }
    public String geoTree(){
    	try {
    		String geoParentId = super.getRequest().getParameter("geoParentId");
        	Map condition = new HashMap();
        	condition.put("geoParentId", geoParentId);
            geoes = geoManager.search(condition, Geo.class, getPage());
            //显示geo下面的company
            List companys = geoManager.getPartyGroupByGeoId(geoParentId);
            super.getRequest().setAttribute("companys", companys);
        } catch (SearchException se) {
            addActionError(se.getMessage());
            geoes = geoManager.getAll(getPage());
        }
    	getRequest().setAttribute("showForm", "showData");
    	return SUCCESS;
    }
    public String companySitesTree(){
    	String companyId = super.getRequest().getParameter("companyId");
    	//companyId其实是partyId
    	if(companyId!=null){
    		List moniteSites = geoManager.getMoniteSiteByParytId(companyId);
    		super.getRequest().setAttribute("moniteSites", moniteSites);
    	}
    	return SUCCESS;
    }
    public String getAreaPoints(){
    	super.initJsonObj();
    	String areaId = super.getRequest().getParameter("areaId");
    	if(areaId!=null && !"".equals(areaId)){
    		List sites = geoManager.getAreaPoints(areaId);
    		jsonObj.put("sites", sites);
    		jsonObj.put("result", "success");
    	}else{
    		jsonObj.put("msg", "查找失败");
    		jsonObj.put("result", "lose");
    	}
    	return JSON;
    }
    public String getCompanyPoints(){
    	super.initJsonObj();
    	String areaId = super.getRequest().getParameter("areaId");
    	if(areaId!=null && !"".equals(areaId)){
    		List sites = geoManager.getCompanyPoints(areaId);
    		jsonObj.put("sites", sites);
    		jsonObj.put("result", "success");
    	}else{
    		jsonObj.put("msg", "查找失败");
    		jsonObj.put("result", "lose");
    	}
    	return JSON;
    }
    public String getSitePoints(){
    	super.initJsonObj();
    	String areaId = super.getRequest().getParameter("areaId");
    	if(areaId!=null && !"".equals(areaId)){
    		List sites = geoManager.getSitePoints(areaId);
    		jsonObj.put("sites", sites);
    		jsonObj.put("result", "success");
    	}else{
    		jsonObj.put("msg", "查找失败");
    		jsonObj.put("result", "lose");
    	}
    	return JSON;
    }
}