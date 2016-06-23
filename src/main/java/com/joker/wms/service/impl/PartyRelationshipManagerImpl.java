package com.joker.wms.service.impl;

import com.joker.wms.dao.PartyRelationshipDao;
import com.joker.wms.model.PartyRelationship;
import com.joker.wms.service.PartyRelationshipManager;
import com.joker.wms.service.impl.GenericManagerImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import javax.jws.WebService;

@Service("partyRelationshipManager")
@WebService(serviceName = "PartyRelationshipService", endpointInterface = "com.joker.wms.service.PartyRelationshipManager")
public class PartyRelationshipManagerImpl extends GenericManagerImpl<PartyRelationship, Long> implements PartyRelationshipManager {
    PartyRelationshipDao partyRelationshipDao;

    @Autowired
    public PartyRelationshipManagerImpl(PartyRelationshipDao partyRelationshipDao) {
        super(partyRelationshipDao);
        this.partyRelationshipDao = partyRelationshipDao;
    }
}