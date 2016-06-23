package com.joker.wms.dao.hibernate;

import com.joker.wms.model.PartyRelationship;
import com.joker.wms.dao.PartyRelationshipDao;
import com.joker.wms.dao.hibernate.GenericDaoHibernate;
import org.springframework.stereotype.Repository;

@Repository("partyRelationshipDao")
public class PartyRelationshipDaoHibernate extends GenericDaoHibernate<PartyRelationship, Long> implements PartyRelationshipDao {

    public PartyRelationshipDaoHibernate() {
        super(PartyRelationship.class);
    }
}
