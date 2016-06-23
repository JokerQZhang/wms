package com.joker.wms.webapp.action;

import com.opensymphony.xwork2.Preparable;
import com.joker.wms.service.PriceManager;
import com.joker.wms.service.ProductManager;
import com.joker.wms.util.PinYinUtil;
import com.joker.wms.dao.SearchException;
import com.joker.wms.model.Price;
import com.joker.wms.model.Product;
import com.joker.wms.webapp.action.BaseAction;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductAction extends BaseAction implements Preparable {
    private ProductManager productManager;
    private List products;
    private Product product;
    private Long productId;
    private String query;
    private String price;
    private PriceManager priceManager;

    public void setPriceManager(PriceManager priceManager) {
		this.priceManager = priceManager;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public void setProductManager(ProductManager productManager) {
        this.productManager = productManager;
    }

    public List getProducts() {
        return products;
    }

    /**
     * Grab the entity from the database before populating with request parameters
     */
    public void prepare() {
        if (getRequest().getMethod().equalsIgnoreCase("post")) {
            // prevent failures on new
            String productId = getRequest().getParameter("product.productId");
            if (productId != null && !productId.equals("")) {
                product = productManager.get(new Long(productId));
            }
        }
    }

    public void setQ(String q) {
        this.query = q;
    }

    public String list() {
        try {
            products = productManager.search(query, Product.class, getPage());
        } catch (SearchException se) {
            addActionError(se.getMessage());
            products = productManager.getAll(getPage());
        }
        if(query != null){
        	getRequest().setAttribute("showForm", "showData");
        }
        return SUCCESS;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String delete() {
        productManager.remove(product.getProductId());
        saveMessage(getText("product.deleted"));

        return SUCCESS;
    }

    public String edit() {
        if (productId != null) {
            product = productManager.get(productId);
        } else {
            product = new Product();
        }
        String uomselector = super.getUomSelector(1l, product.getStandUomId());
        getRequest().setAttribute("uomselector", uomselector);
        Map condition = new HashMap();
    	condition.put("productId", product.getProductId());
    	condition.put("priceType", "1");
    	List priceList = priceManager.searchByCondition(condition, null);
    	if(priceList!=null && priceList.size()>0){
    		Price priceobj = (Price)priceList.get(0);
    		price = priceobj.getPrice().toString();
    	}
        return SUCCESS;
    }

    public String save() throws Exception {
        if (cancel != null) {
            super.setJsonResult("取消保存");
            return "jsonResult";
        }

        if (delete != null) {
            productManager.remove(product.getProductId());
        	super.setJsonResult("删除成功");
            return "jsonResult";
        }

        boolean isNew = (product.getProductId() == null);
        if(getRequest().getParameter("product.pinyinName")==null || "".equals(getRequest().getParameter("product.pinyinName"))){
        	product.setPinyinName(PinYinUtil.getPinYinHeadChar(product.getProductName()));
        }
        product = productManager.save(product);
        
        Map condition = new HashMap();
    	condition.put("productId", product.getProductId());
    	condition.put("priceType", "1");
    	List priceList = priceManager.searchByCondition(condition, null);
    	
        if(isNew || (priceList==null || priceList.size()==0)){
        	if(price!=null && !price.equals("")){
        		Price priceobj = new Price();
        		priceobj.setCreatedByUser(super.getCurrentUser().getId());
        		priceobj.setCreatedTime(new Date());
        		priceobj.setPrice(new BigDecimal(price));
        		priceobj.setPriceType("1");//默认价格
        		priceobj.setProductId(product.getProductId());
        		priceManager.save(priceobj);
        	}
        }else{
        	//获取商品的默认价格然后进行修改
        	if(priceList!=null && priceList.size()>0){
        		Price priceobj = (Price)priceList.get(0);
        		priceobj.setLastUpdatedByUser(super.getCurrentUser().getId());
        		priceobj.setLastUpdatedTime(new Date());
        		priceobj.setPrice(new BigDecimal(price));
        		priceManager.save(priceobj);
        	}
        }
        String key = (isNew) ? "product.added" : "product.updated";
        saveMessage(getText(key));

        super.setJsonResult("保存成功");
        return "jsonResult";
    }
}