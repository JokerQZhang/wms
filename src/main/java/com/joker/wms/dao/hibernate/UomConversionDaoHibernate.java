package com.joker.wms.dao.hibernate;

import java.util.Map;

import com.joker.wms.model.Uom;
import com.joker.wms.model.UomConversion;
import com.joker.wms.dao.UomConversionDao;
import com.joker.wms.dao.hibernate.GenericDaoHibernate;

import org.hibernate.SQLQuery;
import org.springframework.stereotype.Repository;

@Repository("uomConversionDao")
public class UomConversionDaoHibernate extends GenericDaoHibernate<UomConversion, Long> implements UomConversionDao {

    public UomConversionDaoHibernate() {
        super(UomConversion.class);
    }
    
    @Override
    public String makeSqlForCondition(Map condition){
		String sql = " SELECT {a.*},{b.*},{c.*}   "
					+" FROM uom_conversion a      "
					+" INNER JOIN uom b           "
					+" ON a.uom_id_from = b.uom_id"
					+" INNER JOIN uom c           "
					+" ON a.uom_id_to = c.uom_id  where 1=1 ";
		
		if(condition!=null && !condition.isEmpty()){
			if(condition.containsKey("uomTypeId")){
				sql += " and b.uom_type_id= " + condition.get("uomTypeId");
				sql += " and c.uom_type_id= " + condition.get("uomTypeId");
			}
		}
		return sql;
	}
    @Override
    public SQLQuery setQueryEntitys(SQLQuery sqlQuery){
    	sqlQuery.addEntity("a", UomConversion.class);
    	sqlQuery.addEntity("b", Uom.class);
    	sqlQuery.addEntity("c", Uom.class);
    	
		return sqlQuery;
	}
}
