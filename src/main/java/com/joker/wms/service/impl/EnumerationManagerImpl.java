package com.joker.wms.service.impl;

import com.joker.wms.dao.EnumerationDao;
import com.joker.wms.model.Enumeration;
import com.joker.wms.service.EnumerationManager;
import com.joker.wms.service.impl.GenericManagerImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import javax.jws.WebService;

@Service("enumerationManager")
@WebService(serviceName = "EnumerationService", endpointInterface = "com.joker.wms.service.EnumerationManager")
public class EnumerationManagerImpl extends GenericManagerImpl<Enumeration, Long> implements EnumerationManager {
    EnumerationDao enumerationDao;

    @Autowired
    public EnumerationManagerImpl(EnumerationDao enumerationDao) {
        super(enumerationDao);
        this.enumerationDao = enumerationDao;
    }

	@Override
	public List getYFTypes() {
		return enumerationDao.getYFTypes(null);
	}

	@Override
	public List getGeoLists(Long parentGeoId) {
		return enumerationDao.getGeoLists(parentGeoId);
	}
}