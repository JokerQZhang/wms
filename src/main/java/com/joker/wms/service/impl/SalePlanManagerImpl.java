package com.joker.wms.service.impl;

import com.joker.wms.dao.SalePlanDao;
import com.joker.wms.dao.SalePlanDtlDao;
import com.joker.wms.model.Facility;
import com.joker.wms.model.SalePlan;
import com.joker.wms.model.SalePlanDtl;
import com.joker.wms.service.SalePlanManager;
import com.joker.wms.service.impl.GenericManagerImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import javax.jws.WebService;

@Service("salePlanManager")
@WebService(serviceName = "SalePlanService", endpointInterface = "com.joker.wms.service.SalePlanManager")
public class SalePlanManagerImpl extends GenericManagerImpl<SalePlan, Long> implements SalePlanManager {
    SalePlanDao salePlanDao;
    SalePlanDtlDao salePlanDtlDao;
    
    @Autowired
    public void setSalePlanDtlDao(SalePlanDtlDao salePlanDtlDao) {
		this.salePlanDtlDao = salePlanDtlDao;
	}

	@Autowired
    public SalePlanManagerImpl(SalePlanDao salePlanDao) {
        super(salePlanDao);
        this.salePlanDao = salePlanDao;
    }

	@Override
	public void saveNewDtl(SalePlan salePlan) {
		String facilityIdFrom = salePlan.getFacilityId().toString();
		List facilityInventory = salePlanDao.facilityInventory(salePlan.getFacilityId().toString(), null);
		if(facilityInventory!=null && facilityInventory.size()>0){
			for(int i=0; i<facilityInventory.size(); i++){
				Object[] pinventory = (Object[])facilityInventory.get(i);
				BigDecimal inventoryNum = null;
				if(pinventory[1] == null){
					inventoryNum = new BigDecimal(0l);
				}else{
					inventoryNum = new BigDecimal(pinventory[1].toString());
				}
				String productId = pinventory[0].toString();
				List customerFacilityList = salePlanDao.getCustomerFacilityList(salePlan.getFacilityId().toString());
				if(customerFacilityList!=null && customerFacilityList.size()>0){
					if(inventoryNum.compareTo(BigDecimal.valueOf(0l))==-1){
						inventoryNum = BigDecimal.valueOf(0l);
					}
					BigDecimal averageNum = inventoryNum.divide(BigDecimal.valueOf(customerFacilityList.size()));
					for(int j=0; j<customerFacilityList.size(); j++){
						Facility facility = (Facility)customerFacilityList.get(j);
						SalePlanDtl salePlanDtl = new SalePlanDtl();
						salePlanDtl.setCreatedByUser(salePlan.getCreatedByUser());
						salePlanDtl.setCreatedTime(salePlan.getCreatedTime());
						salePlanDtl.setFacilityIdFrom(salePlan.getFacilityId());
						salePlanDtl.setFacilityIdTo(facility.getFacilityId());
						salePlanDtl.setNum(averageNum);
						salePlanDtl.setProductId(Long.valueOf(productId));
						salePlanDtl.setSalePlanId(salePlan.getSalePlanId());
						salePlanDtl.setToSequenceId(Long.valueOf(j));
						salePlanDtlDao.save(salePlanDtl);
					}
				}
			}
		}
	}

	@Override
	public void saveNewShipMent(SalePlan salePlan) {
		salePlanDtlDao.saveShipmentByDtl(salePlan);
	}

	@Override
	public List facilityInventory(String facilityId, String productId) {
		return salePlanDao.facilityInventory(facilityId, productId);
	}

	@Override
	public void transactionFacility(SalePlan salePlan) {
		salePlanDao.transactionFacility(salePlan);
	}

	@Override
	public void updateShipDate(SalePlan salePlan) {
		salePlanDao.updateShipDate(salePlan);
	}
}