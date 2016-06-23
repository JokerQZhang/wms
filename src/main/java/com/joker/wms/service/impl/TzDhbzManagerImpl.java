package com.joker.wms.service.impl;

import com.joker.wms.dao.TzDhbzDao;
import com.joker.wms.model.TzDhbz;
import com.joker.wms.service.TzDhbzManager;
import com.joker.wms.service.impl.GenericManagerImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import javax.jws.WebService;

@Service("tzDhbzManager")
@WebService(serviceName = "TzDhbzService", endpointInterface = "com.joker.wms.service.TzDhbzManager")
public class TzDhbzManagerImpl extends GenericManagerImpl<TzDhbz, Long> implements TzDhbzManager {
    TzDhbzDao tzDhbzDao;

    @Autowired
    public TzDhbzManagerImpl(TzDhbzDao tzDhbzDao) {
        super(tzDhbzDao);
        this.tzDhbzDao = tzDhbzDao;
    }
}