package com.joker.wms.service.impl;

import com.joker.wms.dao.TzFwqzDao;
import com.joker.wms.model.TzFwqz;
import com.joker.wms.service.TzFwqzManager;
import com.joker.wms.service.impl.GenericManagerImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import javax.jws.WebService;

@Service("tzFwqzManager")
@WebService(serviceName = "TzFwqzService", endpointInterface = "com.joker.wms.service.TzFwqzManager")
public class TzFwqzManagerImpl extends GenericManagerImpl<TzFwqz, Long> implements TzFwqzManager {
    TzFwqzDao tzFwqzDao;

    @Autowired
    public TzFwqzManagerImpl(TzFwqzDao tzFwqzDao) {
        super(tzFwqzDao);
        this.tzFwqzDao = tzFwqzDao;
    }
}