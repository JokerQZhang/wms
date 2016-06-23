package com.joker.wms.dao.hibernate;

import com.joker.wms.model.RoleType;
import com.joker.wms.dao.RoleTypeDao;
import com.joker.wms.dao.hibernate.GenericDaoHibernate;
import org.springframework.stereotype.Repository;

@Repository("roleTypeDao")
public class RoleTypeDaoHibernate extends GenericDaoHibernate<RoleType, Long> implements RoleTypeDao {

    public RoleTypeDaoHibernate() {
        super(RoleType.class);
    }
}
