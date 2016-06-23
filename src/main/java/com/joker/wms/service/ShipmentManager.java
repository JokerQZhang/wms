package com.joker.wms.service;

import com.joker.wms.service.GenericManager;
import com.joker.wms.model.SalePlanDtl;
import com.joker.wms.model.Shipment;

import java.util.List;

import javax.jws.WebService;

@WebService
public interface ShipmentManager extends GenericManager<Shipment, Long> {
    public Shipment getShipmentBySPD(SalePlanDtl salePlanDtl);
}