package com.joker.wms.webapp.action;

import com.opensymphony.xwork2.Preparable;
import com.joker.wms.service.TzFwqzManager;
import com.joker.wms.util.MyDateUtil;
import com.joker.wms.dao.SearchException;
import com.joker.wms.model.TzDyzth;
import com.joker.wms.model.TzFwqz;
import com.joker.wms.webapp.action.BaseAction;

import java.util.Date;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class TzFwqzAction extends BaseAction implements Preparable {
    private TzFwqzManager tzFwqzManager;
    private List tzFwqzs;
    private TzFwqz tzFwqz;
    private Long fwqzId;
    private String query;

    public void setTzFwqzManager(TzFwqzManager tzFwqzManager) {
        this.tzFwqzManager = tzFwqzManager;
    }

    public List getTzFwqzs() {
        return tzFwqzs;
    }

    /**
     * Grab the entity from the database before populating with request parameters
     */
    public void prepare() {
        if (getRequest().getMethod().equalsIgnoreCase("post")) {
            // prevent failures on new
            String tzFwqzId = getRequest().getParameter("tzFwqz.fwqzId");
            if (tzFwqzId != null && !tzFwqzId.equals("")) {
                tzFwqz = tzFwqzManager.get(new Long(tzFwqzId));
            }
        }
    }

    public void setQ(String q) {
        this.query = q;
    }

    public String list() {
        try {
        	Map condition = new HashMap();
            tzFwqzs = tzFwqzManager.search(condition, TzFwqz.class, getPage());
        } catch (SearchException se) {
            addActionError(se.getMessage());
            tzFwqzs = tzFwqzManager.getAll(getPage());
        }
        if(query != null){
        	getRequest().setAttribute("showForm", "showData");
        }
        return SUCCESS;
    }

    public void setFwqzId(Long fwqzId) {
        this.fwqzId = fwqzId;
    }

    public TzFwqz getTzFwqz() {
        return tzFwqz;
    }

    public void setTzFwqz(TzFwqz tzFwqz) {
        this.tzFwqz = tzFwqz;
    }

    public String delete() {
        tzFwqzManager.remove(tzFwqz.getFwqzId());
        saveMessage(getText("tzFwqz.deleted"));

        return SUCCESS;
    }

    public String edit() {
        if (fwqzId != null) {
            tzFwqz = tzFwqzManager.get(fwqzId);
        } else {
        	String tzDate = MyDateUtil.getCurrDate("yyyy-MM");
        	Map condition = new HashMap();
        	condition.put("tzDate", tzDate);
        	condition.put("groupPartyId", super.getSuperPartyGroup().getPartyId());
        	tzFwqzs = tzFwqzManager.searchByCondition(condition);
            if(tzFwqzs!=null && tzFwqzs.size()>0){
            	tzFwqz = (TzFwqz)tzFwqzs.get(0);
            }else{
            	tzFwqz = new TzFwqz();
            }
            
            tzFwqz.setGroupPartyId(super.getSuperPartyGroup().getPartyId());
            tzFwqz.setTzDate(tzDate);
        }

        return SUCCESS;
    }

    public String save() throws Exception {
        if (cancel != null) {
            super.setJsonResult("取消保存");
            return "jsonResult";
        }

        if (delete != null) {
            tzFwqzManager.remove(tzFwqz.getFwqzId());
        	super.setJsonResult("删除成功");
            return "jsonResult";
        }
        
        boolean isNew = (tzFwqz.getFwqzId() == null);
        if(isNew){
        	tzFwqz.setCreatedByUser(super.getCurrentUser().getId());
        	tzFwqz.setCreatedTime(new Date());
        }else{
        	tzFwqz.setLastUpdatedByUser(super.getCurrentUser().getId());
        	tzFwqz.setLastUpdatedTime(new Date());
        }
        tzFwqz = tzFwqzManager.save(tzFwqz);

        String key = (isNew) ? "tzFwqz.added" : "tzFwqz.updated";
        saveMessage(getText(key));

        super.setJsonResult("保存成功");
        return "jsonResult";
    }
}