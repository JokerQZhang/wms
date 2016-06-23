package com.joker.wms.dao.hibernate;

import java.util.Map;

import com.joker.wms.model.TzDyzth;
import com.joker.wms.dao.TzDyzthDao;
import com.joker.wms.dao.hibernate.GenericDaoHibernate;
import org.springframework.stereotype.Repository;

@Repository("tzDyzthDao")
public class TzDyzthDaoHibernate extends GenericDaoHibernate<TzDyzth, Long> implements TzDyzthDao {

    public TzDyzthDaoHibernate() {
        super(TzDyzth.class);
    }
    
    @Override
    public String makeSqlForCondition(Map condition){
		String sql = "SELECT * FROM tz_dyzth WHERE 1=1";
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
