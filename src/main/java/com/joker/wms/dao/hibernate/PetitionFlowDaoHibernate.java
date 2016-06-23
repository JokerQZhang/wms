package com.joker.wms.dao.hibernate;

import java.util.Map;

import com.joker.wms.model.PetitionFlow;
import com.joker.wms.dao.PetitionFlowDao;
import com.joker.wms.dao.hibernate.GenericDaoHibernate;
import org.springframework.stereotype.Repository;

@Repository("petitionFlowDao")
public class PetitionFlowDaoHibernate extends GenericDaoHibernate<PetitionFlow, Long> implements PetitionFlowDao {

    public PetitionFlowDaoHibernate() {
        super(PetitionFlow.class);
    }
    
    @Override
    public String makeSqlForCondition(Map condition){
		String sql = "SELECT * FROM petition_flow WHERE 1=1";
		if(condition!=null && !condition.isEmpty()){
    		if(condition.containsKey("petitionId")){
    			sql += " AND petition_id=" + condition.get("petitionId");
    		}
    		
    		if(condition.containsKey("lastRecord") && "yes".equals(condition.get("lastRecord"))){
    			sql += " ORDER BY petition_flow_id DESC LIMIT 1 ";
    		}
    	}
		return sql;
	}
}
