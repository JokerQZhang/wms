package com.joker.wms.dao;

import com.joker.wms.dao.BaseDaoTestCase;
import com.joker.wms.model.Geo;
import org.springframework.dao.DataAccessException;

import static org.junit.Assert.*;
import org.junit.Test;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class GeoDaoTest extends BaseDaoTestCase {
    @Autowired
    private GeoDao geoDao;

    @Test(expected=DataAccessException.class)
    public void testAddAndRemoveGeo() {
        Geo geo = new Geo();

        // enter all required fields

        log.debug("adding geo...");
        geo = geoDao.save(geo);

        geo = geoDao.get(geo.getGeoId());

        assertNotNull(geo.getGeoId());

        log.debug("removing geo...");

        geoDao.remove(geo.getGeoId());

        // should throw DataAccessException 
        geoDao.get(geo.getGeoId());
    }
}