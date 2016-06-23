package com.joker.wms.webapp.action;

import com.opensymphony.xwork2.Preparable;
import com.joker.wms.service.AlarmSetManager;
import com.joker.wms.dao.SearchException;
import com.joker.wms.model.AlarmSet;
import com.joker.wms.webapp.action.BaseAction;

import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class AlarmSetAction extends BaseAction implements Preparable {
    private AlarmSetManager alarmSetManager;
    private List alarmSets;
    private AlarmSet alarmSet;
    private Long alarmSetId;
    private String query;

    public void setAlarmSetManager(AlarmSetManager alarmSetManager) {
        this.alarmSetManager = alarmSetManager;
    }

    public List getAlarmSets() {
        return alarmSets;
    }

    /**
     * Grab the entity from the database before populating with request parameters
     */
    public void prepare() {
        if (getRequest().getMethod().equalsIgnoreCase("post")) {
            // prevent failures on new
            String alarmSetId = getRequest().getParameter("alarmSet.alarmSetId");
            if (alarmSetId != null && !alarmSetId.equals("")) {
                alarmSet = alarmSetManager.get(new Long(alarmSetId));
            }
        }
    }

    public void setQ(String q) {
        this.query = q;
    }

    public String list() {
        try {
        	Map condition = new HashMap();
            alarmSets = alarmSetManager.search(condition, AlarmSet.class, getPage());
        } catch (SearchException se) {
            addActionError(se.getMessage());
            alarmSets = alarmSetManager.getAll(getPage());
        }
        if(query != null){
        	getRequest().setAttribute("showForm", "showData");
        }
        return SUCCESS;
    }

    public void setAlarmSetId(Long alarmSetId) {
        this.alarmSetId = alarmSetId;
    }

    public AlarmSet getAlarmSet() {
        return alarmSet;
    }

    public void setAlarmSet(AlarmSet alarmSet) {
        this.alarmSet = alarmSet;
    }

    public String delete() {
        alarmSetManager.remove(alarmSet.getAlarmSetId());
        saveMessage(getText("alarmSet.deleted"));

        return SUCCESS;
    }

    public String edit() {
        if (alarmSetId != null) {
            alarmSet = alarmSetManager.get(alarmSetId);
        } else {
            alarmSet = new AlarmSet();
        }

        return SUCCESS;
    }

    public String save() throws Exception {
        if (cancel != null) {
            super.setJsonResult("取消保存");
            return "jsonResult";
        }

        if (delete != null) {
            alarmSetManager.remove(alarmSet.getAlarmSetId());
        	super.setJsonResult("删除成功");
            return "jsonResult";
        }

        boolean isNew = (alarmSet.getAlarmSetId() == null);

        alarmSet = alarmSetManager.save(alarmSet);

        String key = (isNew) ? "alarmSet.added" : "alarmSet.updated";
        saveMessage(getText(key));

        super.setJsonResult("SaveSuccess");
        return "jsonResult";
    }
}