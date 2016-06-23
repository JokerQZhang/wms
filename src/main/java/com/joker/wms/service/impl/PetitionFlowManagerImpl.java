package com.joker.wms.service.impl;

import com.joker.wms.dao.PetitionFlowDao;
import com.joker.wms.model.PetitionFlow;
import com.joker.wms.service.PetitionFlowManager;
import com.joker.wms.service.impl.GenericManagerImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.jws.WebService;

@Service("petitionFlowManager")
@WebService(serviceName = "PetitionFlowService", endpointInterface = "com.joker.wms.service.PetitionFlowManager")
public class PetitionFlowManagerImpl extends GenericManagerImpl<PetitionFlow, Long> implements PetitionFlowManager {
    PetitionFlowDao petitionFlowDao;

    @Autowired
    public PetitionFlowManagerImpl(PetitionFlowDao petitionFlowDao) {
        super(petitionFlowDao);
        this.petitionFlowDao = petitionFlowDao;
    }

	@Override
	public PetitionFlow getNowPetitionFlow(Long petitionId) {
		if(petitionId==null){
			return null;
		}else{
			Map condition = new HashMap();
			condition.put("petitionId", petitionId);
			condition.put("lastRecord", "yes");
			List petitionFlowList = petitionFlowDao.searchByCondition(condition);
			if(petitionFlowList!=null && petitionFlowList.size()>0){
				PetitionFlow petitionFlow = (PetitionFlow)petitionFlowList.get(0);
				return petitionFlow;
			}else{
				return null;
			}
		}
	}

	@Override
	public List getAllPetitionFlow(Long petitionId) {
		if(petitionId==null){
			return null;
		}else{
			Map condition = new HashMap();
			condition.put("petitionId", petitionId);
			List petitionFlowList = petitionFlowDao.searchByCondition(condition);
			return petitionFlowList;
		}
	}
}