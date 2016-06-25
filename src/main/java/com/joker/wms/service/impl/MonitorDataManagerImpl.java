package com.joker.wms.service.impl;

import com.joker.wms.dao.MonitorDataDao;
import com.joker.wms.model.MonitorData;
import com.joker.wms.service.MonitorDataManager;
import com.joker.wms.service.impl.GenericManagerImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import javax.jws.WebService;

@Service("monitorDataManager")
@WebService(serviceName = "MonitorDataService", endpointInterface = "com.joker.wms.service.MonitorDataManager")
public class MonitorDataManagerImpl extends GenericManagerImpl<MonitorData, Long> implements MonitorDataManager {
    MonitorDataDao monitorDataDao;

    @Autowired
    public MonitorDataManagerImpl(MonitorDataDao monitorDataDao) {
        super(monitorDataDao);
        this.monitorDataDao = monitorDataDao;
    }
}