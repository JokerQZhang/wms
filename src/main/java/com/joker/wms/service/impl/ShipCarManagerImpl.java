package com.joker.wms.service.impl;

import com.joker.wms.dao.ShipCarDao;
import com.joker.wms.model.ShipCar;
import com.joker.wms.service.ShipCarManager;
import com.joker.wms.service.impl.GenericManagerImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import javax.jws.WebService;

@Service("shipCarManager")
@WebService(serviceName = "ShipCarService", endpointInterface = "com.joker.wms.service.ShipCarManager")
public class ShipCarManagerImpl extends GenericManagerImpl<ShipCar, Long> implements ShipCarManager {
    ShipCarDao shipCarDao;

    @Autowired
    public ShipCarManagerImpl(ShipCarDao shipCarDao) {
        super(shipCarDao);
        this.shipCarDao = shipCarDao;
    }
}