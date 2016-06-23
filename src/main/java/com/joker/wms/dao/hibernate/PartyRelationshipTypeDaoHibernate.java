package com.joker.wms.dao.hibernate;

import com.joker.wms.model.PartyRelationshipType;
import com.joker.wms.dao.PartyRelationshipTypeDao;
import com.joker.wms.dao.hibernate.GenericDaoHibernate;
import org.springframework.stereotype.Repository;

@Repository("partyRelationshipTypeDao")
public class PartyRelationshipTypeDaoHibernate extends GenericDaoHibernate<PartyRelationshipType, Long> implements PartyRelationshipTypeDao {

    public PartyRelationshipTypeDaoHibernate() {
        super(PartyRelationshipType.class);
    }
}
