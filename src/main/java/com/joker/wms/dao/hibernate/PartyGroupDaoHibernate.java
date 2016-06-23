package com.joker.wms.dao.hibernate;

import java.util.List;
import java.util.Map;

import com.joker.wms.model.Party;
import com.joker.wms.model.PartyGroup;
import com.joker.wms.model.PartyRelationship;
import com.joker.wms.model.PartyRole;
import com.joker.wms.model.Person;
import com.joker.wms.model.VillageInfo;
import com.joker.wms.webapp.action.Page;
import com.joker.wms.dao.PartyGroupDao;
import com.joker.wms.dao.hibernate.GenericDaoHibernate;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

@Repository("partyGroupDao")
public class PartyGroupDaoHibernate extends GenericDaoHibernate<PartyGroup, Long> implements PartyGroupDao {

    public PartyGroupDaoHibernate() {
        super(PartyGroup.class);
    }

	@Override
	public Party saveParty(Party party) {
		Session sess = super.getSession();
		sess.saveOrUpdate(party);
		sess.flush();
		return party;
	}

	@Override
	public PartyRole savePartyRole(PartyRole partyRole) {
		Session sess = super.getSession();
		sess.saveOrUpdate(partyRole);
		sess.flush();
		return partyRole;
	}

	@Override
	public List searchRelationToPartyGroup(Map condition, Page page) {
		String sql = " SELECT c.*                     "
					+" FROM party_group a             "
					+" INNER JOIN party_relationship b"
					+" ON a.party_id=b.party_id_from  "
					+" INNER JOIN party_group c       "
					+" ON b.party_id_to=c.party_id    "
					+" WHERE 1=1 ";
		if(condition!=null && !condition.isEmpty()){
			if(condition.containsKey("vendorId")){
				sql += " AND a.party_id=" + condition.get("vendorId");
			}
			if(condition.containsKey("partyRelationshipTypeId")){
				sql += " AND b.party_relationship_type_id=" + condition.get("partyRelationshipTypeId");
			}
		}
		SQLQuery sQLQuery = super.findBySql(sql, page);
		sQLQuery.addEntity(PartyGroup.class);
		return sQLQuery.list();
	}

	@Override
	public List<PartyGroup> getGroupCustomer(String ids) {
		if(ids==null || "".equals(ids)){
			return null;
		}
		String sql = " SELECT c.*                                                  "
				+" FROM party_group a                                              "
				+" INNER JOIN party_relationship b                                 "
				+" ON a.party_id=b.party_id_from AND b.party_relationship_type_id=2"
				+" INNER JOIN party_group c                                        "
				+" ON b.party_id_to=c.party_id                                     "
				+" WHERE a.party_id IN(" + ids + ")";
		
		return super.findBySql(sql).addEntity(PartyGroup.class).list();
	}

	@Override
	public String makeSqlForCondition(Map condition) {
		String sql = "select * from party_group";
		if(condition!=null && !condition.isEmpty()){
			if(condition.containsKey("roleTypeId")){
				//按照角色查询
				sql = "SELECT a.*                                   "
					+"FROM party_group a                           "
					+"INNER JOIN party_role b                      "
					+"ON a.party_id=b.party_id AND b.role_type_id=" + condition.get("roleTypeId");
				if(condition.containsKey("groupName")){
					sql += " WHERE group_name like '%"+ condition.get("groupName") +"%'";
				}
			}
			//树形结构查询 village
			if(condition.containsKey("searchType") && "partyGroupTree".equals(condition.get("searchType"))){
				String parentId = condition.get("parentId").toString();
				sql = " SELECT a.*                                                                          "
					+" FROM party_group a                                                                  "
					+" INNER JOIN party_relationship c                                                     "
					+" ON a.party_id=c.party_id_to AND c.party_relationship_type_id=" + condition.get("partyRelationshipTypeId") + " AND c.party_id_from=" + parentId;
			}
		}
		return sql;
	}

	@Override
	public List searchCun(Map condition) {
		String sql = " SELECT {a.*},{b.*}      "
					+" FROM party_group a      "
					+" LEFT JOIN village_info b"
					+" ON a.party_id=b.party_id WHERE 1=1 ";
		if(condition!=null && !condition.isEmpty()){
			if(condition.containsKey("partyId")&&!"".equals(condition.get("partyId"))){
				sql += " AND a.party_id=" + condition.get("partyId");
			}
		}
		List result = super.findBySql(sql).addEntity("a", PartyGroup.class).addEntity("b", VillageInfo.class).list();
		return result;
	}
	
	/**
	 * 查询机构的关联人员信息
	 * 查询条件
	 * 机构ID：partyId
	 * 角色类型：roleTypeId、roleTypeIds
	 * 关系类型：partyRelationShipTypeId、partyRelationShipTypeIds
	 * 
	 */
	@Override
	public List getMPersons(Map condition) {
		String sql = " SELECT {a.*},{c.*}                                       "
					+" FROM party_relationship b                                "
					+" INNER JOIN person a                                      "
					+" ON b.party_id_to=a.party_id                              "
					+" INNER JOIN party_role c                                  "
					+" ON b.party_id_to=c.party_id                              ";
		if(condition.containsKey("roleTypeId")){
			sql += " AND c.role_type_id=" + condition.get("roleTypeId");
		}
		if(condition.containsKey("roleTypeIds")){
			sql += " AND c.role_type_id IN (" + condition.get("roleTypeIds") + ") ";
		}
		sql += " WHERE 1=1                                                ";
		if(condition.containsKey("partyRelationShipTypeId")){
			sql += " AND b.party_relationship_type_id=" + condition.get("partyRelationShipTypeId");
		}
		if(condition.containsKey("partyRelationShipTypeIds")){
			sql += " AND b.party_relationship_type_id IN (" + condition.get("partyRelationShipTypeIds") + ") ";
		}
		sql += " AND b.status_id=0                                        ";
		if(condition.containsKey("partyId")){
			sql += " AND b.party_id_from=" + condition.get("partyId");
		}
		return super.findBySql(sql).addEntity("a",Person.class).addEntity("c",PartyRole.class).list();
	}
	/**
	 * 查找给定党委支部归属行政机构的下属机构
	 * dwId:党委支部的party_id
	 * 
	 */
	@Override
	public List getPgByDwId(Map condition) {
		String sql =" SELECT d.*                                                           "
					+" FROM party_group a                                                   "
					+" INNER JOIN party_relationship b                                      "
					+" ON a.party_id=b.party_id_to AND b.party_relationship_type_id=3       "
					+" INNER JOIN party_relationship c                                      "
					+" ON b.party_id_from=c.party_id_from AND c.party_relationship_type_id=1"
					+" INNER JOIN party_group d                                             "
					+" ON c.party_id_to=d.party_id                                          "
					+" WHERE 1=1                                                  ";
		if(condition.containsKey("dwId")){
			sql += " AND a.party_id=" + condition.get("dwId");
		}
		return super.findBySql(sql).addEntity("d", PartyGroup.class).list();
	}
	/**
	 * 根据角色获取partyGroup
	 */
	@Override
	public List getPartyGroupByRole(Map condition) {
		String sql =" SELECT a.*                "
					+" FROM party_group a      "
					+" INNER JOIN party_role b "
					+" ON a.party_id=b.party_id"
					+" WHERE 1=1 ";
		if(condition.containsKey("roleTypeId")){
			sql += " AND role_type_id=" + condition.get("roleTypeId");
		}
		return super.findBySql(sql).addEntity("a", PartyGroup.class).list();
	}
	/**
	 * partyRelationShipTypeId:关系类型
	 * dwId:party_id_to
	 * 返回party_id_from的PartyGroup
	 */
	@Override
	public List getPartyGroupOfRS(Map condition) {
		String sql =" SELECT a.*                        "
					+" FROM party_group a                "
					+" INNER JOIN party_relationship b   "
					+" ON a.party_id=b.party_id_from     ";
		if(condition.containsKey("partyRelationShipTypeId")){
			sql += " AND b.party_relationship_type_id=" + condition.get("partyRelationShipTypeId");
		}
		if(condition.containsKey("dwId")){
			sql += " AND b.party_id_to=" + condition.get("dwId");
		}
		return super.findBySql(sql).addEntity("a", PartyGroup.class).list();
	}
	/**
	 * partyId:根据partyId获取partygroup
	 */
	@Override
	public List getPartyGroup(Map condition) {
		String sql =" SELECT b.*              "
					+" FROM party a            "
					+" INNER JOIN party_group b"
					+" ON a.party_id=b.party_id"
					+" WHERE 1=1 ";
		if(condition.containsKey("partyId")){
			sql += " AND a.party_id= " + condition.get("partyId");
		}
		return super.findBySql(sql).addEntity("b", PartyGroup.class).list();
	}
	/**
	 * partyRelationshipTypeId：关系类型
	 * partyId：待查询的partyId
	 */
	@Override
	public List getPartyGroupFromRS(Map condition) {
		String sql = " SELECT b.*                                                      "
					+" FROM party_relationship a                                       "
					+" INNER JOIN party_group b                                        "
					+" ON a.party_id_from=b.party_id WHERE 1=1 ";
		if(condition!=null && !condition.isEmpty()){
			if(condition.containsKey("partyRelationshipTypeId")){
				sql += " AND a.party_relationship_type_id=" + condition.get("partyRelationshipTypeId");
			}
			if(condition.containsKey("partyRelationshipTypeIds")){
				sql += " AND a.party_relationship_type_id in (" + condition.get("partyRelationshipTypeIds") + ")";
			}
			if(condition.containsKey("roleTypeId")){
				sql += " AND EXISTS (SELECT 1 FROM party_role WHERE party_id=b.party_id AND role_type_id=" + condition.get("roleTypeId") + ")";
			}
			if(condition.containsKey("partyId")){
				sql += " AND a.party_id_to=" + condition.get("partyId");
			}
		}
		return super.findBySql(sql).addEntity("b", PartyGroup.class).list();
	}

	@Override
	public List getPartyGroupToRS(Map condition) {
		String sql = " SELECT b.*                          "
					+" FROM party_relationship a           "
					+" INNER JOIN party_group b            "
					+" ON a.party_id_to=b.party_id         "
					+" WHERE 1=1 ";
		if(condition!=null && !condition.isEmpty()){
			if(condition.containsKey("partyRelationshipTypeId")){
				sql += " AND a.party_relationship_type_id=" + condition.get("partyRelationshipTypeId");
			}
			if(condition.containsKey("partyId")){
				sql += " AND a.party_id_from=" + condition.get("partyId");
			}
		}
		return super.findBySql(sql).addEntity("b", PartyGroup.class).list();
	}

	@Override
	public List getZhiBuByCondition(Map condition) {
		String sql = " SELECT a.*                                   "
					+" FROM party_group a                           "
					+" INNER JOIN party_role b                      "
					+" ON a.party_id=b.party_id AND b.role_type_id=2"
					+" WHERE 1=1 ";
		if(condition!=null && !condition.isEmpty()){
			
		}
		return super.findBySql(sql).addEntity("a", PartyGroup.class).list();
	}
	
}
