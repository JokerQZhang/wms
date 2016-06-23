package com.joker.wms.dao.hibernate;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.joker.wms.model.Price;
import com.joker.wms.model.Product;
import com.joker.wms.util.MyDateUtil;
import com.joker.wms.dao.PriceDao;
import com.joker.wms.dao.hibernate.GenericDaoHibernate;

import org.appfuse.util.DateUtil;
import org.hibernate.SQLQuery;
import org.springframework.stereotype.Repository;

@Repository("priceDao")
public class PriceDaoHibernate extends GenericDaoHibernate<Price, Long> implements PriceDao {

    public PriceDaoHibernate() {
        super(Price.class);
    }
    
    @Override
    public String makeSqlForCondition(Map condition){
    	String sql = "select * from price where 1=1";
    	if(condition!=null && !condition.isEmpty()){
    		if(condition.containsKey("productId")){
    			sql += " and product_id=" + condition.get("productId");
    		}
    		if(condition.containsKey("priceType")){
    			sql += " and price_type='" + condition.get("priceType") + "'";
    		}
    		if(condition.containsKey("priceDate")){
    			sql += " and from_date='" + condition.get("priceDate") + " 00:00:00'";
    		}
    		if(condition.containsKey("groupId")){
    			sql += " and party_id=" + condition.get("groupId") + "";
    		}
    	}
		return sql;
	}

	@Override
	public List getProductPriceList(String groupId, String lastdate,
			String priceType) {
		String sql = " SELECT {a.*},{b.*}          "
					+" FROM product a              "
					+" INNER JOIN price b          "
					+" ON a.product_id=b.product_id";
		sql += " WHERE 1=1 ";
		if(groupId!=null && "2".equals(priceType)){
			sql += " AND party_id=" + groupId;
		}
		if(priceType!=null && !"".equals(priceType)){
			sql += " AND price_type=" + priceType;
		}
		if(lastdate!=null && !"".equals(lastdate)){
			String firstdate = "";
			try {
				firstdate = MyDateUtil.dateSubDate(Calendar.DATE, lastdate, -6);
			} catch (Exception e) {
				e.printStackTrace();
			}
			sql += " AND from_date>='" + firstdate + "' AND from_date<='" + lastdate + "'";
			sql += " ORDER BY b.from_date ASC";
		}
		SQLQuery query = super.findBySql(sql);
		query.addEntity("a", Product.class);
		query.addEntity("b", Price.class);
		return query.list();
	}
}
