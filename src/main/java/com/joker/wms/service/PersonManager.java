package com.joker.wms.service;

import com.joker.wms.service.GenericManager;
import com.joker.wms.webapp.action.Page;
import com.joker.wms.model.CpDtl;
import com.joker.wms.model.CpPositive;
import com.joker.wms.model.Person;

import java.util.List;

import javax.jws.WebService;

@WebService
public interface PersonManager extends GenericManager<Person, Long> {
    public List searchByGroupId(Class claaz, Page page, String belongGroupId);
    public List getDangPerson(String belongGroupId, String isNowDangwei);
    public List getPositivePerson(String belongGroupId, String isNowDangwei);
    public CpDtl getCpDtlByPartyId(Long partyId);
    public CpPositive getCpPositiveByPartyId(Long partyId);
    public boolean approvalDangPerson(String partyId, String totalNum, String approvalNum, String approvalResult, String resultStatus);
    public List getPersonRoles(Long partyId);
}