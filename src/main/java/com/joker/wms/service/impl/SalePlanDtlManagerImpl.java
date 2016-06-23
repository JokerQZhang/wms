package com.joker.wms.service.impl;

import com.joker.wms.dao.SalePlanDtlDao;
import com.joker.wms.model.SalePlanDtl;
import com.joker.wms.service.SalePlanDtlManager;
import com.joker.wms.service.impl.GenericManagerImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import javax.jws.WebService;

@Service("salePlanDtlManager")
@WebService(serviceName = "SalePlanDtlService", endpointInterface = "com.joker.wms.service.SalePlanDtlManager")
public class SalePlanDtlManagerImpl extends GenericManagerImpl<SalePlanDtl, Long> implements SalePlanDtlManager {
    SalePlanDtlDao salePlanDtlDao;

    @Autowired
    public SalePlanDtlManagerImpl(SalePlanDtlDao salePlanDtlDao) {
        super(salePlanDtlDao);
        this.salePlanDtlDao = salePlanDtlDao;
    }
}