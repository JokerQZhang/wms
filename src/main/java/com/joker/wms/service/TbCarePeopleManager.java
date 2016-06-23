package com.joker.wms.service;

import com.joker.wms.service.GenericManager;
import com.joker.wms.model.TbCarePeople;

import java.util.List;
import javax.jws.WebService;

@WebService
public interface TbCarePeopleManager extends GenericManager<TbCarePeople, Long> {
    public List getYFTypeByPeopleId(String peopleId);
}