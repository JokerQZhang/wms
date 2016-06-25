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
		String sql = "";
		if(condition!=null && !condition.isEmpty()){
    		
    	}
		return sql;
	}
}
