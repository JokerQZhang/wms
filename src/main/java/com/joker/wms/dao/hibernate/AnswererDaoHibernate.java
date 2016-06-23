package com.joker.wms.dao.hibernate;

import java.util.Map;

import com.joker.wms.model.Answerer;
import com.joker.wms.dao.AnswererDao;
import com.joker.wms.dao.hibernate.GenericDaoHibernate;
import org.springframework.stereotype.Repository;

@Repository("answererDao")
public class AnswererDaoHibernate extends GenericDaoHibernate<Answerer, Long> implements AnswererDao {

    public AnswererDaoHibernate() {
        super(Answerer.class);
    }
    
    @Override
    public String makeSqlForCondition(Map condition){
		String sql = "";
		if(condition!=null && !condition.isEmpty()){
    		
    	}
		return sql;
	}
}
