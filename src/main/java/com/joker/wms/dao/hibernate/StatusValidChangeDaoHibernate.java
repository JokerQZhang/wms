package com.joker.wms.dao.hibernate;

import java.util.List;

import com.joker.wms.model.StatusItem;
import com.joker.wms.model.StatusValidChange;
import com.joker.wms.webapp.action.Page;
import com.joker.wms.dao.StatusValidChangeDao;
import com.joker.wms.dao.hibernate.GenericDaoHibernate;

import org.hibernate.SQLQuery;
import org.springframework.stereotype.Repository;

@Repository("statusValidChangeDao")
public class StatusValidChangeDaoHibernate extends GenericDaoHibernate<StatusValidChange, Long> implements StatusValidChangeDao {

    public StatusValidChangeDaoHibernate() {
        super(StatusValidChange.class);
    }

	@Override
	public List searchByTypeId(String typeId, Class clazz, Page page) {
		String sql = " SELECT {a.*},{b.*},{c.*}                                       "
					+" FROM status_valid_change a                     "
					+" INNER JOIN status_item b                       "
					+" ON a.status_id_from=b.status_id                "
					+" INNER JOIN status_item c                       "
					+" ON a.status_id_to=c.status_id                 "
					+" WHERE b.status_type_id=" + typeId + " AND c.status_type_id=" + typeId;
		SQLQuery query = super.findBySql(sql, page);
		query.addEntity("a", StatusValidChange.class);
		query.addEntity("b", StatusItem.class);
		query.addEntity("c", StatusItem.class);
		return query.list();
	}
}
