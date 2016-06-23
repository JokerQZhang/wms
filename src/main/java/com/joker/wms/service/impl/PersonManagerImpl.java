package com.joker.wms.service.impl;

import com.joker.wms.dao.PersonDao;
import com.joker.wms.model.CpDtl;
import com.joker.wms.model.CpPositive;
import com.joker.wms.model.Person;
import com.joker.wms.service.PersonManager;
import com.joker.wms.service.impl.GenericManagerImpl;
import com.joker.wms.webapp.action.Page;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.jws.WebService;

@Service("personManager")
@WebService(serviceName = "PersonService", endpointInterface = "com.joker.wms.service.PersonManager")
public class PersonManagerImpl extends GenericManagerImpl<Person, Long> implements PersonManager {
    PersonDao personDao;

    @Autowired
    public PersonManagerImpl(PersonDao personDao) {
        super(personDao);
        this.personDao = personDao;
    }

	@Override
	public List searchByGroupId(Class claaz, Page page, String belongGroupId) {
		return personDao.searchAllByGroupId(claaz, page, belongGroupId);
	}

	@Override
	public List getDangPerson(String belongGroupId, String isNowDangwei) {
		Map condition = new HashMap();
		condition.put("belongGroupId", belongGroupId);
		condition.put("isNowDangwei", isNowDangwei);
		condition.put("statusId", "1");
		return personDao.getDangPerson(condition);
	}

	@Override
	public CpDtl getCpDtlByPartyId(Long partyId) {
		if(partyId==null){
			return null;
		}else{
			Map condition = new HashMap();
			condition.put("partyId", partyId);
			List cpDtls = personDao.findCpDtl(condition);
			if(cpDtls!=null && cpDtls.size()>0){
				CpDtl cpDtl = (CpDtl)cpDtls.get(0);
				return cpDtl;
			}else{
				return null;
			}
		}
	}

	@Override
	public CpPositive getCpPositiveByPartyId(Long partyId) {
		if(partyId!=null){
			Map condition = new HashMap();
			condition.put("partyId", partyId);
			List cpPositives = personDao.findCpPositive(condition);
			if(cpPositives!=null && cpPositives.size()>0){
				CpPositive cpPositive = (CpPositive)cpPositives.get(0);
				return cpPositive;
			}
		}
		return null;
	}

	@Override
	public List getPositivePerson(String belongGroupId, String isNowDangwei) {
		Map condition = new HashMap();
		condition.put("belongGroupId", belongGroupId);
		condition.put("isNowDangwei", isNowDangwei);
		condition.put("statusIdIn", "('2','3','4')");
		return personDao.getDangPerson(condition);
	}

	@Override
	public boolean approvalDangPerson(String partyId, String totalNum,
			String approvalNum, String approvalResult, String resultStatus) {
		if(partyId!=null && !"".equals(partyId)){
			return personDao.approvalDangPerson(partyId,totalNum,approvalNum,approvalResult,resultStatus);
		}
		return false;
	}

	@Override
	public List getPersonRoles(Long partyId) {
		Map condition = new HashMap();
		condition.put("partyId", partyId);
		return personDao.getPersonRoles(condition);
	}
}