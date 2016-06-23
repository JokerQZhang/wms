package com.joker.wms.dao.hibernate;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.queryParser.ParseException;
import org.apache.lucene.util.Version;

import com.joker.wms.dao.GenericDao;
import com.joker.wms.dao.SearchException;
import com.joker.wms.webapp.action.Page;

import org.hibernate.*;
import org.hibernate.criterion.Projections;
import org.hibernate.search.FullTextSession;
import org.hibernate.search.Search;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.orm.ObjectRetrievalFailureException;

import javax.annotation.Resource;

import java.io.Serializable;
import java.util.*;

/**
 * This class serves as the Base class for all other DAOs - namely to hold
 * common CRUD methods that they might all use. You should only need to extend
 * this class when your require custom CRUD logic.
 * <p/>
 * <p>To register this class in your Spring context file, use the following XML.
 * <pre>
 *      &lt;bean id="fooDao" class="com.joker.wms.dao.hibernate.GenericDaoHibernate"&gt;
 *          &lt;constructor-arg value="com.joker.wms.model.Foo"/&gt;
 *      &lt;/bean&gt;
 * </pre>
 *
 * @param <T>  a type variable
 * @param <PK> the primary key for that type
 * @author <a href="mailto:bwnoll@gmail.com">Bryan Noll</a>
 *         Updated by jgarcia: update hibernate3 to hibernate4
 * @author jgarcia (update: added full text search + reindexing)
 */
public class GenericDaoHibernate<T, PK extends Serializable> implements GenericDao<T, PK> {
    /**
     * Log variable for all child classes. Uses LogFactory.getLog(getClass()) from Commons Logging
     */
    protected final Log log = LogFactory.getLog(getClass());
    private Class<T> persistentClass;
    @Resource
    private SessionFactory sessionFactory;
    private Analyzer defaultAnalyzer;

    /**
     * Constructor that takes in a class to see which type of entity to persist.
     * Use this constructor when subclassing.
     *
     * @param persistentClass the class type you'd like to persist
     */
    public GenericDaoHibernate(final Class<T> persistentClass) {
        this.persistentClass = persistentClass;
        defaultAnalyzer = new StandardAnalyzer(Version.LUCENE_36);
    }

    /**
     * Constructor that takes in a class and sessionFactory for easy creation of DAO.
     *
     * @param persistentClass the class type you'd like to persist
     * @param sessionFactory  the pre-configured Hibernate SessionFactory
     */
    public GenericDaoHibernate(final Class<T> persistentClass, SessionFactory sessionFactory) {
        this.persistentClass = persistentClass;
        this.sessionFactory = sessionFactory;
        defaultAnalyzer = new StandardAnalyzer(Version.LUCENE_36);
    }

    public SessionFactory getSessionFactory() {
        return this.sessionFactory;
    }

    public Session getSession() throws HibernateException {
        Session sess = getSessionFactory().getCurrentSession();
        if (sess == null) {
            sess = getSessionFactory().openSession();
        }
        return sess;
    }

    @Autowired
    @Required
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    public List<T> getAll() {
        Session sess = getSession();
        return sess.createCriteria(persistentClass).list();
    }
    @SuppressWarnings("unchecked")
    public List<T> getAll(Page page) {
        Session sess = getSession();
        Criteria criteria = sess.createCriteria(persistentClass);
        criteria.setProjection(Projections.rowCount());
        Integer value = ((Long)criteria.uniqueResult()).intValue();  
        page.setAllRecordNum(value);
        criteria.setProjection(null);
    	criteria.setFirstResult((page.getPageIndex()-1)*page.getPageSize());
    	criteria.setMaxResults(page.getPageSize());
    	
        return criteria.list();
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    public List<T> getAllDistinct() {
        Collection<T> result = new LinkedHashSet<T>(getAll());
        return new ArrayList<T>(result);
    }

    /**
     * {@inheritDoc}
     */
    public List<T> search(String searchTerm) throws SearchException {
        Session sess = getSession();
        FullTextSession txtSession = Search.getFullTextSession(sess);

        org.apache.lucene.search.Query qry;
        try {
            qry = HibernateSearchTools.generateQuery(searchTerm, this.persistentClass, sess, defaultAnalyzer);
        } catch (ParseException ex) {
            throw new SearchException(ex);
        }
        org.hibernate.search.FullTextQuery hibQuery = txtSession.createFullTextQuery(qry,
                this.persistentClass);
        return hibQuery.list();
    }
    
    public List<T> search(String searchTerm, Page page) throws SearchException {
        Session sess = getSession();
        FullTextSession txtSession = Search.getFullTextSession(sess);

        org.apache.lucene.search.Query qry;
        try {
            qry = HibernateSearchTools.generateQuery(searchTerm, this.persistentClass, sess, defaultAnalyzer);
        } catch (ParseException ex) {
            throw new SearchException(ex);
        }
        org.hibernate.search.FullTextQuery hibQuery = txtSession.createFullTextQuery(qry,
                this.persistentClass);
        
        page.setAllRecordNum(hibQuery.getResultSize());
        hibQuery.setFirstResult((page.getPageIndex()-1)*page.getPageSize());
        hibQuery.setMaxResults(page.getPageSize());
        return hibQuery.list();
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    public T get(PK id) {
        Session sess = getSession();
        IdentifierLoadAccess byId = sess.byId(persistentClass);
        T entity = (T) byId.load(id);

        if (entity == null) {
            log.warn("Uh oh, '" + this.persistentClass + "' object with id '" + id + "' not found...");
            throw new ObjectRetrievalFailureException(this.persistentClass, id);
        }

        return entity;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    public boolean exists(PK id) {
        Session sess = getSession();
        IdentifierLoadAccess byId = sess.byId(persistentClass);
        T entity = (T) byId.load(id);
        return entity != null;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    public T save(T object) {
        Session sess = getSession();
        return (T) sess.merge(object);
    }

    /**
     * {@inheritDoc}
     */
    public void remove(T object) {
        Session sess = getSession();
        sess.delete(object);
    }

    /**
     * {@inheritDoc}
     */
    public void remove(PK id) {
        Session sess = getSession();
        IdentifierLoadAccess byId = sess.byId(persistentClass);
        T entity = (T) byId.load(id);
        sess.delete(entity);
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    public List<T> findByNamewmsuery(String queryName, Map<String, Object> queryParams) {
        Session sess = getSession();
        Query namewmsuery = sess.getNamedQuery(queryName);
        for (String s : queryParams.keySet()) {
            Object val = queryParams.get(s);
            if (val instanceof Collection) {
                namewmsuery.setParameterList(s, (Collection) val);
            } else {
                namewmsuery.setParameter(s, val);
            }
        }
        return namewmsuery.list();
    }

    /**
     * {@inheritDoc}
     */
    public void reindex() {
        HibernateSearchTools.reindex(persistentClass, getSessionFactory().getCurrentSession());
    }


    /**
     * {@inheritDoc}
     */
    public void reindexAll(boolean async) {
        HibernateSearchTools.reindexAll(async, getSessionFactory().getCurrentSession());
    }

	@Override
	public Object load(Class clazz, Serializable entityId) {
		Session sess = getSession();
		try{
			IdentifierLoadAccess loadById = sess.byId(clazz);
			return loadById.load(entityId);
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	/**
	 * select {a.*} FROM ...
	 * 这里必须要是a.*,第一个from必须全部大写FROM
	 */
	@Override
	public SQLQuery findBySql(String sql, Class clazz, Page page) {
		Session sess = getSession();
		SQLQuery sqlQuery = sess.createSQLQuery(sql).addEntity("a", clazz);
		if(page != null){
			if(sql.indexOf("{a.*}")>-1){
				Integer fromIndex = sql.indexOf("FROM");
				sql = sql.substring(fromIndex);
				sql = "select 1 " + sql;
			}
			//需要分页
			String countsql = "select count(1) from (" + sql + ")a";
			Integer resultSize = Integer.valueOf(sess.createSQLQuery(countsql).uniqueResult().toString());
			page.setAllRecordNum(resultSize);
			sqlQuery.setFirstResult((page.getPageIndex()-1)*page.getPageSize());
			sqlQuery.setMaxResults(page.getPageSize());
		}
		return sqlQuery;
	}
	/**
	 * select {a.*} FROM ...
	 * 这里必须要是a.*,第一个from必须全部大写FROM
	 */
	@Override
	public SQLQuery findBySql(String sql, Page page) {
		Session sess = getSession();
		SQLQuery sqlQuery = sess.createSQLQuery(sql);
		if(page != null){
			
			//这里需要注意，mysql的select多个表有可能字段名重复，那么这里查询会报错，所以要修改sql
			if(sql.indexOf("{a.*}")>-1){
				Integer fromIndex = sql.indexOf("FROM");
				sql = sql.substring(fromIndex);
				sql = "select 1 " + sql;
			}
			//需要分页
			String countsql = "select count(1) from (" + sql + ")a";
			Integer resultSize = Integer.valueOf(sess.createSQLQuery(countsql).uniqueResult().toString());
			page.setAllRecordNum(resultSize);

			sqlQuery.setFirstResult((page.getPageIndex()-1)*page.getPageSize());
			sqlQuery.setMaxResults(page.getPageSize());
		}
		return sqlQuery;
	}

	@Override
	public SQLQuery findBySql(String sql) {
		Session sess = getSession();
		SQLQuery sqlQuery = sess.createSQLQuery(sql);
		return sqlQuery;
	}
	
	@Override
	public Object saveObject(Object obj){
		Session sess = getSession();
		return sess.merge(obj);
	}

	@Override
	public List searchByCondition(Map condition, Page page) {
		String sql = makeSqlForCondition(condition);
		SQLQuery sqlQuery = findBySql(sql, page);
		sqlQuery = setQueryEntitys(sqlQuery);
		return sqlQuery.list();
	}
	
	@Override
	public int executeSql(String sql){
		Session sess = getSession();
		return sess.createSQLQuery(sql).executeUpdate();
	}
	public String makeSqlForCondition(Map condition){
		return null;
	}
	public SQLQuery setQueryEntitys(SQLQuery sqlQuery){
		sqlQuery.addEntity(persistentClass);
		return sqlQuery;
	}

	@Override
	public List searchByCondition(Map condition) {
		String sql = makeSqlForCondition(condition);
		SQLQuery sqlQuery = findBySql(sql);
		sqlQuery = setQueryEntitys(sqlQuery);
		return sqlQuery.list();
	}

	@Override
	public boolean deleteObject(Object obj) {
		Session sess = getSession();
		sess.delete(obj);
		return true;
	}
}
