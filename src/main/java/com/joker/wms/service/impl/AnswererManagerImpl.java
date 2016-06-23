package com.joker.wms.service.impl;

import com.joker.wms.dao.AnswererDao;
import com.joker.wms.model.Answerer;
import com.joker.wms.service.AnswererManager;
import com.joker.wms.service.impl.GenericManagerImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import javax.jws.WebService;

@Service("answererManager")
@WebService(serviceName = "AnswererService", endpointInterface = "com.joker.wms.service.AnswererManager")
public class AnswererManagerImpl extends GenericManagerImpl<Answerer, Long> implements AnswererManager {
    AnswererDao answererDao;

    @Autowired
    public AnswererManagerImpl(AnswererDao answererDao) {
        super(answererDao);
        this.answererDao = answererDao;
    }
}