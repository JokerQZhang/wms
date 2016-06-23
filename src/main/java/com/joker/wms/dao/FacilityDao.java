package com.joker.wms.dao;

import java.util.List;

import com.joker.wms.dao.GenericDao;
import com.joker.wms.model.Facility;

/**
 * An interface that provides a data management interface to the Facility table.
 */
public interface FacilityDao extends GenericDao<Facility, Long> {
	public List getFacilityByUserId(String userId);
	public List getFacilityByPartyGroupId(String partyId);
}