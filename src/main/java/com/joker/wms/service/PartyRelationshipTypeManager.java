package com.joker.wms.service;

import com.joker.wms.service.GenericManager;
import com.joker.wms.model.PartyRelationshipType;

import java.util.List;
import javax.jws.WebService;

@WebService
public interface PartyRelationshipTypeManager extends GenericManager<PartyRelationshipType, Long> {
    
}