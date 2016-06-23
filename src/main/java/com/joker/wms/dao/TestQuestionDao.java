package com.joker.wms.dao;

import java.util.List;

import com.joker.wms.dao.GenericDao;
import com.joker.wms.model.Examination;
import com.joker.wms.model.QuestionOption;
import com.joker.wms.model.TestPaper;
import com.joker.wms.model.TestQuestion;

/**
 * An interface that provides a data management interface to the TestQuestion table.
 */
public interface TestQuestionDao extends GenericDao<TestQuestion, Long> {
	public List<QuestionOption> getOl(Long questionId);
	public QuestionOption getQueationOption(Long qoid);
	//获取中题目数
	public Integer getNums();
	//根据给定的试题ID创建paper_question，即题库和试卷的对应关系
	public void savePaperQuestion(TestPaper tp, String string);
	public List getQuestionIds();
	public List getQuestionByPaperId(Long paperId);
	public List getQOptions(Long paperId);
	public void updateAnswer(String pqid, String value);
	public void examinationCommit(Long paperId);
	public Examination getExamination(Long nowExaminationId);
	public List getTestPapersByAnswererId(Long answererId);
}