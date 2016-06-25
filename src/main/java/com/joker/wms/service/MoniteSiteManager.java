package com.joker.wms.service;

import com.joker.wms.service.GenericManager;
import com.joker.wms.model.MoniteSite;

import java.util.List;
import javax.jws.WebService;

@WebService
public interface MoniteSiteManager extends GenericManager<MoniteSite, Long> {
    
}