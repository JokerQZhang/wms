package com.joker.wms.service;

import com.joker.wms.service.GenericManager;
import com.joker.wms.model.PartyRelationship;

import java.util.List;
import javax.jws.WebService;

@WebService
public interface PartyRelationshipManager extends GenericManager<PartyRelationship, Long> {
    
}