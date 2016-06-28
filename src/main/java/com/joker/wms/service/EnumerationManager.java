package com.joker.wms.service;

import com.joker.wms.service.GenericManager;
import com.joker.wms.model.Enumeration;

import java.util.List;
import javax.jws.WebService;

@WebService
public interface EnumerationManager extends GenericManager<Enumeration, Long> {
    public List getYFTypes();
    public List getGeoLists(Long parentGeoId);
}