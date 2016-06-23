package com.joker.wms.service.impl;

import com.joker.wms.dao.EnumerationTypeDao;
import com.joker.wms.model.EnumerationType;
import com.joker.wms.service.EnumerationTypeManager;
import com.joker.wms.service.impl.GenericManagerImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import javax.jws.WebService;

@Service("enumerationTypeManager")
@WebService(serviceName = "EnumerationTypeService", endpointInterface = "com.joker.wms.service.EnumerationTypeManager")
public class EnumerationTypeManagerImpl extends GenericManagerImpl<EnumerationType, Long> implements EnumerationTypeManager {
    EnumerationTypeDao enumerationTypeDao;

    @Autowired
    public EnumerationTypeManagerImpl(EnumerationTypeDao enumerationTypeDao) {
        super(enumerationTypeDao);
        this.enumerationTypeDao = enumerationTypeDao;
    }
}