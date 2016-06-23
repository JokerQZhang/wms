package com.joker.wms.dao.hibernate;

import java.util.Map;

import com.joker.wms.model.FacilityTransition;
import com.joker.wms.dao.FacilityTransitionDao;
import com.joker.wms.dao.hibernate.GenericDaoHibernate;
import org.springframework.stereotype.Repository;

@Repository("facilityTransitionDao")
public class FacilityTransitionDaoHibernate extends GenericDaoHibernate<FacilityTransition, Long> implements FacilityTransitionDao {

    public FacilityTransitionDaoHibernate() {
        super(FacilityTransition.class);
    }
    
    @Override
    public String makeSqlForCondition(Map condition){
		String sql = "";
		if(condition!=null && !condition.isEmpty()){
    		
    	}
		return sql;
	}
}
