package com.joker.wms.dao.hibernate;

import java.util.List;
import java.util.Map;

import com.joker.wms.model.Geo;
import com.joker.wms.model.MoniteSite;
import com.joker.wms.model.PartyGroup;
import com.joker.wms.dao.GeoDao;
import com.joker.wms.dao.hibernate.GenericDaoHibernate;

import org.springframework.stereotype.Repository;

@Repository("geoDao")
public class GeoDaoHibernate extends GenericDaoHibernate<Geo, Long> implements GeoDao {

    public GeoDaoHibernate() {
        super(Geo.class);
    }
    
    @Override
    public String makeSqlForCondition(Map condition){
		String sql = "select * from geo where 1=1";
		if(condition!=null && !condition.isEmpty()){
    		if(condition.containsKey("geoParentId")){
    			sql += " and parent_geo_id=" + condition.get("geoParentId");
    		}
    	}
		return sql;
	}

	@Override
	public List getPartyGroupByGeoId(String geoParentId) {
		String sql = "select * from party_group where 1=1";
		if(geoParentId!=null && !"".equals(geoParentId)){
			sql += " and geoid=" + geoParentId;
		}
		return super.findBySql(sql).addEntity(PartyGroup.class).list();
	}

	@Override
	public List getMoniteSiteByParytId(String companyId) {
		String sql = "select * from monite_site where 1=1";
		if(companyId!=null && !"".equals(companyId)){
			sql += " and party_id=" + companyId;
		}
		return super.findBySql(sql).addEntity(MoniteSite.class).list();
	}
	//不包含本身往下司四级,比方说本身是选的国家，那么查询的结果是，国家下面，省，市，县，乡等geoid
	@Override
	public List getAllChildrenGeoIds(String areaId) {
		String sql = " SELECT geo_id FROM geo WHERE parent_geo_id=" + areaId
					+" UNION                                  "
					+" SELECT b.geo_id                             "
					+" FROM geo a                             "
					+" INNER JOIN geo b                       "
					+" ON a.geo_id=b.parent_geo_id            "
					+" WHERE a.parent_geo_id=" + areaId
					+" UNION                                  "
					+" SELECT c.geo_id                             "
					+" FROM geo a                             "
					+" INNER JOIN geo b                       "
					+" ON a.geo_id=b.parent_geo_id            "
					+" INNER JOIN geo c                       "
					+" ON b.geo_id=c.parent_geo_id            "
					+" WHERE a.parent_geo_id=" + areaId
					+" UNION                                  "
					+" SELECT d.geo_id                             "
					+" FROM geo a                             "
					+" INNER JOIN geo b                       "
					+" ON a.geo_id=b.parent_geo_id            "
					+" INNER JOIN geo c                       "
					+" ON b.geo_id=c.parent_geo_id            "
					+" INNER JOIN geo d                       "
					+" ON c.geo_id=d.parent_geo_id            "
					+" WHERE a.parent_geo_id=" + areaId;
		return super.findBySql(sql).list();
	}

	@Override
	public List getSitesByAreaIds(String geoIds) {
		String sql = " SELECT b.*              "
					+" FROM party_group a      "
					+" INNER JOIN monite_site b"
					+" ON a.party_id=b.party_id"
					+" WHERE 1=1 AND a.geoid IN" + geoIds;
		return super.findBySql(sql).addEntity(MoniteSite.class).list();
	}

	@Override
	public List getCompanyPoints(String areaId) {
		String sql = " SELECT * FROM monite_site WHERE party_id=" + areaId;
		return super.findBySql(sql).addEntity(MoniteSite.class).list();
	}

	@Override
	public List getSitePoints(String areaId) {
		String sql = " SELECT * FROM monite_site WHERE site_id=" + areaId;
		return super.findBySql(sql).addEntity(MoniteSite.class).list();
	}
}
