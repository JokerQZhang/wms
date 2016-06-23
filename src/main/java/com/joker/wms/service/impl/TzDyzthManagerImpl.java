package com.joker.wms.service.impl;

import com.joker.wms.dao.TzDyzthDao;
import com.joker.wms.model.TzDyzth;
import com.joker.wms.service.TzDyzthManager;
import com.joker.wms.service.impl.GenericManagerImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import javax.jws.WebService;

@Service("tzDyzthManager")
@WebService(serviceName = "TzDyzthService", endpointInterface = "com.joker.wms.service.TzDyzthManager")
public class TzDyzthManagerImpl extends GenericManagerImpl<TzDyzth, Long> implements TzDyzthManager {
    TzDyzthDao tzDyzthDao;

    @Autowired
    public TzDyzthManagerImpl(TzDyzthDao tzDyzthDao) {
        super(tzDyzthDao);
        this.tzDyzthDao = tzDyzthDao;
    }
}