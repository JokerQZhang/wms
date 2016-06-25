package com.joker.wms.service;

import com.joker.wms.service.GenericManager;
import com.joker.wms.model.MonitorData;

import java.util.List;
import javax.jws.WebService;

@WebService
public interface MonitorDataManager extends GenericManager<MonitorData, Long> {
    
}