package com.joker.wms.dao;

import java.util.List;

import com.joker.wms.dao.GenericDao;
import com.joker.wms.model.TestPaper;

/**
 * An interface that provides a data management interface to the TestPaper table.
 */
public interface TestPaperDao extends GenericDao<TestPaper, Long> {

	List getAnswerList(String answer_phone, String answer_id);

	List getNFTpByAnswerId(Long answererId);

}