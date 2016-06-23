package com.joker.wms.service.impl;

import com.joker.wms.dao.RoleTypeDao;
import com.joker.wms.model.RoleType;
import com.joker.wms.service.RoleTypeManager;
import com.joker.wms.service.impl.GenericManagerImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import javax.jws.WebService;

@Service("roleTypeManager")
@WebService(serviceName = "RoleTypeService", endpointInterface = "com.joker.wms.service.RoleTypeManager")
public class RoleTypeManagerImpl extends GenericManagerImpl<RoleType, Long> implements RoleTypeManager {
    RoleTypeDao roleTypeDao;

    @Autowired
    public RoleTypeManagerImpl(RoleTypeDao roleTypeDao) {
        super(roleTypeDao);
        this.roleTypeDao = roleTypeDao;
    }
}