package com.joker.wms.dao;

import java.util.List;

import com.joker.wms.dao.GenericDao;
import com.joker.wms.model.StatusItem;
import com.joker.wms.webapp.action.Page;

/**
 * An interface that provides a data management interface to the StatusItem table.
 */
public interface StatusItemDao extends GenericDao<StatusItem, Long> {
	List searchByTypeId(String typeId, Class clazz, Page page);
}