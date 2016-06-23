package com.joker.wms.dao.hibernate;

import java.util.List;
import java.util.Map;

import com.joker.wms.model.TbProvide;
import com.joker.wms.util.MyDateUtil;
import com.joker.wms.dao.TbProvideDao;
import com.joker.wms.dao.hibernate.GenericDaoHibernate;

import org.springframework.stereotype.Repository;

@Repository("tbProvideDao")
public class TbProvideDaoHibernate extends GenericDaoHibernate<TbProvide, Long> implements TbProvideDao {

    public TbProvideDaoHibernate() {
        super(TbProvide.class);
    }
    
    @Override
    public String makeSqlForCondition(Map condition){
		String sql = "select * from tb_provide where 1=1";
		if(condition!=null && !condition.isEmpty()){
    		if(condition.containsKey("provideName")){
    			sql += " AND provide_name='" + condition.get("provideName") + "' " ;
    		}
    	}
		return sql;
	}

	@Override
	public boolean saveProvideDtl(TbProvide tbProvide, String yfTypeId) {
		String sql = "INSERT INTO tb_provide_dtl                                                          "
					+" (people_id,enum_id,provide_id,provide_money,valid_flag,created_time,created_by_user)"
					+" SELECT a.people_id                                                                  "
					+"        ,b.enum_id                                                                   "
					+"        ," + tbProvide.getProvideId()
					+"        ,c.enum_code                                                                 "
					+"        ,0                                                                           "
					+"        ,'"+ MyDateUtil.getCurrDate("yyyy-MM-dd hh:mm:ss") +"' "
					+"        ,"+ tbProvide.getCreatedByUser()
					+" FROM tb_care_people a                                                               "
					+" INNER JOIN tb_people_care b                                                         "
					+" ON a.people_id=b.people_id AND b.enum_id=" + yfTypeId
					+" INNER JOIN enumeration c                                                            "
					+" ON b.enum_id=c.enum_id AND c.enum_id=" + yfTypeId
					+" WHERE a.department_id=" + tbProvide.getDepartmentId();
					;
		int result = super.executeSql(sql);
		System.out.println(result);
		return true;
	}

	@Override
	public List getSumFromDtl(Long privideId) {
		String sql = "SELECT SUM(provide_money) FROM tb_provide_dtl WHERE provide_id=" + privideId;
		return super.findBySql(sql).list();
	}

	@Override
	public boolean removeDtl(Long privideId) {
		String sql = "DELETE FROM tb_provide_dtl WHERE provide_id=" + privideId;
		int result = super.executeSql(sql);
		return true;
	}

	@Override
	public boolean sendMoneyDtl(TbProvide tbProvide) {
		String sql = "UPDATE tb_provide_dtl SET valid_flag=1,last_updated_time='" + MyDateUtil.getCurrDate("yyyy-MM-dd hh:mm:ss") + "',last_updated_by_user=" + tbProvide.getLastUpdatedByUser() + " WHERE provide_id=" + tbProvide.getProvideId();
		int result = super.executeSql(sql);
		System.out.println(result);
		return true;
	}
}
