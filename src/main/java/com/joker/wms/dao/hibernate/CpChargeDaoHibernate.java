package com.joker.wms.dao.hibernate;

import java.util.List;
import java.util.Map;

import com.joker.wms.model.CpCharge;
import com.joker.wms.dao.CpChargeDao;
import com.joker.wms.dao.hibernate.GenericDaoHibernate;

import org.springframework.stereotype.Repository;

@Repository("cpChargeDao")
public class CpChargeDaoHibernate extends GenericDaoHibernate<CpCharge, Long> implements CpChargeDao {

    public CpChargeDaoHibernate() {
        super(CpCharge.class);
    }
    
    @Override
    public String makeSqlForCondition(Map condition){
		String sql = "";
		if(condition!=null && !condition.isEmpty()){
    		
    	}
		return sql;
	}
    
    /**
     * 查询党委或者县委的各个账户类型的收入、支出、余额
     * 条件是：partyId startDate endDate
     */
	@Override
	public List getChargeSumList(Map condition) {
		String sql = " SELECT a.group_name                                                     "
					+"        ,b.account_type                                                  "
					+"        ,c.description                                                   "
					+"        ,SUM(CASE WHEN b.io_type=1 THEN b.balance ELSE 0 END) AS income  "
					+"        ,SUM(CASE WHEN b.io_type=-1 THEN b.balance ELSE 0 END) AS expense"
					+"        ,SUM(b.io_type*b.balance) AS balance                             "
					+" FROM party_group a                                                      "
					+" INNER JOIN cp_charge b                                                  "
					+" ON a.party_id=b.party_id                                                "
					+" INNER JOIN enumeration c                                                "
					+" ON b.account_type=c.enum_id                                             "
					+" WHERE 1=1                                                               ";
		if(condition!=null && !condition.isEmpty()){
			if(condition.containsKey("partyId")){
				sql += " AND a.party_id=" + condition.get("partyId");
			}
		}
		sql		   +=" GROUP BY a.group_name                                                   "
					+"        ,b.account_type                                                  "
					+"        ,c.description                                                   ";
		return super.findBySql(sql).list();
	}
}
