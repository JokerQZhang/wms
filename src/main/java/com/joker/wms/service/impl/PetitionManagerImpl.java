package com.joker.wms.service.impl;

import com.joker.wms.dao.PetitionDao;
import com.joker.wms.model.Petition;
import com.joker.wms.service.PetitionManager;
import com.joker.wms.service.impl.GenericManagerImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import javax.jws.WebService;

@Service("petitionManager")
@WebService(serviceName = "PetitionService", endpointInterface = "com.joker.wms.service.PetitionManager")
public class PetitionManagerImpl extends GenericManagerImpl<Petition, Long> implements PetitionManager {
    PetitionDao petitionDao;

    @Autowired
    public PetitionManagerImpl(PetitionDao petitionDao) {
        super(petitionDao);
        this.petitionDao = petitionDao;
    }
}