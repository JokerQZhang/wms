package com.joker.wms.dao;

import com.joker.wms.dao.BaseDaoTestCase;
import com.joker.wms.model.MoniteSite;
import org.springframework.dao.DataAccessException;

import static org.junit.Assert.*;
import org.junit.Test;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class MoniteSiteDaoTest extends BaseDaoTestCase {
    @Autowired
    private MoniteSiteDao moniteSiteDao;

    @Test(expected=DataAccessException.class)
    public void testAddAndRemoveMoniteSite() {
        MoniteSite moniteSite = new MoniteSite();

        // enter all required fields

        log.debug("adding moniteSite...");
        moniteSite = moniteSiteDao.save(moniteSite);

        moniteSite = moniteSiteDao.get(moniteSite.getSiteId());

        assertNotNull(moniteSite.getSiteId());

        log.debug("removing moniteSite...");

        moniteSiteDao.remove(moniteSite.getSiteId());

        // should throw DataAccessException 
        moniteSiteDao.get(moniteSite.getSiteId());
    }
}