package com.spring.microservices.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.microservices.dao.ProductDao;
import com.spring.microservices.dao.ProductServiceDao;

@Service("productService")
public class ProductService {

	@Autowired
	private ProductServiceDao productServiceDao;
	
	
	public ProductDao getProductByCode(String code) {
		return productServiceDao.getProductByCode(code);
	}
	
	public List<ProductDao> getAllProducts() {
		return productServiceDao.getAllProducts();
	}
}
