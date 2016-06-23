package com.joker.wms.service.impl;

import com.joker.wms.dao.ProductDao;
import com.joker.wms.model.Product;
import com.joker.wms.service.ProductManager;
import com.joker.wms.service.impl.GenericManagerImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import javax.jws.WebService;

@Service("productManager")
@WebService(serviceName = "ProductService", endpointInterface = "com.joker.wms.service.ProductManager")
public class ProductManagerImpl extends GenericManagerImpl<Product, Long> implements ProductManager {
    ProductDao productDao;

    @Autowired
    public ProductManagerImpl(ProductDao productDao) {
        super(productDao);
        this.productDao = productDao;
    }
}