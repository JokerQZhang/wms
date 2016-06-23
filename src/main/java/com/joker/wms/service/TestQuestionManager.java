package com.joker.wms.service;

import com.joker.wms.service.GenericManager;
import com.joker.wms.model.QuestionOption;
import com.joker.wms.model.TestQuestion;

import java.util.List;

import javax.jws.WebService;

@WebService
public interface TestQuestionManager extends GenericManager<TestQuestion, Long> {
    public Boolean saveOptions(List<QuestionOption> ol);
    public List<QuestionOption> getOl(Long questionId);
    public QuestionOption getQueationOption(Long qoid);
}