package com.joker.wms.dao.hibernate;

import java.util.Map;

import com.joker.wms.model.TzHjmd;
import com.joker.wms.dao.TzHjmdDao;
import com.joker.wms.dao.hibernate.GenericDaoHibernate;
import org.springframework.stereotype.Repository;

@Repository("tzHjmdDao")
public class TzHjmdDaoHibernate extends GenericDaoHibernate<TzHjmd, Long> implements TzHjmdDao {

    public TzHjmdDaoHibernate() {
        super(TzHjmd.class);
    }
    
    @Override
    public String makeSqlForCondition(Map condition){
		String sql = "SELECT * FROM tz_hjmd WHERE 1=1";
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
