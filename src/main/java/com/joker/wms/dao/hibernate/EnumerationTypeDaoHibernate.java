package com.joker.wms.dao.hibernate;

import com.joker.wms.model.EnumerationType;
import com.joker.wms.dao.EnumerationTypeDao;
import com.joker.wms.dao.hibernate.GenericDaoHibernate;
import org.springframework.stereotype.Repository;

@Repository("enumerationTypeDao")
public class EnumerationTypeDaoHibernate extends GenericDaoHibernate<EnumerationType, Long> implements EnumerationTypeDao {

    public EnumerationTypeDaoHibernate() {
        super(EnumerationType.class);
    }
}
