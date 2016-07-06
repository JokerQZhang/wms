package com.joker.wms.service;

import com.joker.wms.service.GenericManager;
import com.joker.wms.model.Geo;

import java.util.List;

import javax.jws.WebService;

@WebService
public interface GeoManager extends GenericManager<Geo, Long> {

	List getPartyGroupByGeoId(String geoParentId);
	//根据企业获取企业下面的监测站点
	List getMoniteSiteByParytId(String companyId);
	List getAreaPoints(String areaId);
	List getCompanyPoints(String areaId);
	List getSitePoints(String areaId);
    
}