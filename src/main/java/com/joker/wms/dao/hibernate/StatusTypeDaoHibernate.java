package com.joker.wms.dao.hibernate;

import com.joker.wms.model.StatusType;
import com.joker.wms.dao.StatusTypeDao;
import com.joker.wms.dao.hibernate.GenericDaoHibernate;
import org.springframework.stereotype.Repository;

@Repository("statusTypeDao")
public class StatusTypeDaoHibernate extends GenericDaoHibernate<StatusType, Long> implements StatusTypeDao {

    public StatusTypeDaoHibernate() {
        super(StatusType.class);
    }
}
