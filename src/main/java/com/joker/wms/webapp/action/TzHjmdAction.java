package com.joker.wms.webapp.action;

import com.opensymphony.xwork2.Preparable;
import com.joker.wms.service.TzHjmdManager;
import com.joker.wms.util.MyDateUtil;
import com.joker.wms.dao.SearchException;
import com.joker.wms.model.TzDyzth;
import com.joker.wms.model.TzHjmd;
import com.joker.wms.webapp.action.BaseAction;

import java.util.Date;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class TzHjmdAction extends BaseAction implements Preparable {
    private TzHjmdManager tzHjmdManager;
    private List tzHjmds;
    private TzHjmd tzHjmd;
    private Long hjmdId;
    private String query;

    public void setTzHjmdManager(TzHjmdManager tzHjmdManager) {
        this.tzHjmdManager = tzHjmdManager;
    }

    public List getTzHjmds() {
        return tzHjmds;
    }

    /**
     * Grab the entity from the database before populating with request parameters
     */
    public void prepare() {
        if (getRequest().getMethod().equalsIgnoreCase("post")) {
            // prevent failures on new
            String tzHjmdId = getRequest().getParameter("tzHjmd.hjmdId");
            if (tzHjmdId != null && !tzHjmdId.equals("")) {
                tzHjmd = tzHjmdManager.get(new Long(tzHjmdId));
            }
        }
    }

    public void setQ(String q) {
        this.query = q;
    }

    public String list() {
        try {
        	Map condition = new HashMap();
            tzHjmds = tzHjmdManager.search(condition, TzHjmd.class, getPage());
        } catch (SearchException se) {
            addActionError(se.getMessage());
            tzHjmds = tzHjmdManager.getAll(getPage());
        }
        if(query != null){
        	getRequest().setAttribute("showForm", "showData");
        }
        return SUCCESS;
    }

    public void setHjmdId(Long hjmdId) {
        this.hjmdId = hjmdId;
    }

    public TzHjmd getTzHjmd() {
        return tzHjmd;
    }

    public void setTzHjmd(TzHjmd tzHjmd) {
        this.tzHjmd = tzHjmd;
    }

    public String delete() {
        tzHjmdManager.remove(tzHjmd.getHjmdId());
        saveMessage(getText("tzHjmd.deleted"));

        return SUCCESS;
    }

    public String edit() {
        if (hjmdId != null) {
            tzHjmd = tzHjmdManager.get(hjmdId);
        } else {
        	String tzDate = MyDateUtil.getCurrDate("yyyy-MM");
        	Map condition = new HashMap();
        	condition.put("tzDate", tzDate);
        	condition.put("groupPartyId", super.getSuperPartyGroup().getPartyId());
        	tzHjmds = tzHjmdManager.searchByCondition(condition);
            if(tzHjmds!=null && tzHjmds.size()>0){
            	tzHjmd = (TzHjmd)tzHjmds.get(0);
            }else{
            	tzHjmd = new TzHjmd();
            }
            
            tzHjmd.setGroupPartyId(super.getSuperPartyGroup().getPartyId());
            tzHjmd.setTzDate(tzDate);
        }

        return SUCCESS;
    }

    public String save() throws Exception {
        if (cancel != null) {
            super.setJsonResult("取消保存");
            return "jsonResult";
        }

        if (delete != null) {
            tzHjmdManager.remove(tzHjmd.getHjmdId());
        	super.setJsonResult("删除成功");
            return "jsonResult";
        }

        boolean isNew = (tzHjmd.getHjmdId() == null);
        if(isNew){
        	tzHjmd.setCreatedByUser(super.getCurrentUser().getId());
        	tzHjmd.setCreatedTime(new Date());
        }else{
        	tzHjmd.setLastUpdatedByUser(super.getCurrentUser().getId());
        	tzHjmd.setLastUpdatedTime(new Date());
        }
        tzHjmd = tzHjmdManager.save(tzHjmd);

        String key = (isNew) ? "tzHjmd.added" : "tzHjmd.updated";
        saveMessage(getText(key));

        super.setJsonResult("保存成功");
        return "jsonResult";
    }
}