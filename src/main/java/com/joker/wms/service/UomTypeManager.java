package com.joker.wms.service;

import com.joker.wms.service.GenericManager;
import com.joker.wms.model.UomType;

import java.util.List;
import javax.jws.WebService;

@WebService
public interface UomTypeManager extends GenericManager<UomType, Long> {
    
}