package com.joker.wms.service.impl;

import com.joker.wms.dao.PartyGroupDao;
import com.joker.wms.model.Party;
import com.joker.wms.model.PartyGroup;
import com.joker.wms.model.PartyRole;
import com.joker.wms.model.VillageInfo;
import com.joker.wms.service.PartyGroupManager;
import com.joker.wms.service.impl.GenericManagerImpl;
import com.joker.wms.webapp.action.Page;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.jws.WebService;

@Service("partyGroupManager")
@WebService(serviceName = "PartyGroupService", endpointInterface = "com.joker.wms.service.PartyGroupManager")
public class PartyGroupManagerImpl extends GenericManagerImpl<PartyGroup, Long> implements PartyGroupManager {
    PartyGroupDao partyGroupDao;

    @Autowired
    public PartyGroupManagerImpl(PartyGroupDao partyGroupDao) {
        super(partyGroupDao);
        this.partyGroupDao = partyGroupDao;
    }

	@Override
	public Party saveParty(Party party) {
		return partyGroupDao.saveParty(party);
	}

	@Override
	public PartyRole savePartyRole(PartyRole partyRole) {
		return partyGroupDao.savePartyRole(partyRole);
	}

	@Override
	public List searchRelationToPartyGroup(Map condition, Page page) {
		return partyGroupDao.searchRelationToPartyGroup(condition, page);
	}

	@Override
	public String getPartyGroupOptions() {
		List partyGroupList = partyGroupDao.getAll();
		String result = "";
		if(partyGroupList!=null && partyGroupList.size()>0){
			for(int i=0; i<partyGroupList.size(); i++){
				PartyGroup partyGroup = (PartyGroup)partyGroupList.get(i);
				result += "<option value='" + partyGroup.getPartyId() + "'>" + partyGroup.getGroupName() + "["+ (partyGroup.getPinyinName()==null?"":partyGroup.getPinyinName()) +"]</option>";
			}
		}
		return result;
	}

	@Override
	public List<PartyGroup> getGroupCustomer(List<PartyGroup> pgl) {
		String pglids = "";
		if(pgl==null || pgl.size()==0){
			return null;
		}else{
			for(int i=0; i<pgl.size(); i++){
				PartyGroup partyGroup = pgl.get(i);
				if(i==0){
					pglids += partyGroup.getPartyId().toString();
				}else{
					pglids += "," + partyGroup.getPartyId().toString();
				}
			}
		}
		return partyGroupDao.getGroupCustomer(pglids);
	}

	@Override
	public List searchCun(Map condition) {
		return partyGroupDao.searchCun(condition);
	}

	@Override
	public VillageInfo saveVillageInfo(VillageInfo villageInfo) {
		return (VillageInfo)partyGroupDao.saveObject(villageInfo);
	}

	@Override
	public List getMPersons(String partyId) {
		Map condition = new HashMap();
		condition.put("partyId", partyId);
		condition.put("roleTypeIds", "3,4,5");
		condition.put("partyRelationShipTypeId","1");
		return partyGroupDao.getMPersons(condition);
	}
	/**
	 * 已知党委的ID
	 * 查找党委归属行政机构的下属机构
	 */
	@Override
	public List getPgByDwId(String dwId) {
		Map condition = new HashMap();
		condition.put("dwId", dwId);
		return partyGroupDao.getPgByDwId(condition);
	}

	@Override
	public List getXZGroupList() {
		Map condition = new HashMap();
		condition.put("roleTypeId", 1);
		return partyGroupDao.getPartyGroupByRole(condition);
	}

	@Override
	public List getLocalOfDw(String dwId) {
		Map condition = new HashMap();
		condition.put("dwId", dwId);
		condition.put("partyRelationShipTypeId", 3);
		return partyGroupDao.getPartyGroupOfRS(condition);
	}
	/**
	 * 根据partyId获取partyGroup
	 */
	@Override
	public List getPartyGroupByPartyId(String partyId) {
		Map condition = new HashMap();
		condition.put("partyId", partyId);
		return partyGroupDao.getPartyGroup(condition);
	}

	@Override
	public PartyGroup getZhiBuByPersonId(Long partyId) {
		if(partyId!=null){
			Map condition = new HashMap();
			//从属党委支部上下级关系,这里有两种关系，一种是党委下的操作员1，一种是党委下的党员4
			condition.put("partyRelationshipTypeIds", "1,4");
			condition.put("roleTypeId", 2);
			//待查询的partyId
			condition.put("partyId", partyId);
			List pgList = partyGroupDao.getPartyGroupFromRS(condition);
			if(pgList!=null && pgList.size()>0){
				PartyGroup result = (PartyGroup)pgList.get(0);
				return result;
			}else{
				return null;
			}
		}else{
			return null;
		}
	}
	/**
	 * 根据村或者乡等行政机构获取其拥有的党委支部partygroup
	 */
	@Override
	public PartyGroup getZhiBuByCun(Long partyId) {
		if(partyId!=null){
			Map condition = new HashMap();
			condition.put("partyRelationshipTypeId", 3);
			//待查询的partyId，是查询条件中的party_id_from
			condition.put("partyId", partyId);
			List pgList = partyGroupDao.getPartyGroupToRS(condition);
			if(pgList!=null && pgList.size()>0){
				PartyGroup result = (PartyGroup)pgList.get(0);
				return result;
			}
		}
		return null;
	}

	@Override
	public List getZhiBuByCondition(Map condition) {
		return partyGroupDao.getZhiBuByCondition(condition);
	}
}