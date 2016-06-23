package com.joker.wms.service;

import com.joker.wms.service.GenericManager;
import com.joker.wms.webapp.action.Page;
import com.joker.wms.model.StatusItem;

import java.util.List;

import javax.jws.WebService;

@WebService
public interface StatusItemManager extends GenericManager<StatusItem, Long> {
    List searchByTypeId(String typeId, Class clazz, Page page);
}