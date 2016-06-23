package com.joker.wms.dao;

import java.util.List;
import java.util.Map;

import com.joker.wms.dao.GenericDao;
import com.joker.wms.model.TbCarePeople;

/**
 * An interface that provides a data management interface to the TbCarePeople table.
 */
public interface TbCarePeopleDao extends GenericDao<TbCarePeople, Long> {
	public List getYFType(Map condition);
}