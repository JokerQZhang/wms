package com.joker.wms.webapp.action;

import com.opensymphony.xwork2.Preparable;
import com.joker.wms.service.TzZtjjManager;
import com.joker.wms.util.MyDateUtil;
import com.joker.wms.dao.SearchException;
import com.joker.wms.model.TzDyzth;
import com.joker.wms.model.TzZtjj;
import com.joker.wms.webapp.action.BaseAction;

import java.util.Date;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class TzZtjjAction extends BaseAction implements Preparable {
    private TzZtjjManager tzZtjjManager;
    private List tzZtjjs;
    private TzZtjj tzZtjj;
    private Long ztjjId;
    private String query;

    public void setTzZtjjManager(TzZtjjManager tzZtjjManager) {
        this.tzZtjjManager = tzZtjjManager;
    }

    public List getTzZtjjs() {
        return tzZtjjs;
    }

    /**
     * Grab the entity from the database before populating with request parameters
     */
    public void prepare() {
        if (getRequest().getMethod().equalsIgnoreCase("post")) {
            // prevent failures on new
            String tzZtjjId = getRequest().getParameter("tzZtjj.ztjjId");
            if (tzZtjjId != null && !tzZtjjId.equals("")) {
                tzZtjj = tzZtjjManager.get(new Long(tzZtjjId));
            }
        }
    }

    public void setQ(String q) {
        this.query = q;
    }

    public String list() {
        try {
        	Map condition = new HashMap();
            tzZtjjs = tzZtjjManager.search(condition, TzZtjj.class, getPage());
        } catch (SearchException se) {
            addActionError(se.getMessage());
            tzZtjjs = tzZtjjManager.getAll(getPage());
        }
        if(query != null){
        	getRequest().setAttribute("showForm", "showData");
        }
        return SUCCESS;
    }

    public void setZtjjId(Long ztjjId) {
        this.ztjjId = ztjjId;
    }

    public TzZtjj getTzZtjj() {
        return tzZtjj;
    }

    public void setTzZtjj(TzZtjj tzZtjj) {
        this.tzZtjj = tzZtjj;
    }

    public String delete() {
        tzZtjjManager.remove(tzZtjj.getZtjjId());
        saveMessage(getText("tzZtjj.deleted"));

        return SUCCESS;
    }

    public String edit() {
        if (ztjjId != null) {
            tzZtjj = tzZtjjManager.get(ztjjId);
        } else {
        	String tzDate = MyDateUtil.getCurrDate("yyyy-MM");
        	Map condition = new HashMap();
        	condition.put("tzDate", tzDate);
        	condition.put("groupPartyId", super.getSuperPartyGroup().getPartyId());
        	tzZtjjs = tzZtjjManager.searchByCondition(condition);
            if(tzZtjjs!=null && tzZtjjs.size()>0){
            	tzZtjj = (TzZtjj)tzZtjjs.get(0);
            }else{
            	tzZtjj = new TzZtjj();
            }
            
            tzZtjj.setGroupPartyId(super.getSuperPartyGroup().getPartyId());
            tzZtjj.setTzDate(tzDate);
        }

        return SUCCESS;
    }

    public String save() throws Exception {
        if (cancel != null) {
            super.setJsonResult("取消保存");
            return "jsonResult";
        }

        if (delete != null) {
            tzZtjjManager.remove(tzZtjj.getZtjjId());
        	super.setJsonResult("删除成功");
            return "jsonResult";
        }

        boolean isNew = (tzZtjj.getZtjjId() == null);
        if(isNew){
        	tzZtjj.setCreatedByUser(super.getCurrentUser().getId());
        	tzZtjj.setCreatedTime(new Date());
        }else{
        	tzZtjj.setLastUpdatedByUser(super.getCurrentUser().getId());
        	tzZtjj.setLastUpdatedTime(new Date());
        }
        tzZtjj = tzZtjjManager.save(tzZtjj);

        String key = (isNew) ? "tzZtjj.added" : "tzZtjj.updated";
        saveMessage(getText(key));

        super.setJsonResult("保存成功");
        return "jsonResult";
    }
}