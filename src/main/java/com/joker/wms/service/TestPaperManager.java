package com.joker.wms.service;

import com.joker.wms.service.GenericManager;
import com.joker.wms.model.Examination;
import com.joker.wms.model.TestPaper;

import java.util.List;

import javax.jws.WebService;

@WebService
public interface TestPaperManager extends GenericManager<TestPaper, Long> {

	List getAnswerList(String answer_phone, String answer_id);
	//某人未完成的考试列表
	List getNFTpByAnswerId(Long answererId);
	//随机生成一个试卷，包括考试人的，num是试卷中试题数量
	List generatePaper(TestPaper tp, int num);
	//获取试卷下的所有试题
	List getQuestionByPaperId(Long paperId);
	List getQOptions(Long paperId);
	void updateAnswer(String pqid, String value);
	void examinationCommit(Long nowExaminationId);
	Examination getExamination(String nowExaminationId);
	List getTestPapersByAnswererId(Long answererId);
}