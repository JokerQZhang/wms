package com.joker.wms.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.joker.wms.dao.MonitorDataDao;
import com.joker.wms.model.MonitorData;
import com.joker.wms.service.impl.BaseManagerMockTestCase;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.BDDMockito.*;

public class MonitorDataManagerImplTest extends BaseManagerMockTestCase {

    @InjectMocks
    private MonitorDataManagerImpl manager;

    @Mock
    private MonitorDataDao dao;

    @Test
    public void testGetMonitorData() {
        log.debug("testing get...");
        //given
        final Long monitorId = 7L;
        final MonitorData monitorData = new MonitorData();
        given(dao.get(monitorId)).willReturn(monitorData);

        //when
        MonitorData result = manager.get(monitorId);

        //then
        assertSame(monitorData, result);
    }

    @Test
    public void testGetMonitorDatas() {
        log.debug("testing getAll...");
        //given
        final List<MonitorData> monitorDatas = new ArrayList<>();
        given(dao.getAll()).willReturn(monitorDatas);

        //when
        List result = manager.getAll();

        //then
        assertSame(monitorDatas, result);
    }

    @Test
    public void testSaveMonitorData() {
        log.debug("testing save...");

        //given
        final MonitorData monitorData = new MonitorData();
        // enter all required fields

        given(dao.save(monitorData)).willReturn(monitorData);

        //when
        manager.save(monitorData);

        //then
        verify(dao).save(monitorData);
    }

    @Test
    public void testRemoveMonitorData() {
        log.debug("testing remove...");

        //given
        final Long monitorId = -11L;
        willDoNothing().given(dao).remove(monitorId);

        //when
        manager.remove(monitorId);

        //then
        verify(dao).remove(monitorId);
    }
}
