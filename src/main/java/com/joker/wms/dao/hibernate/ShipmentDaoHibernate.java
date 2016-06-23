package com.joker.wms.dao.hibernate;

import java.util.List;
import java.util.Map;

import com.joker.wms.model.Facility;
import com.joker.wms.model.Product;
import com.joker.wms.model.SalePlanDtl;
import com.joker.wms.model.Shipment;
import com.joker.wms.dao.ShipmentDao;
import com.joker.wms.dao.hibernate.GenericDaoHibernate;

import org.hibernate.SQLQuery;
import org.springframework.stereotype.Repository;

@Repository("shipmentDao")
public class ShipmentDaoHibernate extends GenericDaoHibernate<Shipment, Long> implements ShipmentDao {

    public ShipmentDaoHibernate() {
        super(Shipment.class);
    }
    
    @Override
    public String makeSqlForCondition(Map condition){
    	String sql = " SELECT {a.*},{b.*},{c.*}         "
				+" FROM shipment a             "
				+" INNER JOIN facility b            "
				+" ON a.facility_id_to=b.facility_id"
				+" INNER JOIN product c             "
				+" ON a.product_id=c.product_id     "
				+" WHERE 1=1";
		if(condition!=null && !condition.isEmpty()){
			if(condition.containsKey("salePlanId")){
    			sql += " AND a.sale_plan_id=" + condition.get("salePlanId");
    		}
    	}
		return sql;
	}
    
    @Override
	public SQLQuery setQueryEntitys(SQLQuery sqlQuery) {
		return sqlQuery.addEntity("a", Shipment.class).addEntity("b", Facility.class).addEntity("c", Product.class);
	}

	@Override
	public List getOShipmentByCondition(Map condition) {
		String sql = "SELECT * FROM shipment WHERE 1=1 ";
		if(condition!=null && !condition.isEmpty()){
    		if(condition.containsKey("salePlanId")){
    			sql += " AND sale_plan_id=" + condition.get("salePlanId");
    		}
    		if(condition.containsKey("facilityIdFrom")){
    			sql += " AND facility_id_from=" + condition.get("facilityIdFrom");
    		}
    		if(condition.containsKey("facilityIdTo")){
    			sql += " AND facility_id_to=" + condition.get("facilityIdTo");
    		}
    		if(condition.containsKey("productId")){
    			sql += " AND product_id=" + condition.get("productId");
    		}
    	}
		return super.findBySql(sql).addEntity(Shipment.class).list();
	}
}
