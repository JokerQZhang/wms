package com.joker.wms.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.joker.wms.dao.GeoDao;
import com.joker.wms.model.Geo;
import com.joker.wms.service.impl.BaseManagerMockTestCase;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.BDDMockito.*;

public class GeoManagerImplTest extends BaseManagerMockTestCase {

    @InjectMocks
    private GeoManagerImpl manager;

    @Mock
    private GeoDao dao;

    @Test
    public void testGetGeo() {
        log.debug("testing get...");
        //given
        final Long geoId = 7L;
        final Geo geo = new Geo();
        given(dao.get(geoId)).willReturn(geo);

        //when
        Geo result = manager.get(geoId);

        //then
        assertSame(geo, result);
    }

    @Test
    public void testGetGeoes() {
        log.debug("testing getAll...");
        //given
        final List<Geo> geoes = new ArrayList<>();
        given(dao.getAll()).willReturn(geoes);

        //when
        List result = manager.getAll();

        //then
        assertSame(geoes, result);
    }

    @Test
    public void testSaveGeo() {
        log.debug("testing save...");

        //given
        final Geo geo = new Geo();
        // enter all required fields

        given(dao.save(geo)).willReturn(geo);

        //when
        manager.save(geo);

        //then
        verify(dao).save(geo);
    }

    @Test
    public void testRemoveGeo() {
        log.debug("testing remove...");

        //given
        final Long geoId = -11L;
        willDoNothing().given(dao).remove(geoId);

        //when
        manager.remove(geoId);

        //then
        verify(dao).remove(geoId);
    }
}
