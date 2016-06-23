package com.joker.wms.dao.hibernate;

import java.util.List;
import java.util.Map;

import com.joker.wms.model.Facility;
import com.joker.wms.model.SalePlan;
import com.joker.wms.util.MyDateUtil;
import com.joker.wms.dao.SalePlanDao;
import com.joker.wms.dao.hibernate.GenericDaoHibernate;

import org.springframework.stereotype.Repository;

@Repository("salePlanDao")
public class SalePlanDaoHibernate extends GenericDaoHibernate<SalePlan, Long> implements SalePlanDao {

    public SalePlanDaoHibernate() {
        super(SalePlan.class);
    }
    
    @Override
    public String makeSqlForCondition(Map condition){
		String sql = "select * FROM sale_plan WHERE 1=1 ";
		if(condition!=null && !condition.isEmpty()){
    		if(condition.containsKey("facilityIds")){
    			sql += " AND facility_id IN (" + condition.get("facilityIds") + ")";
    		}
    	}
		return sql;
	}
    /**
     * 获取某产品在某仓库中的库存
     * in_out_type=1入库 in_out_type=-1出库
     */
	@Override
	public List facilityInventory(String facilityId, String productId) {
		String sql = " SELECT a.product_id                                                     "
					+"        ,SUM(b.num*in_out_type) AS num"
					+" FROM product a                                                          "
					+" LEFT JOIN facility_transition b                                         "
					+" ON a.product_id=b.product_id                                            ";
		if(facilityId!=null && !"".equals(facilityId)){
			sql += " AND b.facility_id=" + facilityId;
		}
		if(productId!=null && !"".equals(productId)){
			sql += " WHERE a.product_id=" + productId;
		}
		sql += " GROUP BY product_id";
		return super.findBySql(sql).list();
	}

	@Override
	public List getCustomerFacilityList(String facilityId) {
		String sql = " SELECT c.*                                                            "
					+" FROM facility a                                                       "
					+" INNER JOIN party_relationship b                                       "
					+" ON a.owner_party_id=b.party_id_from AND b.party_relationship_type_id=2"
					+" INNER JOIN facility c                                                 "
					+" ON b.party_id_to=c.owner_party_id                                     "
					+" WHERE a.facility_id=" + facilityId;
		return super.findBySql(sql).addEntity(Facility.class).list();
	}
	/**
	 * facility_transition
	 * biz_type=1发货出库类型
	 * in_out_type=1入库  in_out_type=-1出库
	 */
	@Override
	public void transactionFacility(SalePlan salePlan) {
		String sql = " INSERT INTO facility_transition"
					+" (facility_id                   "
					+" ,in_out_type                   "
					+" ,product_id                    "
					+" ,num                           "
					+" ,uom_id                        "
					+" ,tran_date                     "
					+" ,biz_type                      "
					+" ,biz_id                        "
					+" ,created_time                   "
					+" ,created_by_user)               "
					+" SELECT facility_id_from        "
					+"        ,-1                     "
					+"        ,product_id             "
					+"        ,num                    "
					+"        ,uom_id                 "
					+"        ,ship_date              "
					+"        ,1                      "
					+"        ,shipment_id            "
					+"        ,created_time           "
					+"        ,created_by_user        "
					+" FROM shipment                  "
					+" WHERE sale_plan_id=" + salePlan.getSalePlanId();
		super.executeSql(sql);
	}

	@Override
	public void updateShipDate(SalePlan salePlan) {
		String sql = "UPDATE shipment SET ship_date='" + MyDateUtil.getCurrDate("yyyy-MM-dd hh:mm:ss") + "' WHERE sale_plan_id=" + salePlan.getSalePlanId();
		super.executeSql(sql);
	}
}
