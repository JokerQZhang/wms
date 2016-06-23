package com.joker.wms.service;

import com.joker.wms.service.GenericManager;
import com.joker.wms.model.SalePlanDtl;

import java.util.List;
import javax.jws.WebService;

@WebService
public interface SalePlanDtlManager extends GenericManager<SalePlanDtl, Long> {
    
}