package com.joker.wms.service;

import com.joker.wms.service.GenericManager;
import com.joker.wms.model.Petition;

import java.util.List;
import javax.jws.WebService;

@WebService
public interface PetitionManager extends GenericManager<Petition, Long> {
    
}