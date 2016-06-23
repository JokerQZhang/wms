package com.joker.wms.webapp.action;

import com.opensymphony.xwork2.Preparable;
import com.joker.wms.service.TzDhbzManager;
import com.joker.wms.util.MyDateUtil;
import com.joker.wms.dao.SearchException;
import com.joker.wms.model.PartyGroup;
import com.joker.wms.model.TzDhbz;
import com.joker.wms.model.TzDyzth;
import com.joker.wms.webapp.action.BaseAction;

import java.util.Date;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class TzDhbzAction extends BaseAction implements Preparable {
    private TzDhbzManager tzDhbzManager;
    private List tzDhbzs;
    private TzDhbz tzDhbz;
    private Long dhbzId;
    private String query;

    public void setTzDhbzManager(TzDhbzManager tzDhbzManager) {
        this.tzDhbzManager = tzDhbzManager;
    }

    public List getTzDhbzs() {
        return tzDhbzs;
    }

    /**
     * Grab the entity from the database before populating with request parameters
     */
    public void prepare() {
        if (getRequest().getMethod().equalsIgnoreCase("post")) {
            // prevent failures on new
            String tzDhbzId = getRequest().getParameter("tzDhbz.dhbzId");
            if (tzDhbzId != null && !tzDhbzId.equals("")) {
                tzDhbz = tzDhbzManager.get(new Long(tzDhbzId));
            }
        }
    }

    public void setQ(String q) {
        this.query = q;
    }

    public String list() {
        try {
        	Map condition = new HashMap();
            tzDhbzs = tzDhbzManager.search(condition, TzDhbz.class, getPage());
        } catch (SearchException se) {
            addActionError(se.getMessage());
            tzDhbzs = tzDhbzManager.getAll(getPage());
        }
        if(query != null){
        	getRequest().setAttribute("showForm", "showData");
        }
        return SUCCESS;
    }

    public void setDhbzId(Long dhbzId) {
        this.dhbzId = dhbzId;
    }

    public TzDhbz getTzDhbz() {
        return tzDhbz;
    }

    public void setTzDhbz(TzDhbz tzDhbz) {
        this.tzDhbz = tzDhbz;
    }

    public String delete() {
        tzDhbzManager.remove(tzDhbz.getDhbzId());
        saveMessage(getText("tzDhbz.deleted"));

        return SUCCESS;
    }

    public String edit() {
        if (dhbzId != null) {
            tzDhbz = tzDhbzManager.get(dhbzId);
        } else {
        	String tzDate = MyDateUtil.getCurrDate("yyyy-MM");
        	Map condition = new HashMap();
        	condition.put("tzDate", tzDate);
        	condition.put("groupPartyId", super.getSuperPartyGroup().getPartyId());
        	tzDhbzs = tzDhbzManager.searchByCondition(condition);
            if(tzDhbzs!=null && tzDhbzs.size()>0){
            	tzDhbz = (TzDhbz)tzDhbzs.get(0);
            }else{
            	tzDhbz = new TzDhbz();
            }
            
            tzDhbz.setGroupPartyId(super.getSuperPartyGroup().getPartyId());
            tzDhbz.setTzDate(tzDate);
        }
        return SUCCESS;
    }

    public String save() throws Exception {
        if (cancel != null) {
            super.setJsonResult("取消保存");
            return "jsonResult";
        }

        if (delete != null) {
            tzDhbzManager.remove(tzDhbz.getDhbzId());
        	super.setJsonResult("删除成功");
            return "jsonResult";
        }

        boolean isNew = (tzDhbz.getDhbzId() == null);
        if(isNew){
        	tzDhbz.setCreatedByUser(super.getCurrentUser().getId());
        	tzDhbz.setCreatedTime(new Date());
        }else{
        	tzDhbz.setLastUpdatedByUser(super.getCurrentUser().getId());
        	tzDhbz.setLastUpdatedTime(new Date());
        }
        tzDhbz = tzDhbzManager.save(tzDhbz);

        String key = (isNew) ? "tzDhbz.added" : "tzDhbz.updated";
        saveMessage(getText(key));

        super.setJsonResult("保存成功");
        return "jsonResult";
    }
}