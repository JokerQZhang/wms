package com.joker.wms.dao;

import java.util.List;

import com.joker.wms.dao.GenericDao;
import com.joker.wms.model.Geo;

/**
 * An interface that provides a data management interface to the Geo table.
 */
public interface GeoDao extends GenericDao<Geo, Long> {

	List getPartyGroupByGeoId(String geoParentId);

	List getMoniteSiteByParytId(String companyId);

	List getAllChildrenGeoIds(String areaId);

	List getSitesByAreaIds(String geoIds);

	List getCompanyPoints(String areaId);

	List getSitePoints(String areaId);

}