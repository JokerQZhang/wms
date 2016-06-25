package com.joker.wms.webapp.action;

import com.opensymphony.xwork2.Preparable;
import com.joker.wms.service.MonitorDataManager;
import com.joker.wms.dao.SearchException;
import com.joker.wms.model.MonitorData;
import com.joker.wms.webapp.action.BaseAction;

import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class MonitorDataAction extends BaseAction implements Preparable {
    private MonitorDataManager monitorDataManager;
    private List monitorDatas;
    private MonitorData monitorData;
    private Long monitorId;
    private String query;

    public void setMonitorDataManager(MonitorDataManager monitorDataManager) {
        this.monitorDataManager = monitorDataManager;
    }

    public List getMonitorDatas() {
        return monitorDatas;
    }

    /**
     * Grab the entity from the database before populating with request parameters
     */
    public void prepare() {
        if (getRequest().getMethod().equalsIgnoreCase("post")) {
            // prevent failures on new
            String monitorDataId = getRequest().getParameter("monitorData.monitorId");
            if (monitorDataId != null && !monitorDataId.equals("")) {
                monitorData = monitorDataManager.get(new Long(monitorDataId));
            }
        }
    }

    public void setQ(String q) {
        this.query = q;
    }

    public String list() {
        try {
        	Map condition = new HashMap();
            monitorDatas = monitorDataManager.search(condition, MonitorData.class, getPage());
        } catch (SearchException se) {
            addActionError(se.getMessage());
            monitorDatas = monitorDataManager.getAll(getPage());
        }
        if(query != null){
        	getRequest().setAttribute("showForm", "showData");
        }
        return SUCCESS;
    }

    public void setMonitorId(Long monitorId) {
        this.monitorId = monitorId;
    }

    public MonitorData getMonitorData() {
        return monitorData;
    }

    public void setMonitorData(MonitorData monitorData) {
        this.monitorData = monitorData;
    }

    public String delete() {
        monitorDataManager.remove(monitorData.getMonitorId());
        saveMessage(getText("monitorData.deleted"));

        return SUCCESS;
    }

    public String edit() {
        if (monitorId != null) {
            monitorData = monitorDataManager.get(monitorId);
        } else {
            monitorData = new MonitorData();
        }

        return SUCCESS;
    }

    public String save() throws Exception {
        if (cancel != null) {
            super.setJsonResult("取消保存");
            return "jsonResult";
        }

        if (delete != null) {
            monitorDataManager.remove(monitorData.getMonitorId());
        	super.setJsonResult("删除成功");
            return "jsonResult";
        }

        boolean isNew = (monitorData.getMonitorId() == null);

        monitorData = monitorDataManager.save(monitorData);

        String key = (isNew) ? "monitorData.added" : "monitorData.updated";
        saveMessage(getText(key));

        super.setJsonResult("SaveSuccess");
        return "jsonResult";
    }
}