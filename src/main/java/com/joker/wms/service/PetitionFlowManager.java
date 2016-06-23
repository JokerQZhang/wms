package com.joker.wms.service;

import com.joker.wms.service.GenericManager;
import com.joker.wms.model.PetitionFlow;

import java.util.List;
import javax.jws.WebService;

@WebService
public interface PetitionFlowManager extends GenericManager<PetitionFlow, Long> {
    public PetitionFlow getNowPetitionFlow(Long petitionId);
    public List getAllPetitionFlow(Long petitionId);
}