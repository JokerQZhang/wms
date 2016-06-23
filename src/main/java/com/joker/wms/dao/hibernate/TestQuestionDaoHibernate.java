package com.joker.wms.dao.hibernate;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.joker.wms.model.Examination;
import com.joker.wms.model.PaperQuestion;
import com.joker.wms.model.QuestionOption;
import com.joker.wms.model.TestPaper;
import com.joker.wms.model.TestQuestion;
import com.joker.wms.util.MyDateUtil;
import com.joker.wms.dao.TestQuestionDao;
import com.joker.wms.dao.hibernate.GenericDaoHibernate;

import org.hibernate.SQLQuery;
import org.springframework.stereotype.Repository;

@Repository("testQuestionDao")
public class TestQuestionDaoHibernate extends GenericDaoHibernate<TestQuestion, Long> implements TestQuestionDao {

    public TestQuestionDaoHibernate() {
        super(TestQuestion.class);
    }
    
    @Override
    public String makeSqlForCondition(Map condition){
		String sql = "";
		if(condition!=null && !condition.isEmpty()){
    		
    	}
		return sql;
	}

	@Override
	public List<QuestionOption> getOl(Long questionId) {
		String sql = "select * from question_option where question_id="+questionId;
		SQLQuery q = super.findBySql(sql);
		return q.addEntity(QuestionOption.class).list();
	}

	@Override
	public QuestionOption getQueationOption(Long qoid) {
		String sql = "select * from question_option where question_option_id="+qoid;
		return (QuestionOption)super.findBySql(sql).addEntity(QuestionOption.class).uniqueResult();
	}

	@Override
	public Integer getNums() {
		String sql = "select count(1) from test_question";
		return (Integer)super.findBySql(sql).uniqueResult();
	}

	@Override
	public void savePaperQuestion(TestPaper tp, String questionIds) {
		String sql =" INSERT INTO paper_question(question_id,paper_id)"
					+" SELECT question_id,"+tp.getPaperId()
					+" FROM test_question                              "
					+" WHERE 1=1 ";
		if(questionIds!=null && !"".equals(questionIds)){
			sql +=  " AND question_id IN("+ questionIds +")";
		}
		super.executeSql(sql);
	}

	@Override
	public List getQuestionIds() {
		String sql = "SELECT question_id FROM test_question";
		return super.findBySql(sql).list();
	}

	@Override
	public List getQuestionByPaperId(Long paperId) {
		String sql = " SELECT {a.*},{b.*}            "
					+" FROM paper_question a         "
					+" INNER JOIN test_question b    "
					+" ON a.question_id=b.question_id"
					+" WHERE a.paper_id="+paperId;
		return super.findBySql(sql).addEntity("a",PaperQuestion.class).addEntity("b",TestQuestion.class).list();
	}

	@Override
	public List getQOptions(Long paperId) {
		String sql = " SELECT {a.*},{b.*}            "
					+" FROM paper_question a         "
					+" INNER JOIN question_option b  "
					+" ON a.question_id=b.question_id"
					+" WHERE a.paper_id="+paperId;
		sql += " ORDER BY b.question_id,b.title";
		return super.findBySql(sql).addEntity("a",PaperQuestion.class).addEntity("b",QuestionOption.class).list();
	}

	@Override
	public void updateAnswer(String pqid, String value) {
		String sql = "UPDATE paper_question SET answer='"+value+"',answer_time='"+MyDateUtil.getCurrDate("yyyy-MM-dd HH:mm:ss")+"' WHERE paper_question_id="+pqid;
		super.executeSql(sql);
	}

	@Override
	public void examinationCommit(Long paperId) {
		String sql = " SELECT a.paper_id                                                            "
					+"        ,SUM(CASE WHEN a.answer=b.right_answer THEN 1 ELSE 0 END)*100/COUNT(1) AS score"
					+" FROM paper_question a                                                        "
					+" LEFT JOIN test_question b                                                    "
					+" ON a.question_id=b.question_id                                               "
					+" WHERE a.paper_id=" + paperId
					+" GROUP BY a.paper_id                                                          ";
		
		Object[] obs = (Object[])super.findBySql(sql).uniqueResult();
		if(obs!=null && obs.length==2){
			BigDecimal score = (BigDecimal)obs[1];
			sql = "update test_paper set score=" + score + " where paper_id=" + paperId;
			super.executeSql(sql);
		}
	}

	@Override
	public Examination getExamination(Long nowExaminationId) {
		String sql = "SELECT * FROM examination WHERE examination_id="+nowExaminationId;
		return (Examination)super.findBySql(sql).addEntity(Examination.class).uniqueResult();
	}

	@Override
	public List getTestPapersByAnswererId(Long answererId) {
		String sql =" SELECT {a.*},{b.*}       "
					+" FROM test_paper a       "
					+" INNER JOIN examination b"
					+" ON a.paper_id=b.paper_id"
					+" WHERE b.answerer_id=" + answererId;
		return super.findBySql(sql).addEntity("a",TestPaper.class).addEntity("b",Examination.class).list();
	}
}
