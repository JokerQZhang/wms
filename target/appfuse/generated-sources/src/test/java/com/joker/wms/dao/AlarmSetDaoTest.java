package com.joker.wms.dao;

import com.joker.wms.dao.BaseDaoTestCase;
import com.joker.wms.model.AlarmSet;
import org.springframework.dao.DataAccessException;

import static org.junit.Assert.*;
import org.junit.Test;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AlarmSetDaoTest extends BaseDaoTestCase {
    @Autowired
    private AlarmSetDao alarmSetDao;

    @Test(expected=DataAccessException.class)
    public void testAddAndRemoveAlarmSet() {
        AlarmSet alarmSet = new AlarmSet();

        // enter all required fields

        log.debug("adding alarmSet...");
        alarmSet = alarmSetDao.save(alarmSet);

        alarmSet = alarmSetDao.get(alarmSet.getAlarmSetId());

        assertNotNull(alarmSet.getAlarmSetId());

        log.debug("removing alarmSet...");

        alarmSetDao.remove(alarmSet.getAlarmSetId());

        // should throw DataAccessException 
        alarmSetDao.get(alarmSet.getAlarmSetId());
    }
}