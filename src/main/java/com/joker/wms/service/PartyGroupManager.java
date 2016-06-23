package com.joker.wms.service;

import com.joker.wms.service.GenericManager;
import com.joker.wms.webapp.action.Page;
import com.joker.wms.model.Party;
import com.joker.wms.model.PartyGroup;
import com.joker.wms.model.PartyRole;
import com.joker.wms.model.VillageInfo;

import java.util.List;
import java.util.Map;

import javax.jws.WebService;

@WebService
public interface PartyGroupManager extends GenericManager<PartyGroup, Long> {
    public Party saveParty(Party party);
    public PartyRole savePartyRole(PartyRole partyRole);
    public List searchRelationToPartyGroup(Map condition, Page page);
    public String getPartyGroupOptions();
    public List<PartyGroup> getGroupCustomer(List<PartyGroup> pgl);
    public List searchCun(Map condition);
    public VillageInfo saveVillageInfo(VillageInfo villageInfo);
    public List getMPersons(String partyId);
    public List getPgByDwId(String dwId);
    public List getXZGroupList();
    /**
     * 根据party_id获取其归属的行政机构party_group
     * @param dwId党委支部的party_id
     * @return partyGroupList
     */
    public List getLocalOfDw(String dwId);
    public List getPartyGroupByPartyId(String partyId);
    /**
     * 已知某人的party，查找其归属的党支部，即party_relationship_type_id=4
     * role_tpe_id_from=2
     * 直属
     * @param partyId
     * @return
     */
    public PartyGroup getZhiBuByPersonId(Long partyId);
    public PartyGroup getZhiBuByCun(Long partyId);
    public List getZhiBuByCondition(Map condition);
}