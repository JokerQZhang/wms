package com.joker.wms.dao;

import java.util.List;

import com.joker.wms.dao.GenericDao;
import com.joker.wms.model.SalePlan;

/**
 * An interface that provides a data management interface to the SalePlan table.
 */
public interface SalePlanDao extends GenericDao<SalePlan, Long> {
	public List facilityInventory(String facilityId, String productId);
	public List getCustomerFacilityList(String facilityId);
	public void transactionFacility(SalePlan salePlan);
	public void updateShipDate(SalePlan salePlan);
}