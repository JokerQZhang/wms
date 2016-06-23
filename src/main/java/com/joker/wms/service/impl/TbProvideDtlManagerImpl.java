package com.joker.wms.service.impl;

import com.joker.wms.dao.TbProvideDtlDao;
import com.joker.wms.model.TbProvideDtl;
import com.joker.wms.service.TbProvideDtlManager;
import com.joker.wms.service.impl.GenericManagerImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import javax.jws.WebService;

@Service("tbProvideDtlManager")
@WebService(serviceName = "TbProvideDtlService", endpointInterface = "com.joker.wms.service.TbProvideDtlManager")
public class TbProvideDtlManagerImpl extends GenericManagerImpl<TbProvideDtl, Long> implements TbProvideDtlManager {
    TbProvideDtlDao tbProvideDtlDao;

    @Autowired
    public TbProvideDtlManagerImpl(TbProvideDtlDao tbProvideDtlDao) {
        super(tbProvideDtlDao);
        this.tbProvideDtlDao = tbProvideDtlDao;
    }
}