package com.joker.wms.dao.hibernate;

import java.util.List;
import java.util.Map;

import com.joker.wms.model.Enumeration;
import com.joker.wms.model.EnumerationType;
import com.joker.wms.dao.EnumerationDao;
import com.joker.wms.dao.hibernate.GenericDaoHibernate;

import org.springframework.stereotype.Repository;

@Repository("enumerationDao")
public class EnumerationDaoHibernate extends GenericDaoHibernate<Enumeration, Long> implements EnumerationDao {

    public EnumerationDaoHibernate() {
        super(Enumeration.class);
    }
    
    @Override
    public String makeSqlForCondition(Map condition){
		String sql = "select * from enumeration where 1=1 ";
		if(condition!=null && !condition.isEmpty()){
			if(condition.containsKey("enumTypeId")){
				sql += " and enum_type_id=" + condition.get("enumTypeId");
			}
		}
		return sql;
	}

	@Override
	public List getYFTypes(Map condition) {
		String sql =" select {a.*},{b.*}               "
					+" from enumeration_type a         "
					+" inner join enumeration b        "
					+" on a.enum_type_id=b.enum_type_id"
					+" where a.parent_type_id=3        ";
		return super.findBySql(sql).addEntity("a", EnumerationType.class).addEntity("b", Enumeration.class).list();
	}
}
