package com.joker.wms.dao;

import com.joker.wms.dao.BaseDaoTestCase;
import com.joker.wms.model.MonitorData;
import org.springframework.dao.DataAccessException;

import static org.junit.Assert.*;
import org.junit.Test;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class MonitorDataDaoTest extends BaseDaoTestCase {
    @Autowired
    private MonitorDataDao monitorDataDao;

    @Test(expected=DataAccessException.class)
    public void testAddAndRemoveMonitorData() {
        MonitorData monitorData = new MonitorData();

        // enter all required fields

        log.debug("adding monitorData...");
        monitorData = monitorDataDao.save(monitorData);

        monitorData = monitorDataDao.get(monitorData.getMonitorId());

        assertNotNull(monitorData.getMonitorId());

        log.debug("removing monitorData...");

        monitorDataDao.remove(monitorData.getMonitorId());

        // should throw DataAccessException 
        monitorDataDao.get(monitorData.getMonitorId());
    }
}