package com.joker.wms.service.impl;

import com.joker.wms.dao.TzZtjjDao;
import com.joker.wms.model.TzZtjj;
import com.joker.wms.service.TzZtjjManager;
import com.joker.wms.service.impl.GenericManagerImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import javax.jws.WebService;

@Service("tzZtjjManager")
@WebService(serviceName = "TzZtjjService", endpointInterface = "com.joker.wms.service.TzZtjjManager")
public class TzZtjjManagerImpl extends GenericManagerImpl<TzZtjj, Long> implements TzZtjjManager {
    TzZtjjDao tzZtjjDao;

    @Autowired
    public TzZtjjManagerImpl(TzZtjjDao tzZtjjDao) {
        super(tzZtjjDao);
        this.tzZtjjDao = tzZtjjDao;
    }
}