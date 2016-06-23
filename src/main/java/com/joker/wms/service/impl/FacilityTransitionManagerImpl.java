package com.joker.wms.service.impl;

import com.joker.wms.dao.FacilityTransitionDao;
import com.joker.wms.model.FacilityTransition;
import com.joker.wms.service.FacilityTransitionManager;
import com.joker.wms.service.impl.GenericManagerImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import javax.jws.WebService;

@Service("facilityTransitionManager")
@WebService(serviceName = "FacilityTransitionService", endpointInterface = "com.joker.wms.service.FacilityTransitionManager")
public class FacilityTransitionManagerImpl extends GenericManagerImpl<FacilityTransition, Long> implements FacilityTransitionManager {
    FacilityTransitionDao facilityTransitionDao;

    @Autowired
    public FacilityTransitionManagerImpl(FacilityTransitionDao facilityTransitionDao) {
        super(facilityTransitionDao);
        this.facilityTransitionDao = facilityTransitionDao;
    }
}