package com.joker.wms.service.impl;

import com.joker.wms.dao.StatusTypeDao;
import com.joker.wms.model.StatusType;
import com.joker.wms.service.StatusTypeManager;
import com.joker.wms.service.impl.GenericManagerImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import javax.jws.WebService;

@Service("statusTypeManager")
@WebService(serviceName = "StatusTypeService", endpointInterface = "com.joker.wms.service.StatusTypeManager")
public class StatusTypeManagerImpl extends GenericManagerImpl<StatusType, Long> implements StatusTypeManager {
    StatusTypeDao statusTypeDao;

    @Autowired
    public StatusTypeManagerImpl(StatusTypeDao statusTypeDao) {
        super(statusTypeDao);
        this.statusTypeDao = statusTypeDao;
    }
}