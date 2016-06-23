package com.joker.wms.service;

import com.joker.wms.service.GenericManager;
import com.joker.wms.model.ApprovalProj;

import java.util.List;
import javax.jws.WebService;

@WebService
public interface ApprovalProjManager extends GenericManager<ApprovalProj, Long> {
    
}