package com.joker.wms.dao.hibernate;

import com.joker.wms.dao.UserDao;
import com.joker.wms.model.PartyGroup;
import com.joker.wms.model.PartyUser;
import com.joker.wms.model.Person;
import com.joker.wms.model.User;

import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.hibernate4.SessionFactoryUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import javax.persistence.Table;

import java.util.List;

/**
 * This class interacts with Hibernate session to save/delete and
 * retrieve User objects.
 *
 * @author <a href="mailto:matt@raibledesigns.com">Matt Raible</a>
 *         Modified by <a href="mailto:dan@getrolling.com">Dan Kibler</a>
 *         Extended to implement Acegi UserDetailsService interface by David Carter david@carter.net
 *         Modified by <a href="mailto:bwnoll@gmail.com">Bryan Noll</a> to work with
 *         the new BaseDaoHibernate implementation that uses generics.
 *         Modified by jgarcia (updated to hibernate 4)
 */
@Repository("userDao")
public class UserDaoHibernate extends GenericDaoHibernate<User, Long> implements UserDao, UserDetailsService {

    /**
     * Constructor that sets the entity to User.class.
     */
    public UserDaoHibernate() {
        super(User.class);
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    public List<User> getUsers() {
        Query qry = getSession().createQuery("from User u order by upper(u.username)");
        return qry.list();
    }

    /**
     * {@inheritDoc}
     */
    public User saveUser(User user) {
        if (log.isDebugEnabled()) {
            log.debug("user's id: " + user.getId());
        }
        getSession().saveOrUpdate(user);
        // necessary to throw a DataIntegrityViolation and catch it in UserManager
        getSession().flush();
        return user;
    }

    /**
     * Overridden simply to call the saveUser method. This is happening
     * because saveUser flushes the session and saveObject of BaseDaoHibernate
     * does not.
     *
     * @param user the user to save
     * @return the modified user (with a primary key set if they're new)
     */
    @Override
    public User save(User user) {
        return this.saveUser(user);
    }

    /**
     * {@inheritDoc}
     */
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List users = getSession().createCriteria(User.class).add(Restrictions.eq("username", username)).list();
        if (users == null || users.isEmpty()) {
            throw new UsernameNotFoundException("user '" + username + "' not found...");
        } else {
            return (UserDetails) users.get(0);
        }
    }

    /**
     * {@inheritDoc}
     */
    public String getUserPassword(Long userId) {
        JdbcTemplate jdbcTemplate =
                new JdbcTemplate(SessionFactoryUtils.getDataSource(getSessionFactory()));
        Table table = AnnotationUtils.findAnnotation(User.class, Table.class);
        return jdbcTemplate.queryForObject(
                "select password from " + table.name() + " where id=?", String.class, userId);
    }

	@Override
	public List getUserByPartyId(String partyId) {
		String sql = "select * from party_user where party_id=" + partyId;
		return super.findBySql(sql).addEntity(PartyUser.class).list();
	}

	@Override
	public PartyUser savePartyUser(PartyUser partyUser) {
		partyUser = (PartyUser)super.saveObject(partyUser);
		return partyUser;
	}

	@Override
	public List<PartyGroup> getPartyGroupByUser(String userId) {
		String sql = " SELECT d.*                                                    "
					+" FROM app_user a                                               "
					+" INNER JOIN party_user b                                       "
					+" ON a.id=b.user_id                                             "
					+" INNER JOIN party_relationship c                               "
					+" ON b.party_id=c.party_id_to AND c.party_relationship_type_id=1"
					+" INNER JOIN party_group d                                      "
					+" ON c.party_id_from=d.party_id                                 "
					+" WHERE a.id=" + userId;
		return super.findBySql(sql).addEntity(PartyGroup.class).list();
	}

	@Override
	public Person getPersonByUser(String userId) {
		String sql = " SELECT c.*              "
					+" FROM app_user a         "
					+" INNER JOIN party_user b "
					+" ON a.id=b.user_id       "
					+" INNER JOIN person c     "
					+" ON b.party_id=c.party_id"
					+" WHERE b.user_id=" + userId;
		List personList = super.findBySql(sql).addEntity(Person.class).list();
		Person person = null; 
		if(personList!=null && personList.size()>0){
			person = (Person)personList.get(0);
		}
		return person;
	}
}
