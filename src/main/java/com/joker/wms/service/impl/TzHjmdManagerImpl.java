package com.joker.wms.service.impl;

import com.joker.wms.dao.TzHjmdDao;
import com.joker.wms.model.TzHjmd;
import com.joker.wms.service.TzHjmdManager;
import com.joker.wms.service.impl.GenericManagerImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import javax.jws.WebService;

@Service("tzHjmdManager")
@WebService(serviceName = "TzHjmdService", endpointInterface = "com.joker.wms.service.TzHjmdManager")
public class TzHjmdManagerImpl extends GenericManagerImpl<TzHjmd, Long> implements TzHjmdManager {
    TzHjmdDao tzHjmdDao;

    @Autowired
    public TzHjmdManagerImpl(TzHjmdDao tzHjmdDao) {
        super(tzHjmdDao);
        this.tzHjmdDao = tzHjmdDao;
    }
}