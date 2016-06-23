package com.joker.wms.service.impl;

import com.joker.wms.dao.PartyRelationshipTypeDao;
import com.joker.wms.model.PartyRelationshipType;
import com.joker.wms.service.PartyRelationshipTypeManager;
import com.joker.wms.service.impl.GenericManagerImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import javax.jws.WebService;

@Service("partyRelationshipTypeManager")
@WebService(serviceName = "PartyRelationshipTypeService", endpointInterface = "com.joker.wms.service.PartyRelationshipTypeManager")
public class PartyRelationshipTypeManagerImpl extends GenericManagerImpl<PartyRelationshipType, Long> implements PartyRelationshipTypeManager {
    PartyRelationshipTypeDao partyRelationshipTypeDao;

    @Autowired
    public PartyRelationshipTypeManagerImpl(PartyRelationshipTypeDao partyRelationshipTypeDao) {
        super(partyRelationshipTypeDao);
        this.partyRelationshipTypeDao = partyRelationshipTypeDao;
    }
}