package com.joker.wms.service.impl;

import com.joker.wms.dao.StatusItemDao;
import com.joker.wms.model.StatusItem;
import com.joker.wms.service.StatusItemManager;
import com.joker.wms.service.impl.GenericManagerImpl;
import com.joker.wms.webapp.action.Page;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import javax.jws.WebService;

@Service("statusItemManager")
@WebService(serviceName = "StatusItemService", endpointInterface = "com.joker.wms.service.StatusItemManager")
public class StatusItemManagerImpl extends GenericManagerImpl<StatusItem, Long> implements StatusItemManager {
    StatusItemDao statusItemDao;

    @Autowired
    public StatusItemManagerImpl(StatusItemDao statusItemDao) {
        super(statusItemDao);
        this.statusItemDao = statusItemDao;
    }

	@Override
	public List searchByTypeId(String typeId, Class clazz, Page page) {
		return statusItemDao.searchByTypeId(typeId, clazz, page);
	}
}