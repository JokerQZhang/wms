package com.joker.wms.service;

import com.joker.wms.service.GenericManager;
import com.joker.wms.model.UomConversion;

import java.util.List;
import javax.jws.WebService;

@WebService
public interface UomConversionManager extends GenericManager<UomConversion, Long> {
    
}