package com.joker.wms.service;

import com.joker.wms.service.GenericManager;
import com.joker.wms.model.Uom;

import java.util.List;
import javax.jws.WebService;

@WebService
public interface UomManager extends GenericManager<Uom, Long> {
    
}