package com.joker.wms.dao;

import com.joker.wms.dao.GenericDao;
import com.joker.wms.model.SalePlan;
import com.joker.wms.model.SalePlanDtl;

/**
 * An interface that provides a data management interface to the SalePlanDtl table.
 */
public interface SalePlanDtlDao extends GenericDao<SalePlanDtl, Long> {
	public void saveShipmentByDtl(SalePlan salePlan);
}