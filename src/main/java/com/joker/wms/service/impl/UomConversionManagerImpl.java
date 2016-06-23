package com.joker.wms.service.impl;

import com.joker.wms.dao.UomConversionDao;
import com.joker.wms.model.UomConversion;
import com.joker.wms.service.UomConversionManager;
import com.joker.wms.service.impl.GenericManagerImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import javax.jws.WebService;

@Service("uomConversionManager")
@WebService(serviceName = "UomConversionService", endpointInterface = "com.joker.wms.service.UomConversionManager")
public class UomConversionManagerImpl extends GenericManagerImpl<UomConversion, Long> implements UomConversionManager {
    UomConversionDao uomConversionDao;

    @Autowired
    public UomConversionManagerImpl(UomConversionDao uomConversionDao) {
        super(uomConversionDao);
        this.uomConversionDao = uomConversionDao;
    }
}