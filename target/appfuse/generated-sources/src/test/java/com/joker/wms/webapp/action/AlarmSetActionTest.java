package com.joker.wms.webapp.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import com.joker.wms.service.AlarmSetManager;
import com.joker.wms.model.AlarmSet;
import com.joker.wms.webapp.action.BaseActionTestCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class AlarmSetActionTest extends BaseActionTestCase {
    private AlarmSetAction action;

    @Autowired
    private AlarmSetManager alarmSetManager;

    @Before
    public void onSetUp() {
        super.onSetUp();

        action = new AlarmSetAction();
        action.setAlarmSetManager(alarmSetManager);

        // add a test alarmSet to the database
        AlarmSet alarmSet = new AlarmSet();

        // enter all required fields

        alarmSetManager.save(alarmSet);
    }

    @Test
    public void testGetAllAlarmSets() throws Exception {
        assertEquals(action.list(), ActionSupport.SUCCESS);
        assertTrue(action.getAlarmSets().size() >= 1);
    }

    @Test
    public void testSearch() throws Exception {
        // regenerate indexes
        alarmSetManager.reindex();

        action.setQ("*");
        assertEquals(action.list(), ActionSupport.SUCCESS);
        assertEquals(4, action.getAlarmSets().size());
    }

    @Test
    public void testEdit() throws Exception {
        log.debug("testing edit...");
        action.setAlarmSetId(-1L);
        assertNull(action.getAlarmSet());
        assertEquals("success", action.edit());
        assertNotNull(action.getAlarmSet());
        assertFalse(action.hasActionErrors());
    }

    @Test
    public void testSave() throws Exception {
        MockHttpServletRequest request = new MockHttpServletRequest();
        ServletActionContext.setRequest(request);
        action.setAlarmSetId(-1L);
        assertEquals("success", action.edit());
        assertNotNull(action.getAlarmSet());

        AlarmSet alarmSet = action.getAlarmSet();
        // update required fields

        action.setAlarmSet(alarmSet);

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
        AlarmSet alarmSet = new AlarmSet();
        alarmSet.setAlarmSetId(-2L);
        action.setAlarmSet(alarmSet);
        assertEquals("success", action.delete());
        assertNotNull(request.getSession().getAttribute("messages"));
    }
}
