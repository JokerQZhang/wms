package com.joker.wms.webapp.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import com.joker.wms.service.MoniteSiteManager;
import com.joker.wms.model.MoniteSite;
import com.joker.wms.webapp.action.BaseActionTestCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class MoniteSiteActionTest extends BaseActionTestCase {
    private MoniteSiteAction action;

    @Autowired
    private MoniteSiteManager moniteSiteManager;

    @Before
    public void onSetUp() {
        super.onSetUp();

        action = new MoniteSiteAction();
        action.setMoniteSiteManager(moniteSiteManager);

        // add a test moniteSite to the database
        MoniteSite moniteSite = new MoniteSite();

        // enter all required fields

        moniteSiteManager.save(moniteSite);
    }

    @Test
    public void testGetAllMoniteSites() throws Exception {
        assertEquals(action.list(), ActionSupport.SUCCESS);
        assertTrue(action.getMoniteSites().size() >= 1);
    }

    @Test
    public void testSearch() throws Exception {
        // regenerate indexes
        moniteSiteManager.reindex();

        action.setQ("*");
        assertEquals(action.list(), ActionSupport.SUCCESS);
        assertEquals(4, action.getMoniteSites().size());
    }

    @Test
    public void testEdit() throws Exception {
        log.debug("testing edit...");
        action.setSiteId(-1L);
        assertNull(action.getMoniteSite());
        assertEquals("success", action.edit());
        assertNotNull(action.getMoniteSite());
        assertFalse(action.hasActionErrors());
    }

    @Test
    public void testSave() throws Exception {
        MockHttpServletRequest request = new MockHttpServletRequest();
        ServletActionContext.setRequest(request);
        action.setSiteId(-1L);
        assertEquals("success", action.edit());
        assertNotNull(action.getMoniteSite());

        MoniteSite moniteSite = action.getMoniteSite();
        // update required fields

        action.setMoniteSite(moniteSite);

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
        MoniteSite moniteSite = new MoniteSite();
        moniteSite.setSiteId(-2L);
        action.setMoniteSite(moniteSite);
        assertEquals("success", action.delete());
        assertNotNull(request.getSession().getAttribute("messages"));
    }
}
