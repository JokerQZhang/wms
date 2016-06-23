package com.joker.wms.dao;

import java.util.List;

import com.joker.wms.dao.GenericDao;
import com.joker.wms.model.StatusValidChange;
import com.joker.wms.webapp.action.Page;

/**
 * An interface that provides a data management interface to the StatusValidChange table.
 */
public interface StatusValidChangeDao extends GenericDao<StatusValidChange, Long> {
	public List searchByTypeId(String typeId, Class clazz, Page page);
}