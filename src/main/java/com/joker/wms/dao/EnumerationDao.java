package com.joker.wms.dao;

import java.util.List;
import java.util.Map;

import com.joker.wms.dao.GenericDao;
import com.joker.wms.model.Enumeration;

/**
 * An interface that provides a data management interface to the Enumeration table.
 */
public interface EnumerationDao extends GenericDao<Enumeration, Long> {
	public List getYFTypes(Map condition);
}