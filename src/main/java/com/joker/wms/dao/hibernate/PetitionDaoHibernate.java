package com.joker.wms.dao.hibernate;

import java.util.Map;

import com.joker.wms.model.PartyGroup;
import com.joker.wms.model.Petition;
import com.joker.wms.dao.PetitionDao;
import com.joker.wms.dao.hibernate.GenericDaoHibernate;

import org.hibernate.SQLQuery;
import org.springframework.stereotype.Repository;

@Repository("petitionDao")
public class PetitionDaoHibernate extends GenericDaoHibernate<Petition, Long> implements PetitionDao {

    public PetitionDaoHibernate() {
        super(Petition.class);
    }
    
    @Override
    public String makeSqlForCondition(Map condition){
		String sql = " SELECT {a.*},{b.*}                                        "
					+" FROM petition a                                           "
					+" LEFT JOIN party_group b                                   "
					+" ON a.process_party_id=b.party_id                          "
					+" WHERE 1=1                                                 ";
		if(condition!=null && !condition.isEmpty()){
    		if(condition.containsKey("nowZhibuId")){
    			sql += " AND EXISTS(SELECT 1 FROM petition_flow WHERE petition_id=a.petition_id AND party_id=" + condition.get("nowZhibuId") + " ORDER BY petition_flow_id DESC LIMIT 1)";
    		}
    		if(condition.containsKey("type")){
    			if("a".equals(condition.get("type")) || "b".equals(condition.get("type"))){
    				sql += " AND a.status_id=3                                         ";
    			}
    			if("c".equals(condition.get("type")) || "d".equals(condition.get("type"))){
    				sql += " AND a.status_id in(4,5)";
    			}
    		}
    	}
		return sql;
	}

	@Override
	public SQLQuery setQueryEntitys(SQLQuery sqlQuery) {
		return sqlQuery.addEntity("a", Petition.class).addEntity("b", PartyGroup.class);
	}
    
}
