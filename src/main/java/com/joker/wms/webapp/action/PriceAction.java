package com.joker.wms.webapp.action;

import com.opensymphony.xwork2.Preparable;
import com.joker.wms.service.PartyGroupManager;
import com.joker.wms.service.PriceManager;
import com.joker.wms.util.MyDateUtil;
import com.joker.wms.util.PinYinUtil;
import com.joker.wms.dao.SearchException;
import com.joker.wms.model.PartyGroup;
import com.joker.wms.model.Price;
import com.joker.wms.webapp.action.BaseAction;

import java.util.Date;
import java.util.List;

import net.sourceforge.pinyin4j.PinyinHelper;

public class PriceAction extends BaseAction implements Preparable {
    private PriceManager priceManager;
    private List prices;
    private Price price;
    private Long priceId;
    private String query;
    private String lastdate;
    private String groupId;
    private PartyGroupManager partyGroupManager;
    private String productName;
    private String priceDate;

    public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getPriceDate() {
		return priceDate;
	}

	public void setPriceDate(String priceDate) {
		this.priceDate = priceDate;
	}

	public void setPartyGroupManager(PartyGroupManager partyGroupManager) {
		this.partyGroupManager = partyGroupManager;
	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public String getLastdate() {
		return lastdate;
	}

	public void setLastdate(String lastdate) {
		this.lastdate = lastdate;
	}

	public void setPriceManager(PriceManager priceManager) {
        this.priceManager = priceManager;
    }

    public List getPrices() {
        return prices;
    }

    /**
     * Grab the entity from the database before populating with request parameters
     */
    public void prepare() {
        if (getRequest().getMethod().equalsIgnoreCase("post")) {
            // prevent failures on new
            String priceId = getRequest().getParameter("price.priceId");
            if (priceId != null && !priceId.equals("")) {
                price = priceManager.get(new Long(priceId));
            }
        }
    }

    public void setQ(String q) {
        this.query = q;
    }

    public String list() {
        try {
            prices = priceManager.search(query, Price.class, getPage());
        } catch (SearchException se) {
            addActionError(se.getMessage());
            prices = priceManager.getAll(getPage());
        }
        if(query != null){
        	getRequest().setAttribute("showForm", "showData");
        }
        return SUCCESS;
    }

    public void setPriceId(Long priceId) {
        this.priceId = priceId;
    }

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    public String delete() {
        priceManager.remove(price.getPriceId());
        saveMessage(getText("price.deleted"));

        return SUCCESS;
    }

    public String edit() {
        if (priceId != null) {
            price = priceManager.get(priceId);
        } else {
            price = new Price();
        }
        if(productName!=null && priceDate!=null && !"".equals(priceDate) && !"".equals(productName)){
        	getRequest().setAttribute("isdaypriceedit", "yes");
        }
        return SUCCESS;
    }

    public String save() throws Exception {
        if (cancel != null) {
            super.setJsonResult("取消保存");
            return "jsonResult";
        }

        if (delete != null) {
            priceManager.remove(price.getPriceId());
        	super.setJsonResult("删除成功");
            return "jsonResult";
        }

        boolean isNew = (price.getPriceId() == null);
        if(isNew){
        	price.setCreatedByUser(getCurrentUser().getId());
        	price.setCreatedTime(new Date());
        }else{
        	price.setLastUpdatedByUser(getCurrentUser().getId());
        	price.setLastUpdatedTime(new Date());
        }
        //按日期更新价格列表
        if(getRequest().getParameter("isdaypriceedit")!=null && getRequest().getParameter("isdaypriceedit").toString().equals("yes")){
        	//获取产品的日期价格
        	//Price dayPrice = priceManager.getDayPrice(price.getProductId().toString(), priceDate, groupId);
        	//当前价格为日价格
        	if(price.getPriceType()!=null && price.getPriceType().equals("2")){
        		
        	}else if(price.getPriceType()!=null && price.getPriceType().equals("1")){//当前价格为默认价格的话
        		Price dayPrice = priceManager.getDayPrice(price.getProductId().toString(), priceDate, groupId);
        		//修改价格不等于默认价格则添加日价格
        		if(!price.getPrice().equals(dayPrice.getPrice())){
        			Price newDayPrice = new Price();
        			newDayPrice.setCreatedByUser(getCurrentUser().getId());
        			newDayPrice.setCreatedTime(new Date());
        			newDayPrice.setFromDate(MyDateUtil.getDateFromStr(priceDate));
        			newDayPrice.setPartyId(Long.valueOf(groupId));
        			newDayPrice.setPrice(price.getPrice());
        			newDayPrice.setProductId(price.getProductId());
        			newDayPrice.setPriceType("2");
        			price = newDayPrice;
        		}
        	}
        	
        }
        priceManager.save(price);

        String key = (isNew) ? "price.added" : "price.updated";
        saveMessage(getText(key));

        super.setJsonResult("保存成功");
        return "jsonResult";
    }
    public String pricesetlist(){
    	if(groupId!=null){
    		getRequest().setAttribute("showData", "showData");
    	}
    	List<PartyGroup> pgl = super.getRelationPartyGroup();
    	List<PartyGroup> customerList = partyGroupManager.getGroupCustomer(pgl);
    	String pgoptions = "";
    	PartyGroup firstpg = null;
    	if(customerList!=null && customerList.size()>0){
    		if(firstpg == null){
    			firstpg = customerList.get(0);
    		}
    		for(int i=0; i<customerList.size(); i++){
    			if(customerList.get(i).getPartyId().toString().equals(groupId)){
    				pgoptions += "<option value='"+ customerList.get(i).getPartyId() +"' selected='selected'>" + customerList.get(i).getGroupName() + "["+ customerList.get(i).getPinyinName() +"]</option>";
    			}else{
    				pgoptions += "<option value='"+ customerList.get(i).getPartyId() +"'>" + customerList.get(i).getGroupName() + "["+ customerList.get(i).getPinyinName() +"]</option>";
    			}
			}
    	}
    	if(pgl!=null && pgl.size()>0){
    		if(firstpg == null){
    			firstpg = pgl.get(0);
    		}
    		for(int i=0; i<pgl.size(); i++){
    			if(pgl.get(i).getPartyId().toString().equals(groupId)){
    				pgoptions += "<option value='"+ pgl.get(i).getPartyId() +"' selected='selected'>" + pgl.get(i).getGroupName() + "["+ pgl.get(i).getPinyinName() +"]</option>";
    			}else{
    				pgoptions += "<option value='"+ pgl.get(i).getPartyId() +"'>" + pgl.get(i).getGroupName() + "["+ pgl.get(i).getPinyinName() +"]</option>";
    			}
			}
    	}
    	if(lastdate==null || lastdate.equals("")){
    		lastdate = MyDateUtil.getCurrDate("yyyy-MM-dd");
    	}
    	List dateList = priceManager.getDateList(lastdate);
    	List productPriceList = priceManager.getProductPriceList(groupId,lastdate);
    	
    	getRequest().setAttribute("productPriceList", productPriceList);
    	getRequest().setAttribute("dateList", dateList);
    	getRequest().setAttribute("pgoptions", pgoptions);
    	
    	return SUCCESS;
    }
}