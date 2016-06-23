package com.joker.wms.webapp.action;

import com.opensymphony.xwork2.Preparable;
import com.joker.wms.service.TestPaperManager;
import com.joker.wms.util.MyDateUtil;
import com.joker.wms.dao.SearchException;
import com.joker.wms.model.Answerer;
import com.joker.wms.model.Examination;
import com.joker.wms.model.PaperQuestion;
import com.joker.wms.model.QuestionOption;
import com.joker.wms.model.TestPaper;
import com.joker.wms.webapp.action.BaseAction;

import java.security.SecureRandom;
import java.util.Date;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class TestPaperAction extends BaseAction implements Preparable {
    private TestPaperManager testPaperManager;
    private List testPapers;
    private TestPaper testPaper;
    private Long paperId;
    private String query;

    public void setTestPaperManager(TestPaperManager testPaperManager) {
        this.testPaperManager = testPaperManager;
    }

    public List getTestPapers() {
        return testPapers;
    }

    /**
     * Grab the entity from the database before populating with request parameters
     */
    public void prepare() {
        if (getRequest().getMethod().equalsIgnoreCase("post")) {
            // prevent failures on new
            String testPaperId = getRequest().getParameter("testPaper.paperId");
            if (testPaperId != null && !testPaperId.equals("")) {
                testPaper = testPaperManager.get(new Long(testPaperId));
            }
        }
    }

    public void setQ(String q) {
        this.query = q;
    }

    public String list() {
        try {
        	Map condition = new HashMap();
            testPapers = testPaperManager.search(condition, TestPaper.class, getPage());
        } catch (SearchException se) {
            addActionError(se.getMessage());
            testPapers = testPaperManager.getAll(getPage());
        }
        if(query != null){
        	getRequest().setAttribute("showForm", "showData");
        }
        return SUCCESS;
    }

    public void setPaperId(Long paperId) {
        this.paperId = paperId;
    }

    public TestPaper getTestPaper() {
        return testPaper;
    }

    public void setTestPaper(TestPaper testPaper) {
        this.testPaper = testPaper;
    }

    public String delete() {
        testPaperManager.remove(testPaper.getPaperId());
        saveMessage(getText("testPaper.deleted"));

        return SUCCESS;
    }

    public String edit() {
        if (paperId != null) {
            testPaper = testPaperManager.get(paperId);
        } else {
            testPaper = new TestPaper();
        }

        return SUCCESS;
    }

    public String save() throws Exception {
        if (cancel != null) {
            super.setJsonResult("取消保存");
            return "jsonResult";
        }

        if (delete != null) {
            testPaperManager.remove(testPaper.getPaperId());
        	super.setJsonResult("删除成功");
            return "jsonResult";
        }

        boolean isNew = (testPaper.getPaperId() == null);

        testPaper = testPaperManager.save(testPaper);

        String key = (isNew) ? "testPaper.added" : "testPaper.updated";
        saveMessage(getText(key));

        super.setJsonResult("保存成功");
        return "jsonResult";
    }
    public String examination(){
    	return SUCCESS;
    }
    public String examinationpaper(){
    	Long answerId = (Long)getRequest().getSession().getAttribute("nowanswererid");
    	//如果有未完成的考试则将未完成的考试试卷提出来，如果没有则新生成考试试卷
    	TestPaper tp = null;
    	List tpList = testPaperManager.getNFTpByAnswerId(answerId);
    	if(tpList!=null && tpList.size()>0){
    		Object[] obs = (Object[])tpList.get(0);
    		tp = (TestPaper)obs[0];
    		//获取nowExaminationId并放入session
    		Examination examination = (Examination)obs[1];
    		getRequest().getSession().setAttribute("nowExaminationId", examination.getExaminationId());
    	}else{
    		tp = new TestPaper();
    		//保存test_paper
    		tp.setGenerateTime(new Date());
    		tp.setMemo("自动生成试卷");
    		tp.setPaperName("党识考试"+MyDateUtil.getCurrDate("yyyyMMdd"));
    		tp.setPaperType("自动");
    		tp.setPurposeType("");
    		tp = testPaperManager.save(tp);
    		//保存examination
    		Examination examination = new Examination();
    		examination.setAnswererId(answerId);
    		examination.setPaperId(tp.getPaperId());
    		examination.setStartTime(new Date());
    		examination = (Examination)testPaperManager.saveObject(examination);
    		getRequest().getSession().setAttribute("nowExaminationId", examination.getExaminationId());
    		//生成试卷明细
    		testPaperManager.generatePaper(tp,10);
    	}
    	//试题不包含选项
    	List testQuestions = testPaperManager.getQuestionByPaperId(tp.getPaperId());
    	List questionOptons = testPaperManager.getQOptions(tp.getPaperId());
    	Map<Long,String> rOptions = new HashMap<Long,String>();
    	if(questionOptons!=null&&questionOptons.size()>0){
    		for(int i=0;i<questionOptons.size();i++){
    			Object[] obs = (Object[])questionOptons.get(i);
    			PaperQuestion pq = (PaperQuestion)obs[0];
    			Long pqid = pq.getPaperQuestionId();
    			QuestionOption qo = (QuestionOption)obs[1];
    			if(rOptions.containsKey(qo.getQuestionId())){
    				rOptions.put(qo.getQuestionId(), rOptions.get(qo.getQuestionId())+"<li class=\"list-group-item\"><input type=\"radio\" onchange='updateAnswer(this)' name=\""+pqid+"\" value=\""+qo.getTitle()+"\" "+(qo.getTitle().equals(pq.getAnswer())?"checked":"")+">  "+qo.getTitle()+"  :  "+qo.getContent()+"</li>");
    			}else{
    				rOptions.put(qo.getQuestionId(), "<li class=\"list-group-item\"><input type=\"radio\" onchange='updateAnswer(this)' name=\""+pqid+"\" value=\""+qo.getTitle()+"\" "+(qo.getTitle().equals(pq.getAnswer())?"checked":"")+">  "+qo.getTitle()+"  :  "+qo.getContent()+"</li>");
    			}
    		}
    	}
    	getRequest().setAttribute("testQuestions", testQuestions);
    	getRequest().setAttribute("rOptions", rOptions);
    	return SUCCESS;
    }
    public String examinationSaveAnswer(){
    	String pqid = getRequest().getParameter("pqid");
    	String value = getRequest().getParameter("value");
    	testPaperManager.updateAnswer(pqid,value);
    	getRequest().setAttribute("jsonResult", "{result:true}");
    	return SUCCESS;
    }
    public String examinationCommit(){
    	//session中获取nowExaminationId
    	Object nowExaminationId = getRequest().getSession().getAttribute("nowExaminationId");
    	if(nowExaminationId!=null){
    		//删除session中的当前考试id
    		testPaperManager.examinationCommit((Long)nowExaminationId);
    		getRequest().getSession().removeAttribute("nowExaminationId");
    	}
    	//跳转到考试结果页面，包括得分正确答案等
    	getRequest().setAttribute("nowExaminationId", (Long)nowExaminationId);
    	return SUCCESS;
    }
    public String examinationResult(){
    	String nowExaminationId = getRequest().getParameter("nowExaminationId");
    	if(nowExaminationId==null||nowExaminationId.equals("")){
    		Object o = (String)getRequest().getAttribute("nowExaminationId");
    		if(o!=null){
    			nowExaminationId = (String)o;
    		}else{
    			return ERROR;
    		}
    	}
    	Examination e = testPaperManager.getExamination(nowExaminationId);
    	List testQuestions = testPaperManager.getQuestionByPaperId(e.getPaperId());
    	List questionOptons = testPaperManager.getQOptions(e.getPaperId());
    	Map<Long,String> rOptions = new HashMap<Long,String>();
    	if(questionOptons!=null&&questionOptons.size()>0){
    		for(int i=0;i<questionOptons.size();i++){
    			Object[] obs = (Object[])questionOptons.get(i);
    			PaperQuestion pq = (PaperQuestion)obs[0];
    			Long pqid = pq.getPaperQuestionId();
    			QuestionOption qo = (QuestionOption)obs[1];
    			if(rOptions.containsKey(qo.getQuestionId())){
    				rOptions.put(qo.getQuestionId(), rOptions.get(qo.getQuestionId())+"<li class=\"list-group-item\"><input type=\"radio\" onchange='updateAnswer(this)' name=\""+pqid+"\" value=\""+qo.getTitle()+"\" "+(qo.getTitle().equals(pq.getAnswer())?"checked":"")+">  "+qo.getTitle()+"  :  "+qo.getContent()+"</li>");
    			}else{
    				rOptions.put(qo.getQuestionId(), "<li class=\"list-group-item\"><input type=\"radio\" onchange='updateAnswer(this)' name=\""+pqid+"\" value=\""+qo.getTitle()+"\" "+(qo.getTitle().equals(pq.getAnswer())?"checked":"")+">  "+qo.getTitle()+"  :  "+qo.getContent()+"</li>");
    			}
    		}
    	}
    	getRequest().setAttribute("testQuestions", testQuestions);
    	getRequest().setAttribute("rOptions", rOptions);
    	return SUCCESS;
    }
    public String examinationResults(){
    	String answer_phone = getRequest().getParameter("answer_phone");
    	String answer_name = getRequest().getParameter("answer_name");
    	String answer_id = getRequest().getParameter("answer_id");
    	String answer_code = getRequest().getParameter("answer_code");
    	String REGEX_MOBILE = "^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$";
    	if(answer_phone==null||answer_phone.equals("")){
    		answer_phone = (String)getRequest().getSession().getAttribute("answer_phone");
    	}
    	//验证手机号
    	if(answer_phone==null || !Pattern.matches(REGEX_MOBILE, answer_phone)){
    		return ERROR;
    	}
    	//放入session
    	getRequest().getSession().setAttribute("answer_phone", answer_phone);
    	//判断手机号和系统的关联
    	//关联上的一种情况关联不上另一种情况
    	
    	Answerer answerer = null;
    	//检查回答者是否存在
    	List al = testPaperManager.getAnswerList(answer_phone,answer_id);
    	boolean isNew = true;
    	if(al!=null && al.size()>0){
    		//这里有风险，如果原来有个人电话换了，被另外一个人使用，这里会混乱
    		answerer = (Answerer)al.get(0);
    		isNew = false;
    	}else{
    		answerer = new Answerer();
    	}
    	if(answer_id!=null && !"".equals(answer_id)){
    		answerer.setAnswerIdentifyId(answer_id);
    	}
		if(answer_phone!=null && !"".equals(answer_phone)){
			answerer.setAnswerPhone(answer_phone);
		}
		if(answer_name!=null && !"".equals(answer_name)){
			answerer.setAnswerPerson(answer_name);
		}
    	answerer = (Answerer)testPaperManager.saveObject(answerer);
    	getRequest().getSession().setAttribute("nowanswererid", answerer.getAnswererId());
    	if(!isNew){
    		List testPapers = testPaperManager.getTestPapersByAnswererId(answerer.getAnswererId());
    		getRequest().setAttribute("testPapers", testPapers);
    	}
    	return SUCCESS;
    }
}