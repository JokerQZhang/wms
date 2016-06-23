package com.joker.wms.webapp.action;

import com.opensymphony.xwork2.Preparable;
import com.joker.wms.service.AnswererManager;
import com.joker.wms.dao.SearchException;
import com.joker.wms.model.Answerer;
import com.joker.wms.webapp.action.BaseAction;

import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class AnswererAction extends BaseAction implements Preparable {
    private AnswererManager answererManager;
    private List answerers;
    private Answerer answerer;
    private Long answererId;
    private String query;

    public void setAnswererManager(AnswererManager answererManager) {
        this.answererManager = answererManager;
    }

    public List getAnswerers() {
        return answerers;
    }

    /**
     * Grab the entity from the database before populating with request parameters
     */
    public void prepare() {
        if (getRequest().getMethod().equalsIgnoreCase("post")) {
            // prevent failures on new
            String answererId = getRequest().getParameter("answerer.answererId");
            if (answererId != null && !answererId.equals("")) {
                answerer = answererManager.get(new Long(answererId));
            }
        }
    }

    public void setQ(String q) {
        this.query = q;
    }

    public String list() {
        try {
        	Map condition = new HashMap();
            answerers = answererManager.search(condition, Answerer.class, getPage());
        } catch (SearchException se) {
            addActionError(se.getMessage());
            answerers = answererManager.getAll(getPage());
        }
        if(query != null){
        	getRequest().setAttribute("showForm", "showData");
        }
        return SUCCESS;
    }

    public void setAnswererId(Long answererId) {
        this.answererId = answererId;
    }

    public Answerer getAnswerer() {
        return answerer;
    }

    public void setAnswerer(Answerer answerer) {
        this.answerer = answerer;
    }

    public String delete() {
        answererManager.remove(answerer.getAnswererId());
        saveMessage(getText("answerer.deleted"));

        return SUCCESS;
    }

    public String edit() {
        if (answererId != null) {
            answerer = answererManager.get(answererId);
        } else {
            answerer = new Answerer();
        }

        return SUCCESS;
    }

    public String save() throws Exception {
        if (cancel != null) {
            super.setJsonResult("取消保存");
            return "jsonResult";
        }

        if (delete != null) {
            answererManager.remove(answerer.getAnswererId());
        	super.setJsonResult("删除成功");
            return "jsonResult";
        }

        boolean isNew = (answerer.getAnswererId() == null);

        answerer = answererManager.save(answerer);

        String key = (isNew) ? "answerer.added" : "answerer.updated";
        saveMessage(getText(key));

        super.setJsonResult("保存成功");
        return "jsonResult";
    }
}