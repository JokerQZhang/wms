package com.joker.wms.service.impl;

import com.joker.wms.dao.UomTypeDao;
import com.joker.wms.model.UomType;
import com.joker.wms.service.UomTypeManager;
import com.joker.wms.service.impl.GenericManagerImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import javax.jws.WebService;

@Service("uomTypeManager")
@WebService(serviceName = "UomTypeService", endpointInterface = "com.joker.wms.service.UomTypeManager")
public class UomTypeManagerImpl extends GenericManagerImpl<UomType, Long> implements UomTypeManager {
    UomTypeDao uomTypeDao;

    @Autowired
    public UomTypeManagerImpl(UomTypeDao uomTypeDao) {
        super(uomTypeDao);
        this.uomTypeDao = uomTypeDao;
    }
}