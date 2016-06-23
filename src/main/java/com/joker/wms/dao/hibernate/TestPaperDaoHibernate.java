package com.joker.wms.dao.hibernate;

import java.util.List;
import java.util.Map;

import com.joker.wms.model.Answerer;
import com.joker.wms.model.Examination;
import com.joker.wms.model.TestPaper;
import com.joker.wms.dao.TestPaperDao;
import com.joker.wms.dao.hibernate.GenericDaoHibernate;

import org.springframework.stereotype.Repository;

@Repository("testPaperDao")
public class TestPaperDaoHibernate extends GenericDaoHibernate<TestPaper, Long> implements TestPaperDao {

    public TestPaperDaoHibernate() {
        super(TestPaper.class);
    }
    
    @Override
    public String makeSqlForCondition(Map condition){
		String sql = "";
		if(condition!=null && !condition.isEmpty()){
    		
    	}
		return sql;
	}

	@Override
	public List getAnswerList(String answer_phone, String answer_id) {
		String sql = "SELECT * FROM answerer WHERE answer_phone='"+answer_phone+"' OR answer_identify_id='"+answer_id+"'";
		return super.findBySql(sql).addEntity(Answerer.class).list();
	}

	@Override
	public List getNFTpByAnswerId(Long answererId) {
		String sql = " SELECT {a.*},{b.*}            "
					+" FROM test_paper a             "
					+" INNER JOIN examination b      "
					+" ON a.paper_id=b.paper_id      "
					+" INNER JOIN answerer c         "
					+" ON b.answerer_id=c.answerer_id"
					+" WHERE c.answerer_id="+answererId + " AND b.end_time IS NULL";
		return super.findBySql(sql).addEntity("a",TestPaper.class).addEntity("b",Examination.class).list();
	}
}
