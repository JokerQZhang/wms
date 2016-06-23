package com.joker.wms.service;

import com.joker.wms.service.GenericManager;
import com.joker.wms.model.FacilityTransition;

import java.util.List;
import javax.jws.WebService;

@WebService
public interface FacilityTransitionManager extends GenericManager<FacilityTransition, Long> {
    
}