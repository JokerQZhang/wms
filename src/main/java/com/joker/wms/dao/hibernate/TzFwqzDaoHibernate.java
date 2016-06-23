package com.joker.wms.dao.hibernate;

import java.util.Map;

import com.joker.wms.model.TzFwqz;
import com.joker.wms.dao.TzFwqzDao;
import com.joker.wms.dao.hibernate.GenericDaoHibernate;
import org.springframework.stereotype.Repository;

@Repository("tzFwqzDao")
public class TzFwqzDaoHibernate extends GenericDaoHibernate<TzFwqz, Long> implements TzFwqzDao {

    public TzFwqzDaoHibernate() {
        super(TzFwqz.class);
    }
    
    @Override
    public String makeSqlForCondition(Map condition){
		String sql = "SELECT * FROM tz_fwqz WHERE 1=1";
		if(condition!=null && !condition.isEmpty()){
			if(condition.containsKey("tzDate")){
    			sql += " AND tz_date='" + condition.get("tzDate") + "'";
    		}
			if(condition.containsKey("groupPartyId")){
    			sql += " AND group_party_id=" + condition.get("groupPartyId");
    		}
    	}
		return sql;
	}
}
