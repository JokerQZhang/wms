package com.joker.wms.service;

import com.joker.wms.service.GenericManager;
import com.joker.wms.model.Answerer;

import java.util.List;
import javax.jws.WebService;

@WebService
public interface AnswererManager extends GenericManager<Answerer, Long> {
    
}