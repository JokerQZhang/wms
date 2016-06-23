package com.joker.wms.service.impl;

import com.joker.wms.dao.TbProvideDao;
import com.joker.wms.model.TbProvide;
import com.joker.wms.service.TbProvideManager;
import com.joker.wms.service.impl.GenericManagerImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.jws.WebService;

@Service("tbProvideManager")
@WebService(serviceName = "TbProvideService", endpointInterface = "com.joker.wms.service.TbProvideManager")
public class TbProvideManagerImpl extends GenericManagerImpl<TbProvide, Long> implements TbProvideManager {
    TbProvideDao tbProvideDao;

    @Autowired
    public TbProvideManagerImpl(TbProvideDao tbProvideDao) {
        super(tbProvideDao);
        this.tbProvideDao = tbProvideDao;
    }

	@Override
	public boolean getProvideNameExists(String provideName) {
		Map condition = new HashMap();
		condition.put("provideName", provideName);
		List provideList = tbProvideDao.searchByCondition(condition);
		if(provideList!=null && provideList.size()>0){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * 根据已有的tb_provide
	 * 自动生成tb_provide_dtl
	 */
	@Override
	public boolean saveProvideDtl(TbProvide tbProvide, String yfTypeId) {
		if(tbProvide!=null && tbProvide.getProvideId()!=null){
			return tbProvideDao.saveProvideDtl(tbProvide, yfTypeId);
		}else{
			return false;
		}
	}
	/**
	 * 获取发放的明细金额的总和，然后更新总表的总金额
	 */
	@Override
	public BigDecimal getMoneySum(Long privideId) {
		List moneysum = tbProvideDao.getSumFromDtl(privideId);
		if(moneysum!=null && moneysum.size()>0){
			BigDecimal result = (BigDecimal)moneysum.get(0);
			return result;
		}else{
			return new BigDecimal(0);
		}
	}

	@Override
	public boolean removeDtl(Long privideId) {
		if(privideId!=null){
			return tbProvideDao.removeDtl(privideId);
		}else{
			return false;
		}
	}

	@Override
	public boolean sendMoneyDtl(TbProvide tbProvide) {
		return tbProvideDao.sendMoneyDtl(tbProvide);
	}
}