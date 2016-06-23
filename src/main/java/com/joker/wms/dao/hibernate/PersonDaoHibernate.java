package com.joker.wms.dao.hibernate;

import java.util.List;
import java.util.Map;

import com.joker.wms.model.CpDtl;
import com.joker.wms.model.CpPositive;
import com.joker.wms.model.PartyRole;
import com.joker.wms.model.Person;
import com.joker.wms.webapp.action.Page;
import com.joker.wms.dao.PersonDao;
import com.joker.wms.dao.SearchException;
import com.joker.wms.dao.hibernate.GenericDaoHibernate;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.queryParser.ParseException;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.util.Version;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.search.FullTextSession;
import org.hibernate.search.Search;
import org.hibernate.search.SearchFactory;
import org.hibernate.search.indexes.IndexReaderAccessor;
import org.springframework.stereotype.Repository;

@Repository("personDao")
public class PersonDaoHibernate extends GenericDaoHibernate<Person, Long> implements PersonDao {

    public PersonDaoHibernate() {
        super(Person.class);
    }

	@Override
	public List searchByGroupId(String query, Class claaz, Page page,
			String belongGroupId) {
		Session sess = getSession();
        FullTextSession txtSession = Search.getFullTextSession(sess);

        org.apache.lucene.search.Query qry;
        try {
            qry = HibernateSearchTools.generateQuery(query, claaz, sess, new StandardAnalyzer(Version.LUCENE_36));
            SearchFactory searchFactory = txtSession.getSearchFactory();
            IndexReaderAccessor readerAccessor = searchFactory.getIndexReaderAccessor();
            IndexReader reader = readerAccessor.open(claaz);
            IndexSearcher indexSearcher = new IndexSearcher(reader);
            indexSearcher.search(qry,5);
        } catch (Exception ex) {
            throw new SearchException(ex);
        }
        org.hibernate.search.FullTextQuery hibQuery = txtSession.createFullTextQuery(qry, claaz);
        
        page.setAllRecordNum(hibQuery.getResultSize());
        hibQuery.setFirstResult((page.getPageIndex()-1)*page.getPageSize());
        hibQuery.setMaxResults(page.getPageSize());
        //return hibQuery.list();
		return null;
	}

	@Override
	public List searchAllByGroupId(Class clazz, Page page, String belongGroupId) {
		String sql = " SELECT a.*                                                                        "
					+" FROM person a                                                                     "
					+" INNER JOIN party_relationship b                                                   "
					+" ON a.party_id = b.party_id_to AND b.status_id=0"
					+" WHERE b.party_id_from=" + belongGroupId;
		
		return super.findBySql(sql, clazz, page).list();
	}
	/**
	 * 查询党员信息
	 * isNowDangwei:党委类型 “dangwei”：党委级别 “”：党支部级别；“xianwei”：全部级别
	 * belongGroupId:支部或者党委的partyId
	 */
	@Override
	public List getDangPerson(Map condition) {
		String sql = "";
		if(condition.containsKey("isNowDangwei")){
			if("".equals(condition.get("isNowDangwei"))){
				sql =" SELECT a.*                                                  "
					+" FROM person a                                               "
					+" INNER JOIN party_relationship b                             "
					+" ON a.party_id=b.party_id_to AND party_relationship_type_id=4"
					+" WHERE b.party_id_from=" + condition.get("belongGroupId");
			}else if("dangwei".equals(condition.get("isNowDangwei"))){
				sql =" SELECT a.*                                                         "
					+" FROM party_relationship c                                          "
					+" INNER JOIN party_relationship b                                    "
					+" ON c.party_id_to=b.party_id_from AND b.party_relationship_type_id=4"
					+" INNER JOIN person a                                                "
					+" ON b.party_id_to=a.party_id                                        "
					+" WHERE c.party_relationship_type_id=4 AND c.party_id_from=" + condition.get("belongGroupId");
			}else if("xianwei".equals(condition.get("isNowDangwei"))){
//				sql =" SELECT d.*                                                         "
//					+" FROM party_relationship a                                          "
//					+" INNER JOIN party_relationship b                                    "
//					+" ON a.party_id_to=b.party_id_from AND b.party_relationship_type_id=4"
//					+" INNER JOIN party_relationship c                                    "
//					+" ON b.party_id_to=c.party_id_from AND c.party_relationship_type_id=4"
//					+" INNER JOIN person d                                                "
//					+" ON c.party_id_to=d.party_id                                        "
//					+" WHERE a.party_relationship_type_id=4 AND a.party_id_from=" + condition.get("belongGroupId");
				sql =" SELECT b.*                                   "
					+" FROM party a                                 "
					+" INNER JOIN person b                          "
					+" ON a.party_id=b.party_id                     "
					+" INNER JOIN party_role c                      "
					+" ON a.party_id=c.party_id AND c.role_type_id=2";
			}
		}
		if(condition.containsKey("statusId")){
			sql += " AND EXISTS(SELECT 1 FROM cp_dtl WHERE party_id=a.party_id AND status_id='" + condition.get("statusId") + "')";
		}
		if(condition.containsKey("statusIdIn")){
			sql += " AND EXISTS(SELECT 1 FROM cp_dtl WHERE party_id=a.party_id AND status_id in " + condition.get("statusIdIn") + ")";
		}
		return super.findBySql(sql).addEntity(Person.class).list();
	}

	@Override
	public List findCpDtl(Map condition) {
		String sql = "SELECT * FROM cp_dtl WHERE 1=1";
		if(condition!=null && !condition.isEmpty()){
			if(condition.containsKey("partyId")){
				sql += " AND party_id=" + condition.get("partyId");
			}
		}
		return super.findBySql(sql).addEntity(CpDtl.class).list();
	}

	@Override
	public List findCpPositive(Map condition) {
		String sql = "SELECT * FROM cp_positive WHERE 1=1";
		if(condition!=null && !condition.isEmpty()){
			if(condition.containsKey("partyId")){
				sql += " AND party_id=" + condition.get("partyId");
			}
		}
		return super.findBySql(sql).addEntity(CpPositive.class).list();
	}

	@Override
	public boolean approvalDangPerson(String partyId, String totalNum,
			String approvalNum, String approvalResult, String resultStatus) {
		String sql = "";
		if(approvalResult!=null && "1".equals(approvalResult)){
			String sql2 = "update cp_dtl set status_id='" + resultStatus + "' where party_id=" + partyId;
			super.executeSql(sql2);
			if("3".equals(resultStatus)){
				sql = "update cp_positive set fzdx_num='" + totalNum + "',fzdx_positive_num='" + approvalNum + "' where party_id=" + partyId;
			}else if("2".equals(resultStatus)){
				sql = "update cp_positive set ybdy_num='" + totalNum + "',yndy_positive_num='" + approvalNum + "' where party_id=" + partyId;
			}else if("1".equals(resultStatus)){
				sql = "update cp_positive set zsdy_num='" + totalNum + "',zsdy_positive_num='" + approvalNum + "' where party_id=" + partyId;
			}
		}else{
			if("4".equals(resultStatus)){
				sql = "update cp_positive set fzdx_num='" + totalNum + "',fzdx_positive_num='" + approvalNum + "' where party_id=" + partyId;
			}else if("3".equals(resultStatus)){
				sql = "update cp_positive set ybdy_num='" + totalNum + "',yndy_positive_num='" + approvalNum + "' where party_id=" + partyId;
			}else if("2".equals(resultStatus)){
				sql = "update cp_positive set zsdy_num='" + totalNum + "',zsdy_positive_num='" + approvalNum + "' where party_id=" + partyId;
			}
		}
		super.executeSql(sql);
		return true;
	}

	@Override
	public List getPersonRoles(Map condition) {
		String sql = " SELECT b.*              "
					+" FROM person a           "
					+" INNER JOIN party_role b "
					+" ON a.party_id=b.party_id"
					+" WHERE 1=1     ";
		if(condition!=null && !condition.isEmpty()){
			if(condition.containsKey("partyId")){
				sql += " AND party_id=" + condition.get("partyId");
			}
			if(condition.containsKey("roleTypeId")){
				sql += " AND role_type_id=" + condition.get("roleTypeId");
			}
		}
		return super.findBySql(sql).addEntity("b", PartyRole.class).list();
	}
}
