package com.joker.wms.service;

import com.joker.wms.service.GenericManager;
import com.joker.wms.webapp.action.Page;
import com.joker.wms.model.StatusValidChange;

import java.util.List;

import javax.jws.WebService;

@WebService
public interface StatusValidChangeManager extends GenericManager<StatusValidChange, Long> {
    public List searchByTypeId(String typeId, Class clazz, Page page);
}