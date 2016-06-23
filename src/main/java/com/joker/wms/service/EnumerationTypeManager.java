package com.joker.wms.service;

import com.joker.wms.service.GenericManager;
import com.joker.wms.model.EnumerationType;

import java.util.List;
import javax.jws.WebService;

@WebService
public interface EnumerationTypeManager extends GenericManager<EnumerationType, Long> {
    
}