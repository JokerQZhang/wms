package com.joker.wms.dao.hibernate;

import java.util.Map;

import com.joker.wms.model.AlarmSet;
import com.joker.wms.dao.AlarmSetDao;
import com.joker.wms.dao.hibernate.GenericDaoHibernate;
import org.springframework.stereotype.Repository;

@Repository("alarmSetDao")
public class AlarmSetDaoHibernate extends GenericDaoHibernate<AlarmSet, Long> implements AlarmSetDao {

    public AlarmSetDaoHibernate() {
        super(AlarmSet.class);
    }
    
    @Override
    public String makeSqlForCondition(Map condition){
		String sql = "";
		if(condition!=null && !condition.isEmpty()){
    		
    	}
		return sql;
	}
}
