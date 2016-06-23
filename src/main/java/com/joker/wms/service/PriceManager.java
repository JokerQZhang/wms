package com.joker.wms.service;

import com.joker.wms.service.GenericManager;
import com.joker.wms.model.Price;

import java.util.List;
import javax.jws.WebService;

@WebService
public interface PriceManager extends GenericManager<Price, Long> {
    public List getProductPriceList(String groupId, String lastdate);
    public List getDateList(String lastdate);
    public Price getDayPrice(String productId, String priceDate, String groupId);
}