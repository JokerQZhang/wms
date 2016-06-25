package com.joker.wms.webapp.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import com.joker.wms.service.MonitorDataManager;
import com.joker.wms.model.MonitorData;
import com.joker.wms.webapp.action.BaseActionTestCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class MonitorDataActionTest extends BaseActionTestCase {
    private MonitorDataAction action;

    @Autowired
    private MonitorDataManager monitorDataManager;

    @Before
    public void onSetUp() {
        super.onSetUp();

        action = new MonitorDataAction();
        action.setMonitorDataManager(monitorDataManager);

        // add a test monitorData to the database
        MonitorData monitorData = new MonitorData();

        // enter all required fields

        monitorDataManager.save(monitorData);
    }

    @Test
    public void testGetAllMonitorDatas() throws Exception {
        assertEquals(action.list(), ActionSupport.SUCCESS);
        assertTrue(action.getMonitorDatas().size() >= 1);
    }

    @Test
    public void testSearch() throws Exception {
        // regenerate indexes
        monitorDataManager.reindex();

        action.setQ("*");
        assertEquals(action.list(), ActionSupport.SUCCESS);
        assertEquals(4, action.getMonitorDatas().size());
    }

    @Test
    public void testEdit() throws Exception {
        log.debug("testing edit...");
        action.setMonitorId(-1L);
        assertNull(action.getMonitorData());
        assertEquals("success", action.edit());
        assertNotNull(action.getMonitorData());
        assertFalse(action.hasActionErrors());
    }

    @Test
    public void testSave() throws Exception {
        MockHttpServletRequest request = new MockHttpServletRequest();
        ServletActionContext.setRequest(request);
        action.setMonitorId(-1L);
        assertEquals("success", action.edit());
        assertNotNull(action.getMonitorData());

        MonitorData monitorData = action.getMonitorData();
        // update required fields

        action.setMonitorData(monitorData);

        assertEquals("input", action.save());
        assertFalse(action.hasActionErrors());
        assertFalse(action.hasFieldErrors());
        assertNotNull(request.getSession().getAttribute("messages"));
    }

    @Test
    public void testRemove() throws Exception {
        MockHttpServletRequest request = new MockHttpServletRequest();
        ServletActionContext.setRequest(request);
        action.setDelete("");
        MonitorData monitorData = new MonitorData();
        monitorData.setMonitorId(-2L);
        action.setMonitorData(monitorData);
        assertEquals("success", action.delete());
        assertNotNull(request.getSession().getAttribute("messages"));
    }
}
