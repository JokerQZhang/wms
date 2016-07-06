package com.joker.wms.dao.hibernate;

import java.util.Map;

import com.joker.wms.model.MoniteSite;
import com.joker.wms.dao.MoniteSiteDao;
import com.joker.wms.dao.hibernate.GenericDaoHibernate;
import org.springframework.stereotype.Repository;

@Repository("moniteSiteDao")
public class MoniteSiteDaoHibernate extends GenericDaoHibernate<MoniteSite, Long> implements MoniteSiteDao {

    public MoniteSiteDaoHibernate() {
        super(MoniteSite.class);
    }
    
    @Override
    public String makeSqlForCondition(Map condition){
		String sql = "SELECT * FROM monite_site WHERE 1=1";
		if(condition!=null && !condition.isEmpty()){
    		if(condition.containsKey("partyGroupId")){
    			sql += " AND party_id=(select party_id from party_group where pg_id="+ condition.get("partyGroupId") +")";
    		}
    	}
		return sql;
	}
}
