package com.joker.wms.service.impl;

import com.joker.wms.dao.AlarmSetDao;
import com.joker.wms.model.AlarmSet;
import com.joker.wms.service.AlarmSetManager;
import com.joker.wms.service.impl.GenericManagerImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import javax.jws.WebService;

@Service("alarmSetManager")
@WebService(serviceName = "AlarmSetService", endpointInterface = "com.joker.wms.service.AlarmSetManager")
public class AlarmSetManagerImpl extends GenericManagerImpl<AlarmSet, Long> implements AlarmSetManager {
    AlarmSetDao alarmSetDao;

    @Autowired
    public AlarmSetManagerImpl(AlarmSetDao alarmSetDao) {
        super(alarmSetDao);
        this.alarmSetDao = alarmSetDao;
    }
}