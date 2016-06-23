package com.joker.wms.service.impl;

import com.joker.wms.dao.TbCarePeopleDao;
import com.joker.wms.model.TbCarePeople;
import com.joker.wms.service.TbCarePeopleManager;
import com.joker.wms.service.impl.GenericManagerImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.jws.WebService;

@Service("tbCarePeopleManager")
@WebService(serviceName = "TbCarePeopleService", endpointInterface = "com.joker.wms.service.TbCarePeopleManager")
public class TbCarePeopleManagerImpl extends GenericManagerImpl<TbCarePeople, Long> implements TbCarePeopleManager {
    TbCarePeopleDao tbCarePeopleDao;

    @Autowired
    public TbCarePeopleManagerImpl(TbCarePeopleDao tbCarePeopleDao) {
        super(tbCarePeopleDao);
        this.tbCarePeopleDao = tbCarePeopleDao;
    }

	@Override
	public List getYFTypeByPeopleId(String peopleId) {
		Map condition = new HashMap();
		condition.put("peopleId", peopleId);
		return tbCarePeopleDao.getYFType(condition);
	}
}