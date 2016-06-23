package com.joker.wms.dao.hibernate;

import java.util.Map;

import com.joker.wms.model.TzZtjj;
import com.joker.wms.dao.TzZtjjDao;
import com.joker.wms.dao.hibernate.GenericDaoHibernate;
import org.springframework.stereotype.Repository;

@Repository("tzZtjjDao")
public class TzZtjjDaoHibernate extends GenericDaoHibernate<TzZtjj, Long> implements TzZtjjDao {

    public TzZtjjDaoHibernate() {
        super(TzZtjj.class);
    }
    
    @Override
    public String makeSqlForCondition(Map condition){
		String sql = "SELECT * FROM tz_ztjj WHERE 1=1";
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
