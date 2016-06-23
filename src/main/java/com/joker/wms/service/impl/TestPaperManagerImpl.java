package com.joker.wms.service.impl;

import com.joker.wms.dao.TestPaperDao;
import com.joker.wms.dao.TestQuestionDao;
import com.joker.wms.model.Examination;
import com.joker.wms.model.TestPaper;
import com.joker.wms.service.TestPaperManager;
import com.joker.wms.service.impl.GenericManagerImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Date;
import java.util.List;

import javax.jws.WebService;

@Service("testPaperManager")
@WebService(serviceName = "TestPaperService", endpointInterface = "com.joker.wms.service.TestPaperManager")
public class TestPaperManagerImpl extends GenericManagerImpl<TestPaper, Long> implements TestPaperManager {
    TestPaperDao testPaperDao;
    @Autowired
    TestQuestionDao testQuestionDao;
    
    @Autowired
    public TestPaperManagerImpl(TestPaperDao testPaperDao) {
        super(testPaperDao);
        this.testPaperDao = testPaperDao;
    }

	@Override
	public List getAnswerList(String answer_phone, String answer_id) {
		return testPaperDao.getAnswerList(answer_phone,answer_id);
	}

	@Override
	public List getNFTpByAnswerId(Long answererId) {
		return testPaperDao.getNFTpByAnswerId(answererId);
	}

	@Override
	public List generatePaper(TestPaper tp, int num) {
		//获取试题的总数量 这样好随机
		List questionids = testQuestionDao.getQuestionIds();
		Integer nums = questionids.size();
		//如果要选的试题数大于题库中的试题数则去全部返回
		if(num>=nums){
			testQuestionDao.savePaperQuestion(tp,"");
			return this.getAll();
		}else{
			SecureRandom random = new SecureRandom();
			String ids = "";
	    	for(int i=0;i<num;i++){
	    		int a = random.nextInt(questionids.size());
	    		BigInteger id = (BigInteger)questionids.get(a);
	    		questionids.remove(a);
	    		if(i==0){
	    			ids = id.toString();
	    		}else{
	    			ids += "," + id.toString();
	    		}
	    	}
			testQuestionDao.savePaperQuestion(tp,ids);
			return null;
		}
	}

	@Override
	public List getQuestionByPaperId(Long paperId) {
		return testQuestionDao.getQuestionByPaperId(paperId);
	}

	@Override
	public List getQOptions(Long paperId) {
		return testQuestionDao.getQOptions(paperId);
	}

	@Override
	public void updateAnswer(String pqid, String value) {
		testQuestionDao.updateAnswer(pqid,value);
	}

	@Override
	public void examinationCommit(Long nowExaminationId) {
		Examination e = testQuestionDao.getExamination(nowExaminationId);
		//更新分数
		testQuestionDao.examinationCommit(e.getPaperId());
		//跟新考试结束时间
		e.setEndTime(new Date());
		this.saveObject(e);
	}

	@Override
	public Examination getExamination(String nowExaminationId) {
		return testQuestionDao.getExamination(Long.valueOf(nowExaminationId));
	}

	@Override
	public List getTestPapersByAnswererId(Long answererId) {
		return testQuestionDao.getTestPapersByAnswererId(answererId);
	}
}