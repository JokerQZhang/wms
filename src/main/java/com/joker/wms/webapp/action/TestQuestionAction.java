package com.joker.wms.webapp.action;

import com.opensymphony.xwork2.Preparable;
import com.joker.wms.service.TestQuestionManager;
import com.joker.wms.dao.SearchException;
import com.joker.wms.model.QuestionOption;
import com.joker.wms.model.TestQuestion;
import com.joker.wms.webapp.action.BaseAction;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.core.Request;

public class TestQuestionAction extends BaseAction implements Preparable {
    private TestQuestionManager testQuestionManager;
    private List testQuestions;
    private TestQuestion testQuestion;
    private Long questionId;
    private String query;
    
    private String ranswer;
	private String optiona;
    private String optionb;
    private String optionc;
    private String optiond;
    private String oaid;
    private String obid;
    private String ocid;
    private String odid;
    

    public String getRanswer() {
		return ranswer;
	}

	public void setRanswer(String ranswer) {
		this.ranswer = ranswer;
	}
    public String getOptiona() {
		return optiona;
	}

	public void setOptiona(String optiona) {
		this.optiona = optiona;
	}

	public String getOptionb() {
		return optionb;
	}

	public void setOptionb(String optionb) {
		this.optionb = optionb;
	}

	public String getOptionc() {
		return optionc;
	}

	public void setOptionc(String optionc) {
		this.optionc = optionc;
	}

	public String getOptiond() {
		return optiond;
	}

	public void setOptiond(String optiond) {
		this.optiond = optiond;
	}

	public String getOaid() {
		return oaid;
	}

	public void setOaid(String oaid) {
		this.oaid = oaid;
	}

	public String getObid() {
		return obid;
	}

	public void setObid(String obid) {
		this.obid = obid;
	}

	public String getOcid() {
		return ocid;
	}

	public void setOcid(String ocid) {
		this.ocid = ocid;
	}

	public String getOdid() {
		return odid;
	}

	public void setOdid(String odid) {
		this.odid = odid;
	}

	public void setTestQuestionManager(TestQuestionManager testQuestionManager) {
        this.testQuestionManager = testQuestionManager;
    }

    public List getTestQuestions() {
        return testQuestions;
    }

    /**
     * Grab the entity from the database before populating with request parameters
     */
    public void prepare() {
        if (getRequest().getMethod().equalsIgnoreCase("post")) {
            // prevent failures on new
            String testQuestionId = getRequest().getParameter("testQuestion.questionId");
            if (testQuestionId != null && !testQuestionId.equals("")) {
                testQuestion = testQuestionManager.get(new Long(testQuestionId));
            }
        }
    }

    public void setQ(String q) {
        this.query = q;
    }

    public String list() {
        try {
        	Map condition = new HashMap();
            testQuestions = testQuestionManager.search(condition, TestQuestion.class, getPage());
        } catch (SearchException se) {
            addActionError(se.getMessage());
            testQuestions = testQuestionManager.getAll(getPage());
        }
        if(query != null){
        	getRequest().setAttribute("showForm", "showData");
        }
        return SUCCESS;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public TestQuestion getTestQuestion() {
        return testQuestion;
    }

    public void setTestQuestion(TestQuestion testQuestion) {
        this.testQuestion = testQuestion;
    }

    public String delete() {
        testQuestionManager.remove(testQuestion.getQuestionId());
        saveMessage(getText("testQuestion.deleted"));

        return SUCCESS;
    }

    public String edit() {
        if (questionId != null) {
            testQuestion = testQuestionManager.get(questionId);
            List<QuestionOption> options = testQuestionManager.getOl(questionId);
            if(options!=null&&options.size()>0){
            	for(QuestionOption o:options){
            		if(o.getTitle().equals("A")){
            			optiona = o.getContent();
            			oaid = o.getQuestionOptionId().toString();
            		}else if(o.getTitle().equals("B")){
            			optionb = o.getContent();
            			obid = o.getQuestionOptionId().toString();
            		}else if(o.getTitle().equals("C")){
            			optionc = o.getContent();
            			ocid = o.getQuestionOptionId().toString();
            		}else if(o.getTitle().equals("D")){
            			optiond = o.getContent();
            			odid = o.getQuestionOptionId().toString();
            		}
            	}
            }
            ranswer = testQuestion.getRightAnswer();
        } else {
            testQuestion = new TestQuestion();
        }
        String testType = getEnumerationSelector(16l,null);
        getRequest().setAttribute("testType", testType);
        return SUCCESS;
    }

    public String save() throws Exception {
        if (cancel != null) {
            super.setJsonResult("取消保存");
            return "jsonResult";
        }

        if (delete != null) {
            testQuestionManager.remove(testQuestion.getQuestionId());
        	super.setJsonResult("删除成功");
            return "jsonResult";
        }

        boolean isNew = (testQuestion.getQuestionId() == null);
        testQuestion.setRightAnswer(ranswer);
        if(isNew){
        	testQuestion.setCreateTime(new Date());
        	testQuestion.setCreateUse(super.getCurrentUser().getId());
        }else{
        	testQuestion.setModifyTime(new Date());
        	testQuestion.setModifyUser(super.getCurrentUser().getId());
        }
        testQuestion = testQuestionManager.save(testQuestion);
        QuestionOption a  = new QuestionOption();
        QuestionOption b  = new QuestionOption();
        QuestionOption c  = new QuestionOption();
        QuestionOption d  = new QuestionOption();
        if(oaid!=null&&!"".equals(oaid)){
        	a=testQuestionManager.getQueationOption(Long.valueOf(oaid));
        }else{
        	a.setTitle("A");
        	a.setQuestionId(testQuestion.getQuestionId());
        }
        if(obid!=null&&!"".equals(obid)){
        	b=testQuestionManager.getQueationOption(Long.valueOf(obid));
        }else{
        	b.setTitle("B");
        	b.setQuestionId(testQuestion.getQuestionId());
        }
        if(ocid!=null&&!"".equals(ocid)){
        	c=testQuestionManager.getQueationOption(Long.valueOf(ocid));
        }else{
        	c.setTitle("C");
        	c.setQuestionId(testQuestion.getQuestionId());
        }
        if(odid!=null&&!"".equals(odid)){
        	d=testQuestionManager.getQueationOption(Long.valueOf(odid));
        }else{
        	d.setTitle("D");
        	d.setQuestionId(testQuestion.getQuestionId());
        }
        a.setContent(optiona);
        b.setContent(optionb);
        c.setContent(optionc);
        d.setContent(optiond);
        List<QuestionOption> ol = new ArrayList<QuestionOption>();
        ol.add(a);
        ol.add(b);
        ol.add(c);
        ol.add(d);
        testQuestionManager.saveOptions(ol);
        String key = (isNew) ? "testQuestion.added" : "testQuestion.updated";
        saveMessage(getText(key));

        super.setJsonResult("保存成功");
        return "jsonResult";
    }
}