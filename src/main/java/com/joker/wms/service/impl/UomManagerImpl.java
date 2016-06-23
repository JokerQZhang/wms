package com.joker.wms.service.impl;

import com.joker.wms.dao.UomDao;
import com.joker.wms.model.Uom;
import com.joker.wms.service.UomManager;
import com.joker.wms.service.impl.GenericManagerImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import javax.jws.WebService;

@Service("uomManager")
@WebService(serviceName = "UomService", endpointInterface = "com.joker.wms.service.UomManager")
public class UomManagerImpl extends GenericManagerImpl<Uom, Long> implements UomManager {
    UomDao uomDao;

    @Autowired
    public UomManagerImpl(UomDao uomDao) {
        super(uomDao);
        this.uomDao = uomDao;
    }
}