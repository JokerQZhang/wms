package com.joker.wms.dao.hibernate;

import com.joker.wms.model.UomType;
import com.joker.wms.dao.UomTypeDao;
import com.joker.wms.dao.hibernate.GenericDaoHibernate;
import org.springframework.stereotype.Repository;

@Repository("uomTypeDao")
public class UomTypeDaoHibernate extends GenericDaoHibernate<UomType, Long> implements UomTypeDao {

    public UomTypeDaoHibernate() {
        super(UomType.class);
    }
}
