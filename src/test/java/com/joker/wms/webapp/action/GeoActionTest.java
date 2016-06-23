package com.joker.wms.webapp.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import com.joker.wms.service.GeoManager;
import com.joker.wms.model.Geo;
import com.joker.wms.webapp.action.BaseActionTestCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class GeoActionTest extends BaseActionTestCase {
    private GeoAction action;

    @Autowired
    private GeoManager geoManager;

    @Before
    public void onSetUp() {
        super.onSetUp();

        action = new GeoAction();
        action.setGeoManager(geoManager);

        // add a test geo to the database
        Geo geo = new Geo();

        // enter all required fields

        geoManager.save(geo);
    }

    @Test
    public void testGetAllGeoes() throws Exception {
        assertEquals(action.list(), ActionSupport.SUCCESS);
        assertTrue(action.getGeoes().size() >= 1);
    }

    @Test
    public void testSearch() throws Exception {
        // regenerate indexes
        geoManager.reindex();

        action.setQ("*");
        assertEquals(action.list(), ActionSupport.SUCCESS);
        assertEquals(4, action.getGeoes().size());
    }

    @Test
    public void testEdit() throws Exception {
        log.debug("testing edit...");
        action.setGeoId(-1L);
        assertNull(action.getGeo());
        assertEquals("success", action.edit());
        assertNotNull(action.getGeo());
        assertFalse(action.hasActionErrors());
    }

    @Test
    public void testSave() throws Exception {
        MockHttpServletRequest request = new MockHttpServletRequest();
        ServletActionContext.setRequest(request);
        action.setGeoId(-1L);
        assertEquals("success", action.edit());
        assertNotNull(action.getGeo());

        Geo geo = action.getGeo();
        // update required fields

        action.setGeo(geo);

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
        Geo geo = new Geo();
        geo.setGeoId(-2L);
        action.setGeo(geo);
        assertEquals("success", action.delete());
        assertNotNull(request.getSession().getAttribute("messages"));
    }
}
