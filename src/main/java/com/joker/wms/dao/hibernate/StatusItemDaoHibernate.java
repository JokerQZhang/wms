package com.joker.wms.dao.hibernate;

import java.util.List;
import java.util.Map;

import com.joker.wms.model.StatusItem;
import com.joker.wms.webapp.action.Page;
import com.joker.wms.dao.StatusItemDao;
import com.joker.wms.dao.hibernate.GenericDaoHibernate;

import org.hibernate.SQLQuery;
import org.springframework.stereotype.Repository;

@Repository("statusItemDao")
public class StatusItemDaoHibernate extends GenericDaoHibernate<StatusItem, Long> implements StatusItemDao {

    public StatusItemDaoHibernate() {
        super(StatusItem.class);
    }

	@Override
	public List searchByTypeId(String typeId, Class clazz, Page page) {
		String sql = " SELECT  {a.*} "
					+" FROM status_item a                  "
					+" INNER JOIN status_type b            "
					+" ON a.status_type_id=b.status_type_id"
					+" WHERE b.status_type_id=" + typeId;
		SQLQuery query = super.findBySql(sql, clazz, page);
		return query.list();
	}

	@Override
	public String makeSqlForCondition(Map condition) {
		String sql = "select * from status_item a where 1=1";
		if(condition!=null && !condition.isEmpty()){
			if(condition.containsKey("statusTypeId")){
				sql += " and status_type_id=" + condition.get("statusTypeId");
			}
		}
		return sql;
	}
}
