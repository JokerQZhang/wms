package com.joker.wms.dao.hibernate;

import java.util.List;
import java.util.Map;

import com.joker.wms.model.Facility;
import com.joker.wms.dao.FacilityDao;
import com.joker.wms.dao.hibernate.GenericDaoHibernate;

import org.hibernate.SQLQuery;
import org.springframework.stereotype.Repository;

@Repository("facilityDao")
public class FacilityDaoHibernate extends GenericDaoHibernate<Facility, Long> implements FacilityDao {

    public FacilityDaoHibernate() {
        super(Facility.class);
    }
    
    @Override
    public String makeSqlForCondition(Map condition){
    	String sql = " SELECT a.*                    "
	    			+" FROM facility a               "
	    			+" INNER JOIN party_group b      "
	    			+" ON a.owner_party_id=b.party_id"
	    			+" WHERE 1=1 ";
    	
    	if(condition!=null && !condition.isEmpty()){
    		if(condition.containsKey("groupId")){
    			sql +=" AND b.pg_id=" + condition.get("groupId");
    		}
    	}
		return sql;
	}
    /**
     * 查询用户归属的部门的facility
     */
	@Override
	public List getFacilityByUserId(String userId) {
		String sql = " SELECT a.*                                                            "
					+" FROM facility a                                                       "
					+" INNER JOIN party_relationship b                                       "
					+" ON a.owner_party_id=b.party_id_from AND b.party_relationship_type_id=1"
					+" INNER JOIN party_user c                                               "
					+" ON b.party_id_to = c.party_id                                         "
					+" WHERE c.user_id=" + userId;
		return super.findBySql(sql).addEntity(Facility.class).list();
	}
	/**
	 * 查询部门的子部门facility
	 */
	@Override
	public List getFacilityByPartyGroupId(String partyId) {
		String sql = " SELECT a.*                                                          "
					+" FROM facility a                                                     "
					+" INNER JOIN party_relationship b                                     "
					+" ON a.owner_party_id=b.party_id_to AND b.party_relationship_type_id=1"
					+" WHERE b.party_id_from=1" + partyId;
		return super.findBySql(sql).addEntity(Facility.class).list();
	}
}
