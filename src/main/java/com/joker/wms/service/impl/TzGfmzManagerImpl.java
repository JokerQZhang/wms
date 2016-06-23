package com.joker.wms.service.impl;

import com.joker.wms.dao.TzGfmzDao;
import com.joker.wms.model.TzGfmz;
import com.joker.wms.service.TzGfmzManager;
import com.joker.wms.service.impl.GenericManagerImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import javax.jws.WebService;

@Service("tzGfmzManager")
@WebService(serviceName = "TzGfmzService", endpointInterface = "com.joker.wms.service.TzGfmzManager")
public class TzGfmzManagerImpl extends GenericManagerImpl<TzGfmz, Long> implements TzGfmzManager {
    TzGfmzDao tzGfmzDao;

    @Autowired
    public TzGfmzManagerImpl(TzGfmzDao tzGfmzDao) {
        super(tzGfmzDao);
        this.tzGfmzDao = tzGfmzDao;
    }
}