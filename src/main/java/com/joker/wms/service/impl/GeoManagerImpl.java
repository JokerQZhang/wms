package com.joker.wms.service.impl;

import com.joker.wms.dao.GeoDao;
import com.joker.wms.model.Geo;
import com.joker.wms.service.GeoManager;
import com.joker.wms.service.impl.GenericManagerImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

import javax.jws.WebService;

@Service("geoManager")
@WebService(serviceName = "GeoService", endpointInterface = "com.joker.wms.service.GeoManager")
public class GeoManagerImpl extends GenericManagerImpl<Geo, Long> implements GeoManager {
    GeoDao geoDao;

    @Autowired
    public GeoManagerImpl(GeoDao geoDao) {
        super(geoDao);
        this.geoDao = geoDao;
    }

	@Override
	public List getPartyGroupByGeoId(String geoParentId) {
		return geoDao.getPartyGroupByGeoId(geoParentId);
	}

	@Override
	public List getMoniteSiteByParytId(String companyId) {
		return geoDao.getMoniteSiteByParytId(companyId);
	}

	@Override
	public List getAreaPoints(String areaId) {
		List geoIdList = geoDao.getAllChildrenGeoIds(areaId);
		String geoIds = "(" + areaId;
		if(geoIdList!=null && geoIdList.size()>0){
			for(int i=0;i<geoIdList.size();i++){
				Object id = geoIdList.get(i);
				BigInteger geoid = (BigInteger)id;
				geoIds += "," + geoid;
			}
		}
		geoIds += ")";
		return geoDao.getSitesByAreaIds(geoIds);
	}

	@Override
	public List getCompanyPoints(String areaId) {
		return geoDao.getCompanyPoints(areaId);
	}

	@Override
	public List getSitePoints(String areaId) {
		return geoDao.getSitePoints(areaId);
	}
}