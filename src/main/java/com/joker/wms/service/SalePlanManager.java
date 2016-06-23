package com.joker.wms.service;

import com.joker.wms.service.GenericManager;
import com.joker.wms.model.SalePlan;

import java.util.List;

import javax.jws.WebService;

@WebService
public interface SalePlanManager extends GenericManager<SalePlan, Long> {
    public void saveNewDtl(SalePlan salePlan);
    public void saveNewShipMent(SalePlan salePlan);
    public List facilityInventory(String facilityId, String productId);
    public void updateShipDate(SalePlan salePlan);
    public void transactionFacility(SalePlan salePlan);
}