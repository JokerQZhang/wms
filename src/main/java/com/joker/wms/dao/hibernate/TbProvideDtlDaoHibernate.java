package com.joker.wms.dao.hibernate;

import java.util.Map;

import com.joker.wms.model.TbCarePeople;
import com.joker.wms.model.TbProvideDtl;
import com.joker.wms.dao.TbProvideDtlDao;
import com.joker.wms.dao.hibernate.GenericDaoHibernate;

import org.hibernate.SQLQuery;
import org.springframework.stereotype.Repository;

@Repository("tbProvideDtlDao")
public class TbProvideDtlDaoHibernate extends GenericDaoHibernate<TbProvideDtl, Long> implements TbProvideDtlDao {

    @Override
	public SQLQuery setQueryEntitys(SQLQuery sqlQuery) {
    	sqlQuery.addEntity("a", TbProvideDtl.class).addEntity("b", TbCarePeople.class);
		return sqlQuery;
	}

	public TbProvideDtlDaoHibernate() {
        super(TbProvideDtl.class);
    }
    
    @Override
    public String makeSqlForCondition(Map condition){
		String sql = " SELECT {a.*},{b.*}         "
					+" FROM tb_provide_dtl a      "
					+" INNER JOIN tb_care_people b"
					+" ON a.people_id=b.people_id "
					+" WHERE 1=1 ";
		if(condition!=null && !condition.isEmpty()){
    		if(condition.containsKey("provideId")){
    			sql += " AND provide_id=" + condition.get("provideId");
    		}
    	}
		return sql;
	}
}
