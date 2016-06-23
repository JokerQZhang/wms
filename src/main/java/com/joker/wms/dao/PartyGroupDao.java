package com.joker.wms.dao;

import java.util.List;
import java.util.Map;

import com.joker.wms.dao.GenericDao;
import com.joker.wms.model.Party;
import com.joker.wms.model.PartyGroup;
import com.joker.wms.model.PartyRole;
import com.joker.wms.webapp.action.Page;

/**
 * An interface that provides a data management interface to the PartyGroup table.
 */
public interface PartyGroupDao extends GenericDao<PartyGroup, Long> {
	public Party saveParty(Party party);
	public PartyRole savePartyRole(PartyRole partyRole);
	public List searchRelationToPartyGroup(Map condition, Page page);
	public List<PartyGroup> getGroupCustomer(String ids);
	public List searchCun(Map condition);
	public List getMPersons(Map condition);
	public List getPgByDwId(Map condition);
	public List getPartyGroupByRole(Map condition);
	/**
	 * 根据关系查找PartyGroup
	 * @param condition
	 * @return
	 */
	public List getPartyGroupOfRS(Map condition);
	public List getPartyGroup(Map condition); 
	/**
	 * 根据关系查找relationship，即party_id_from对应的partygroup
	 * @param condition
	 * @return
	 */
	public List getPartyGroupFromRS(Map condition);
	/**
	 * 根据关系查找relationship，即party_id_to对应的partygroup
	 * @param condition
	 * @return
	 */
	public List getPartyGroupToRS(Map condition);
	public List getZhiBuByCondition(Map condition);
}