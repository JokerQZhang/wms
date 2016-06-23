package com.joker.wms.webapp.action;

import com.opensymphony.xwork2.Preparable;
import com.joker.wms.service.TzGfmzManager;
import com.joker.wms.util.MyDateUtil;
import com.joker.wms.dao.SearchException;
import com.joker.wms.model.TzDyzth;
import com.joker.wms.model.TzGfmz;
import com.joker.wms.webapp.action.BaseAction;

import java.util.Date;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class TzGfmzAction extends BaseAction implements Preparable {
    private TzGfmzManager tzGfmzManager;
    private List tzGfmzs;
    private TzGfmz tzGfmz;
    private Long gfmzId;
    private String query;

    public void setTzGfmzManager(TzGfmzManager tzGfmzManager) {
        this.tzGfmzManager = tzGfmzManager;
    }

    public List getTzGfmzs() {
        return tzGfmzs;
    }

    /**
     * Grab the entity from the database before populating with request parameters
     */
    public void prepare() {
        if (getRequest().getMethod().equalsIgnoreCase("post")) {
            // prevent failures on new
            String tzGfmzId = getRequest().getParameter("tzGfmz.gfmzId");
            if (tzGfmzId != null && !tzGfmzId.equals("")) {
                tzGfmz = tzGfmzManager.get(new Long(tzGfmzId));
            }
        }
    }

    public void setQ(String q) {
        this.query = q;
    }

    public String list() {
        try {
        	Map condition = new HashMap();
            tzGfmzs = tzGfmzManager.search(condition, TzGfmz.class, getPage());
        } catch (SearchException se) {
            addActionError(se.getMessage());
            tzGfmzs = tzGfmzManager.getAll(getPage());
        }
        if(query != null){
        	getRequest().setAttribute("showForm", "showData");
        }
        return SUCCESS;
    }

    public void setGfmzId(Long gfmzId) {
        this.gfmzId = gfmzId;
    }

    public TzGfmz getTzGfmz() {
        return tzGfmz;
    }

    public void setTzGfmz(TzGfmz tzGfmz) {
        this.tzGfmz = tzGfmz;
    }

    public String delete() {
        tzGfmzManager.remove(tzGfmz.getGfmzId());
        saveMessage(getText("tzGfmz.deleted"));

        return SUCCESS;
    }

    public String edit() {
        if (gfmzId != null) {
            tzGfmz = tzGfmzManager.get(gfmzId);
        } else {
        	String tzDate = MyDateUtil.getCurrDate("yyyy-MM");
        	Map condition = new HashMap();
        	condition.put("tzDate", tzDate);
        	condition.put("groupPartyId", super.getSuperPartyGroup().getPartyId());
        	tzGfmzs = tzGfmzManager.searchByCondition(condition);
            if(tzGfmzs!=null && tzGfmzs.size()>0){
            	tzGfmz = (TzGfmz)tzGfmzs.get(0);
            }else{
            	tzGfmz = new TzGfmz();
            }
            
            tzGfmz.setGroupPartyId(super.getSuperPartyGroup().getPartyId());
            tzGfmz.setTzDate(tzDate);
        }

        return SUCCESS;
    }

    public String save() throws Exception {
        if (cancel != null) {
            super.setJsonResult("取消保存");
            return "jsonResult";
        }

        if (delete != null) {
            tzGfmzManager.remove(tzGfmz.getGfmzId());
        	super.setJsonResult("删除成功");
            return "jsonResult";
        }

        boolean isNew = (tzGfmz.getGfmzId() == null);
        if(isNew){
        	tzGfmz.setCreatedByUser(super.getCurrentUser().getId());
        	tzGfmz.setCreatedTime(new Date());
        }else{
        	tzGfmz.setLastUpdatedByUser(super.getCurrentUser().getId());
        	tzGfmz.setLastUpdatedTime(new Date());
        }
        tzGfmz = tzGfmzManager.save(tzGfmz);

        String key = (isNew) ? "tzGfmz.added" : "tzGfmz.updated";
        saveMessage(getText(key));

        super.setJsonResult("保存成功");
        return "jsonResult";
    }
}