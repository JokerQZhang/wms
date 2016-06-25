package com.joker.wms.dao.hibernate;

import java.util.Map;

import com.joker.wms.model.MonitorData;
import com.joker.wms.dao.MonitorDataDao;
import com.joker.wms.dao.hibernate.GenericDaoHibernate;
import org.springframework.stereotype.Repository;

@Repository("monitorDataDao")
public class MonitorDataDaoHibernate extends GenericDaoHibernate<MonitorData, Long> implements MonitorDataDao {

    public MonitorDataDaoHibernate() {
        super(MonitorData.class);
    }
    
    @Override
    public String makeSqlForCondition(Map condition){
		String sql = "";
		if(condition!=null && !condition.isEmpty()){
    		
    	}
		return sql;
	}
}
