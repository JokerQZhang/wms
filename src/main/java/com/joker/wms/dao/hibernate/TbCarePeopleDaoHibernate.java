package com.joker.wms.dao.hibernate;

import java.util.List;
import java.util.Map;

import com.joker.wms.model.Enumeration;
import com.joker.wms.model.EnumerationType;
import com.joker.wms.model.TbCarePeople;
import com.joker.wms.model.TbPeopleCare;
import com.joker.wms.dao.TbCarePeopleDao;
import com.joker.wms.dao.hibernate.GenericDaoHibernate;

import org.springframework.stereotype.Repository;

@Repository("tbCarePeopleDao")
public class TbCarePeopleDaoHibernate extends GenericDaoHibernate<TbCarePeople, Long> implements TbCarePeopleDao {

    public TbCarePeopleDaoHibernate() {
        super(TbCarePeople.class);
    }
    
    @Override
    public String makeSqlForCondition(Map condition){
		String sql = "select * from tb_care_people";
		if(condition!=null && !condition.isEmpty()){
    		
    	}
		return sql;
	}
    
    /**
     * peopleId:人员的ID
     * 返回
     * obj[0]:TbCarePeople
     * obj[1]:TbPeopleCare
     * obj[2]:Enumeration
     * obj[3]:EnumerationType
     */
	@Override
	public List getYFType(Map condition) {
		String sql =" SELECT {a.*},{b.*},{c.*},{d.*}               "
					+" FROM tb_care_people a           "
					+" INNER JOIN tb_people_care b     "
					+" ON a.people_id=b.people_id      "
					+" INNER JOIN enumeration c        "
					+" ON b.enum_id=c.enum_id          "
					+" INNER JOIN enumeration_type d   "
					+" ON c.enum_type_id=d.enum_type_id"
					+" WHERE a.people_id= " + condition.get("peopleId");
		return super.findBySql(sql).addEntity("a",TbCarePeople.class).addEntity("b",TbPeopleCare.class).addEntity("c",Enumeration.class).addEntity("d",EnumerationType.class).list();
	}
    
}
