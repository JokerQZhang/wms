package com.joker.wms.service;

import com.joker.wms.service.GenericManager;
import com.joker.wms.model.StatusType;

import java.util.List;
import javax.jws.WebService;

@WebService
public interface StatusTypeManager extends GenericManager<StatusType, Long> {
    
}