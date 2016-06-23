package com.joker.wms.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.joker.wms.dao.AlarmSetDao;
import com.joker.wms.model.AlarmSet;
import com.joker.wms.service.impl.BaseManagerMockTestCase;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.BDDMockito.*;

public class AlarmSetManagerImplTest extends BaseManagerMockTestCase {

    @InjectMocks
    private AlarmSetManagerImpl manager;

    @Mock
    private AlarmSetDao dao;

    @Test
    public void testGetAlarmSet() {
        log.debug("testing get...");
        //given
        final Long alarmSetId = 7L;
        final AlarmSet alarmSet = new AlarmSet();
        given(dao.get(alarmSetId)).willReturn(alarmSet);

        //when
        AlarmSet result = manager.get(alarmSetId);

        //then
        assertSame(alarmSet, result);
    }

    @Test
    public void testGetAlarmSets() {
        log.debug("testing getAll...");
        //given
        final List<AlarmSet> alarmSets = new ArrayList<>();
        given(dao.getAll()).willReturn(alarmSets);

        //when
        List result = manager.getAll();

        //then
        assertSame(alarmSets, result);
    }

    @Test
    public void testSaveAlarmSet() {
        log.debug("testing save...");

        //given
        final AlarmSet alarmSet = new AlarmSet();
        // enter all required fields

        given(dao.save(alarmSet)).willReturn(alarmSet);

        //when
        manager.save(alarmSet);

        //then
        verify(dao).save(alarmSet);
    }

    @Test
    public void testRemoveAlarmSet() {
        log.debug("testing remove...");

        //given
        final Long alarmSetId = -11L;
        willDoNothing().given(dao).remove(alarmSetId);

        //when
        manager.remove(alarmSetId);

        //then
        verify(dao).remove(alarmSetId);
    }
}
