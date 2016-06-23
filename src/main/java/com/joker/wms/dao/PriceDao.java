package com.joker.wms.dao;

import java.util.List;

import com.joker.wms.dao.GenericDao;
import com.joker.wms.model.Price;

/**
 * An interface that provides a data management interface to the Price table.
 */
public interface PriceDao extends GenericDao<Price, Long> {
	public List getProductPriceList(String groupId, String lastdate, String priceType);
}