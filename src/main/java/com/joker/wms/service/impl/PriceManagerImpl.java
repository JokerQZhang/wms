package com.joker.wms.service.impl;

import com.joker.wms.dao.PriceDao;
import com.joker.wms.model.Price;
import com.joker.wms.model.Product;
import com.joker.wms.service.PriceManager;
import com.joker.wms.service.impl.GenericManagerImpl;
import com.joker.wms.util.MyDateUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.jws.WebService;

@Service("priceManager")
@WebService(serviceName = "PriceService", endpointInterface = "com.joker.wms.service.PriceManager")
public class PriceManagerImpl extends GenericManagerImpl<Price, Long> implements PriceManager {
    PriceDao priceDao;

    @Autowired
    public PriceManagerImpl(PriceDao priceDao) {
        super(priceDao);
        this.priceDao = priceDao;
    }

	@Override
	public List getProductPriceList(String groupId, String lastdate) {
		List dayPriceList = priceDao.getProductPriceList(groupId, lastdate, "2");
		List defaultPriceList = priceDao.getProductPriceList(null, null, "1");
		List dateList = getDateList(lastdate);
		List resultList = new ArrayList();

		if(defaultPriceList!=null && defaultPriceList.size()>0){
			for(int i=0; i<defaultPriceList.size(); i++){
				Object[] obs = (Object[])defaultPriceList.get(i);
				Product product = (Product)obs[0];
				Map p2p = new HashMap();
				List productDayPriceList = new ArrayList();
				Price defaultPrice = (Price)obs[1];
				//每个商品都得循环一遍dpricelist，从而获取全日制价格列表
				//日期从前往后顺序
				for(int j=dateList.size()-1; j>=0; j--){
					String date = (String)dateList.get(j);
					Price lprice = null;
					for(int k=0; k<dayPriceList.size(); k++){
						Object[] dobs = (Object[])dayPriceList.get(k);
						Product dproduct = (Product)dobs[0];
						Price dprice = (Price)dobs[1];
						if(product.getProductId() != dproduct.getProductId()){
							continue;
						}else{
							if(dprice.getFromDate()==null || !date.equals(MyDateUtil.getFormatedString("yyyy-MM-dd", dprice.getFromDate()))){
								continue;
							}
						}
						lprice = dprice;
					}
					if(lprice!=null){
						productDayPriceList.add(lprice);
					}else{
						productDayPriceList.add(defaultPrice);
					}
				}
				p2p.put(product, productDayPriceList);
				resultList.add(p2p);
			}
		}
		return resultList;
	}

	@Override
	public List getDateList(String lastdate) {
		List dateList = new ArrayList();
		if(lastdate!=null && !"".equals(lastdate)){
			try {
				dateList.add(0,lastdate);
				for(int i=1; i<7; i++){
					String newdate = MyDateUtil.dateSubDate(Calendar.DATE, lastdate, -i);
					dateList.add(i,MyDateUtil.getFormatedString("yyyy-MM-dd", MyDateUtil.getDateFromStr("yyyy-MM-dd hh:mm:ss", newdate)));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return dateList;
	}

	@Override
	public Price getDayPrice(String productId, String priceDate, String groupId) {
		Price result = null;
		Map condition = new HashMap();
		condition.put("productId", productId);
		condition.put("priceDate", priceDate);
		condition.put("groupId", groupId);
		condition.put("priceType", "2");
		List pricelist = super.searchByCondition(condition, null);
		//如果日期价格为空则取默认价格
		if(pricelist==null || pricelist.size()==0){
			condition.clear();
			condition.put("productId", productId);
			condition.put("priceType", "1");
			pricelist = super.searchByCondition(condition, null);
		}
		if(pricelist != null && pricelist.size() > 0){
			result = (Price)pricelist.get(0);
		}
		return result;
	}
}