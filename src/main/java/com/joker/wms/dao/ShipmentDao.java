package com.joker.wms.dao;

import java.util.List;
import java.util.Map;

import com.joker.wms.dao.GenericDao;
import com.joker.wms.model.Shipment;

/**
 * An interface that provides a data management interface to the Shipment table.
 */
public interface ShipmentDao extends GenericDao<Shipment, Long> {
	public List getOShipmentByCondition(Map condition);
}