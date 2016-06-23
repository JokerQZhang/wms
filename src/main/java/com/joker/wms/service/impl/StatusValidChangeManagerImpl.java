package com.joker.wms.service.impl;

import com.joker.wms.dao.StatusValidChangeDao;
import com.joker.wms.model.StatusValidChange;
import com.joker.wms.service.StatusValidChangeManager;
import com.joker.wms.service.impl.GenericManagerImpl;
import com.joker.wms.webapp.action.Page;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import javax.jws.WebService;

@Service("statusValidChangeManager")
@WebService(serviceName = "StatusValidChangeService", endpointInterface = "com.joker.wms.service.StatusValidChangeManager")
public class StatusValidChangeManagerImpl extends GenericManagerImpl<StatusValidChange, Long> implements StatusValidChangeManager {
    StatusValidChangeDao statusValidChangeDao;

    @Autowired
    public StatusValidChangeManagerImpl(StatusValidChangeDao statusValidChangeDao) {
        super(statusValidChangeDao);
        this.statusValidChangeDao = statusValidChangeDao;
    }

	@Override
	public List searchByTypeId(String typeId, Class clazz, Page page) {
		return statusValidChangeDao.searchByTypeId(typeId, clazz, page);
	}
}