package com.joker.wms.service;

import com.joker.wms.service.GenericManager;
import com.joker.wms.model.Geo;

import java.util.List;
import javax.jws.WebService;

@WebService
public interface GeoManager extends GenericManager<Geo, Long> {
    
}