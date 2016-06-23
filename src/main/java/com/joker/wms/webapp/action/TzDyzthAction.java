package com.joker.wms.webapp.action;

import com.opensymphony.xwork2.Preparable;
import com.joker.wms.service.TzDyzthManager;
import com.joker.wms.util.MyDateUtil;
import com.joker.wms.dao.SearchException;
import com.joker.wms.model.TzDyzth;
import com.joker.wms.webapp.action.BaseAction;

import java.util.Date;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class TzDyzthAction extends BaseAction implements Preparable {
    private TzDyzthManager tzDyzthManager;
    private List tzDyzths;
    private TzDyzth tzDyzth;
    private Long dyzthId;
    private String query;

    public void setTzDyzthManager(TzDyzthManager tzDyzthManager) {
        this.tzDyzthManager = tzDyzthManager;
    }

    public List getTzDyzths() {
        return tzDyzths;
    }

    /**
     * Grab the entity from the database before populating with request parameters
     */
    public void prepare() {
        if (getRequest().getMethod().equalsIgnoreCase("post")) {
            // prevent failures on new
            String tzDyzthId = getRequest().getParameter("tzDyzth.dyzthId");
            if (tzDyzthId != null && !tzDyzthId.equals("")) {
                tzDyzth = tzDyzthManager.get(new Long(tzDyzthId));
            }
        }
    }

    public void setQ(String q) {
        this.query = q;
    }

    public String list() {
        try {
        	Map condition = new HashMap();
            tzDyzths = tzDyzthManager.search(condition, TzDyzth.class, getPage());
        } catch (SearchException se) {
            addActionError(se.getMessage());
            tzDyzths = tzDyzthManager.getAll(getPage());
        }
        if(query != null){
        	getRequest().setAttribute("showForm", "showData");
        }
        return SUCCESS;
    }

    public void setDyzthId(Long dyzthId) {
        this.dyzthId = dyzthId;
    }

    public TzDyzth getTzDyzth() {
        return tzDyzth;
    }

    public void setTzDyzth(TzDyzth tzDyzth) {
        this.tzDyzth = tzDyzth;
    }

    public String delete() {
        tzDyzthManager.remove(tzDyzth.getDyzthId());
        saveMessage(getText("tzDyzth.deleted"));

        return SUCCESS;
    }

    public String edit() {
        if (dyzthId != null) {
            tzDyzth = tzDyzthManager.get(dyzthId);
        } else {
        	String tzDate = MyDateUtil.getCurrDate("yyyy-MM");
        	Map condition = new HashMap();
        	condition.put("tzDate", tzDate);
        	condition.put("groupPartyId", super.getSuperPartyGroup().getPartyId());
            tzDyzths = tzDyzthManager.searchByCondition(condition);
            if(tzDyzths!=null && tzDyzths.size()>0){
            	tzDyzth = (TzDyzth)tzDyzths.get(0);
            }else{
            	tzDyzth = new TzDyzth();
            }
            tzDyzth.setGroupPartyId(super.getSuperPartyGroup().getPartyId());
            tzDyzth.setTzDate(tzDate);
        }

        return SUCCESS;
    }

    public String save() throws Exception {
        if (cancel != null) {
            super.setJsonResult("取消保存");
            return "jsonResult";
        }

        if (delete != null) {
            tzDyzthManager.remove(tzDyzth.getDyzthId());
        	super.setJsonResult("删除成功");
            return "jsonResult";
        }

        boolean isNew = (tzDyzth.getDyzthId() == null);
        if(isNew){
        	tzDyzth.setCreatedByUser(super.getCurrentUser().getId());
        	tzDyzth.setCreatedTime(new Date());
        }else{
        	tzDyzth.setLastUpdatedByUser(super.getCurrentUser().getId());
        	tzDyzth.setLastUpdatedTime(new Date());
        }
        tzDyzth = tzDyzthManager.save(tzDyzth);

        String key = (isNew) ? "tzDyzth.added" : "tzDyzth.updated";
        saveMessage(getText(key));

        super.setJsonResult("保存成功");
        return "jsonResult";
    }
    
    public String tztb(){
    	
    	return SUCCESS;
    }
    public String tzshow(){
    	getRequest().setAttribute("tzDate", MyDateUtil.getCurrDate("yyyy-MM"));
    	return SUCCESS;
    }
}