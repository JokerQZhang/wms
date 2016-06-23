package com.joker.wms.service;

import com.joker.wms.service.GenericManager;
import com.joker.wms.model.ShipCar;

import java.util.List;
import javax.jws.WebService;

@WebService
public interface ShipCarManager extends GenericManager<ShipCar, Long> {
    
}