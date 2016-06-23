package com.joker.wms.service.impl;

import com.joker.wms.dao.ShipmentDao;
import com.joker.wms.model.SalePlanDtl;
import com.joker.wms.model.Shipment;
import com.joker.wms.service.ShipmentManager;
import com.joker.wms.service.impl.GenericManagerImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.jws.WebService;

@Service("shipmentManager")
@WebService(serviceName = "ShipmentService", endpointInterface = "com.joker.wms.service.ShipmentManager")
public class ShipmentManagerImpl extends GenericManagerImpl<Shipment, Long> implements ShipmentManager {
    ShipmentDao shipmentDao;

    @Autowired
    public ShipmentManagerImpl(ShipmentDao shipmentDao) {
        super(shipmentDao);
        this.shipmentDao = shipmentDao;
    }

	@Override
	public Shipment getShipmentBySPD(SalePlanDtl salePlanDtl) {
		if(salePlanDtl == null){
			return null;
		}
		Long salePlanId = salePlanDtl.getSalePlanId();
		Long facilityIdFrom = salePlanDtl.getFacilityIdFrom();
		Long facilityIdTo = salePlanDtl.getFacilityIdTo();
		Long productId = salePlanDtl.getProductId();
		Map condition = new HashMap();
		condition.put("salePlanId", salePlanId);
		condition.put("facilityIdFrom", facilityIdFrom);
		condition.put("facilityIdTo", facilityIdTo);
		condition.put("productId", productId);
		List sl = shipmentDao.getOShipmentByCondition(condition);
		if(sl!=null && !sl.isEmpty()){
			Shipment shipment = (Shipment)sl.get(0);
			return shipment;
		}
		return null;
	}
}