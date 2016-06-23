package com.joker.wms.service;

import com.joker.wms.service.GenericManager;
import com.joker.wms.model.Product;

import java.util.List;
import javax.jws.WebService;

@WebService
public interface ProductManager extends GenericManager<Product, Long> {
    
}