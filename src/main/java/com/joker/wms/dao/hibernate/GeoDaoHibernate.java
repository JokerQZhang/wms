package com.joker.wms.dao.hibernate;

import java.util.Map;

import com.joker.wms.model.Geo;
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
		String sql = "";
		if(condition!=null && !condition.isEmpty()){
    		
    	}
		return sql;
	}
}
