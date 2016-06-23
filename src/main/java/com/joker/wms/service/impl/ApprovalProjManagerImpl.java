package com.joker.wms.service.impl;

import com.joker.wms.dao.ApprovalProjDao;
import com.joker.wms.model.ApprovalProj;
import com.joker.wms.service.ApprovalProjManager;
import com.joker.wms.service.impl.GenericManagerImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import javax.jws.WebService;

@Service("approvalProjManager")
@WebService(serviceName = "ApprovalProjService", endpointInterface = "com.joker.wms.service.ApprovalProjManager")
public class ApprovalProjManagerImpl extends GenericManagerImpl<ApprovalProj, Long> implements ApprovalProjManager {
    ApprovalProjDao approvalProjDao;

    @Autowired
    public ApprovalProjManagerImpl(ApprovalProjDao approvalProjDao) {
        super(approvalProjDao);
        this.approvalProjDao = approvalProjDao;
    }
}