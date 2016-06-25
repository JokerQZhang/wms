package com.joker.wms.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.joker.wms.dao.MoniteSiteDao;
import com.joker.wms.model.MoniteSite;
import com.joker.wms.service.impl.BaseManagerMockTestCase;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.BDDMockito.*;

public class MoniteSiteManagerImplTest extends BaseManagerMockTestCase {

    @InjectMocks
    private MoniteSiteManagerImpl manager;

    @Mock
    private MoniteSiteDao dao;

    @Test
    public void testGetMoniteSite() {
        log.debug("testing get...");
        //given
        final Long siteId = 7L;
        final MoniteSite moniteSite = new MoniteSite();
        given(dao.get(siteId)).willReturn(moniteSite);

        //when
        MoniteSite result = manager.get(siteId);

        //then
        assertSame(moniteSite, result);
    }

    @Test
    public void testGetMoniteSites() {
        log.debug("testing getAll...");
        //given
        final List<MoniteSite> moniteSites = new ArrayList<>();
        given(dao.getAll()).willReturn(moniteSites);

        //when
        List result = manager.getAll();

        //then
        assertSame(moniteSites, result);
    }

    @Test
    public void testSaveMoniteSite() {
        log.debug("testing save...");

        //given
        final MoniteSite moniteSite = new MoniteSite();
        // enter all required fields

        given(dao.save(moniteSite)).willReturn(moniteSite);

        //when
        manager.save(moniteSite);

        //then
        verify(dao).save(moniteSite);
    }

    @Test
    public void testRemoveMoniteSite() {
        log.debug("testing remove...");

        //given
        final Long siteId = -11L;
        willDoNothing().given(dao).remove(siteId);

        //when
        manager.remove(siteId);

        //then
        verify(dao).remove(siteId);
    }
}
