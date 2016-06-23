package com.joker.wms.service;

import com.joker.wms.service.GenericManager;
import com.joker.wms.model.CpCharge;

import java.util.List;
import javax.jws.WebService;

@WebService
public interface CpChargeManager extends GenericManager<CpCharge, Long> {
    public List getChargeSumList(Long partyId);
}