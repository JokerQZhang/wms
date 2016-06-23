package com.joker.wms.service;

import com.joker.wms.service.GenericManager;
import com.joker.wms.model.AlarmSet;

import java.util.List;
import javax.jws.WebService;

@WebService
public interface AlarmSetManager extends GenericManager<AlarmSet, Long> {
    
}