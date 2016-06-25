package com.joker.wms.service.impl;

import com.joker.wms.dao.MoniteSiteDao;
import com.joker.wms.model.MoniteSite;
import com.joker.wms.service.MoniteSiteManager;
import com.joker.wms.service.impl.GenericManagerImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import javax.jws.WebService;

@Service("moniteSiteManager")
@WebService(serviceName = "MoniteSiteService", endpointInterface = "com.joker.wms.service.MoniteSiteManager")
public class MoniteSiteManagerImpl extends GenericManagerImpl<MoniteSite, Long> implements MoniteSiteManager {
    MoniteSiteDao moniteSiteDao;

    @Autowired
    public MoniteSiteManagerImpl(MoniteSiteDao moniteSiteDao) {
        super(moniteSiteDao);
        this.moniteSiteDao = moniteSiteDao;
    }
}