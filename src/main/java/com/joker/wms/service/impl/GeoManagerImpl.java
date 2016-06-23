package com.joker.wms.service.impl;

import com.joker.wms.dao.GeoDao;
import com.joker.wms.model.Geo;
import com.joker.wms.service.GeoManager;
import com.joker.wms.service.impl.GenericManagerImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import javax.jws.WebService;

@Service("geoManager")
@WebService(serviceName = "GeoService", endpointInterface = "com.joker.wms.service.GeoManager")
public class GeoManagerImpl extends GenericManagerImpl<Geo, Long> implements GeoManager {
    GeoDao geoDao;

    @Autowired
    public GeoManagerImpl(GeoDao geoDao) {
        super(geoDao);
        this.geoDao = geoDao;
    }
}