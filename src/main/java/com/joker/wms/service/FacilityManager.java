package com.joker.wms.service;

import com.joker.wms.service.GenericManager;
import com.joker.wms.model.Facility;

import java.util.List;
import javax.jws.WebService;

@WebService
public interface FacilityManager extends GenericManager<Facility, Long> {
    public List getFacilityByUserId(String userId);
}