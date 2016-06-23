package com.joker.wms.service.impl;

import com.joker.wms.dao.FacilityDao;
import com.joker.wms.dao.UserDao;
import com.joker.wms.model.Facility;
import com.joker.wms.model.PartyGroup;
import com.joker.wms.service.FacilityManager;
import com.joker.wms.service.impl.GenericManagerImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;

@Service("facilityManager")
@WebService(serviceName = "FacilityService", endpointInterface = "com.joker.wms.service.FacilityManager")
public class FacilityManagerImpl extends GenericManagerImpl<Facility, Long> implements FacilityManager {
    FacilityDao facilityDao;
    UserDao userDao;
    
    @Autowired
    public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
    
	@Autowired
    public FacilityManagerImpl(FacilityDao facilityDao) {
        super(facilityDao);
        this.facilityDao = facilityDao;
    }
    /**
     * 获取用户的直接关联facility以及子部门的facility
     */
	@Override
	public List getFacilityByUserId(String userId) {
		List dirfacilityList = facilityDao.getFacilityByUserId(userId);
		if(dirfacilityList!=null && dirfacilityList.size()>0){
			Facility facility = (Facility)dirfacilityList.get(0);
			List chifacilityList = facilityDao.getFacilityByPartyGroupId(facility.getOwnerPartyId().toString());
			if(chifacilityList!=null && chifacilityList.size()>0){
				chifacilityList.add(0, facility);
			}else{
				chifacilityList = dirfacilityList;
			}
			return chifacilityList;
		}else{
			List<PartyGroup> lgl = userDao.getPartyGroupByUser(userId);
			if(lgl!=null && lgl.size()>0){
				List result = new ArrayList();
				for(int i=0; i<lgl.size(); i++){
					PartyGroup partyGroup = lgl.get(i);
					List chifacilityList = facilityDao.getFacilityByPartyGroupId(partyGroup.getPartyId().toString());
					if(chifacilityList!=null && chifacilityList.size()>0){
						result.addAll(chifacilityList);
					}
				}
				return result;
			}
		}
		return null;
	}
}