package com.joker.wms.util;

import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.joker.wms.model.Party;
import com.joker.wms.model.PartyGroup;
import com.joker.wms.model.PartyRelationship;
import com.joker.wms.model.PartyRole;
import com.joker.wms.model.PartyUser;
import com.joker.wms.model.Person;
import com.joker.wms.model.Role;
import com.joker.wms.model.User;

public class JokerETL {
	private static ApplicationContext ctx;
	private static Session sess;
	//获取spring的applicationContext
	private static void initApplicationContext(){
		ctx=new ClassPathXmlApplicationContext(
				new String[]{
						"classpath:/applicationContext-resources.xml",
						"classpath:/applicationContext-dao.xml",
						"classpath:/applicationContext-service.xml"
				});
	}
	//获取Hibernate Session
	private static Session getSession(){
		if(sess == null){
			SessionFactory sessFac = (SessionFactory)ctx.getBean("sessionFactory");
			sess = sessFac.openSession();
		}
		return sess;
	}
	//关闭session
	private static void closeSession(){
		if(sess!=null){
			sess.close();
		}
		sess = null;
	}
	
	//处理party_group根据名字添加拼音首字母缩写
	public static boolean addPGPinyin(){
		String sql = "select * from party_group where pinyin_name is null";
		List list = sess.createSQLQuery(sql).addEntity(PartyGroup.class).list();
		//未查到结果则返回false
		if(list==null || list.size()==0){
			return false;
		}
		sess.beginTransaction();
		for(int i=0; i<list.size(); i++){
			PartyGroup partyGroup = (PartyGroup)list.get(i);
			String pinyinName = PinYinUtil.getPinYinHeadChar(partyGroup.getGroupName());
			partyGroup.setPinyinName(pinyinName);
			System.out.println("添加:" + partyGroup.getGroupName() + "对应的yinpin名字为：" + "---------" + pinyinName);
			sess.update(partyGroup);
		}
		sess.getTransaction().commit();
		return true;
	}
	//新建人员
	public static boolean createUserFormPartyGroup(Long partyGroupId, Long roleId, boolean isWithParentName){
		List partyGroups = sess.createSQLQuery("select * from party_group where party_id=" + partyGroupId).addEntity(PartyGroup.class).list();
		
		if(partyGroups!=null && partyGroups.size()>0){
			PartyGroup partyGroup = (PartyGroup)partyGroups.get(0);
			//创建party
			Party party = new Party();
			party.setCreatedByUser(0l);
			party.setCreatedTime(new Date());
			party.setPartyTypeId("person");
			party.setStatusId(0l);
			party.setDescription(partyGroup.getGroupName() + "操作员");
			sess.beginTransaction();
			party = (Party)sess.merge(party);
			sess.getTransaction().commit();
			//创建person
			Person person = new Person();
			person.setName(partyGroup.getGroupName() + "操作员");
			person.setPartyId(party.getPartyId());
			person.setPinyinName(partyGroup.getPinyinName() + "czy");
			person.setCreatedByUser(0l);
			person.setCreatedTime(new Date());
			sess.beginTransaction();
			person = (Person)sess.merge(person);
			sess.getTransaction().commit();
			//创建party_role
			PartyRole partyRole = new PartyRole();
			partyRole.setPartyId(party.getPartyId());
			partyRole.setRoleTypeId(1l);//操作人员
			partyRole.setCreatedByUser(0l);
			partyRole.setCreatedTime(new Date());
			sess.beginTransaction();
			partyRole = (PartyRole)sess.merge(partyRole);
			sess.getTransaction().commit();
			//创建party_relationship
			PartyRelationship partyRelationship = new PartyRelationship();
			partyRelationship.setCreatedByUser(0l);
			partyRelationship.setCreatedTime(new Date());
			partyRelationship.setPartyIdFrom(partyGroup.getPartyId());
			partyRelationship.setPartyIdTo(party.getPartyId());
			partyRelationship.setFromDate(new Date());
			partyRelationship.setPartyRelationshipTypeId(1l);//上下级关系
			partyRelationship.setRoleTypeIdFrom(1l);
			partyRelationship.setRoleTypeIdTo(1l);
			partyRelationship.setStatusId(0l);
			sess.beginTransaction();
			partyRelationship = (PartyRelationship)sess.merge(partyRelationship);
			sess.getTransaction().commit();
			//创建appuser
			User user = new User();
			user.setAccountExpired(false);
			user.setAccountLocked(false);
			user.setCredentialsExpired(false);
			String userName = person.getPinyinName();
			//需要在用户名上加上上级部门的拼音名称
			if(isWithParentName){
				String sql = " SELECT a.*                                                                          "
							+" FROM party_group a                                                                  "
							+" INNER JOIN party_relationship b                                                     "
							+" ON a.party_id=b.party_id_from AND b.party_relationship_type_id=2 AND b.party_id_to=" + partyGroup.getPartyId();
				List groups = sess.createSQLQuery(sql).addEntity("a", PartyGroup.class).list();
				if(groups!=null && groups.size()>0){
					PartyGroup parentPartyGroup = (PartyGroup)groups.get(0);
					userName = parentPartyGroup.getPinyinName() + userName;
				}
			}
			//判断username不重复
			String sql = "SELECT * FROM app_user WHERE username LIKE '" + userName + "%'";
			List nameUsers = sess.createSQLQuery(sql).addEntity(User.class).list();
			if(nameUsers!=null && nameUsers.size()>0){
				userName = userName + nameUsers.size();
			}
			user.setUsername(userName);
			//求出用户的pinyin作为帐号
			user.setEmail(userName+"@jk.com");
			user.setEnabled(true);
			user.setFirstName(partyGroup.getGroupName() + "操作员");
			//创建user_role
			Role role = (Role)sess.get(Role.class, roleId);
			Set<Role> roleSet = new HashSet<Role>();
			roleSet.add(role);
			user.setRoles(roleSet);
			user.setVersion(1);
			user.setPassword("$2a$10$4ckusP9aQtVr7CKBH5xqne7DCXUjeD8kC5OnicrGwyCU7OxkMAItK");
			user.setPasswordHint("123456");
			user.setLastName(" ");
			sess.beginTransaction();
			user = (User)sess.merge(user);
			sess.getTransaction().commit();
			//创建party_user
			PartyUser partyUser = new PartyUser();
			partyUser.setCreatedByUser(0l);
			partyUser.setCreatedTime(new Date());
			partyUser.setPartyId(party.getPartyId());
			partyUser.setUserId(user.getId());
			sess.beginTransaction();
			partyUser = (PartyUser)sess.merge(partyUser);
			sess.getTransaction().commit();
			System.out.println("生成帐号：" + user.getUsername() + ",用户：" + person.getName());
		}
		return true;
	}
	public static void main(String[] args){
		initApplicationContext();
		getSession();
//		addPGPinyin();
		//创建乡级操作员
		Long[] gene = {9l,10l,11l,12l,14l,15l,16l,17l,18l,19l,20l,21l,22l,23l,24l,25l,26l,27l,1181l,1182l,1183l,1184l,1185l,1186l,1187l,1188l,1189l,1190l,1191l,1192l,1193l,1194l,1195l,1196l,1197l,1198l,1199l,1200l,1201l,1202l,1203l,1204l,1205l,1206l,1207l,1208l,1209l,1210l,1211l,1212l,1213l,1214l,1215l,1216l,1217l,1218l,1219l,1220l,1221l,1222l,1223l,1224l,1225l,1226l,1227l,1228l,1229l};
//		Long[] gene = {8l};
		for(int i=0;i<gene.length;i++){
			//创建乡级用户
			//createUserFormPartyGroup(gene[i],1l,false);
			
			//创建村级用户
			String sql = " SELECT a.*                                                                          "
						+" FROM party_group a                                                                  "
						+" INNER JOIN party_relationship b                                                     "
						+" ON a.party_id=b.party_id_to AND b.party_relationship_type_id=1 AND b.party_id_from=" + gene[i];
			List pgs = sess.createSQLQuery(sql).addEntity("a",PartyGroup.class).list();
			if(pgs!=null && pgs.size()>0){
				for(int j=0;j<pgs.size();j++){
					PartyGroup pg = (PartyGroup)pgs.get(j);
					createUserFormPartyGroup(pg.getPartyId(),4l,true);
				}
			}
		}
		closeSession();
		System.out.println("Game Over");
	}
	
}
