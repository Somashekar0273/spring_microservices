package com.spring.microservices;

import com.spring.microservices.dao.ProductDao;
import com.spring.microservices.entity.Product;

public class Utilities {
	
	private Utilities() {
		
	}
	
	public static Product getProductFromDao(ProductDao productDao) {
		Product product = new Product();
		product.setCost(productDao.getCost());
		product.setId(productDao.getId());
		product.setName(productDao.getName());
		product.setProductCode(productDao.getProductCode());
		return product;
	}
	
	public static ProductDao getDaoFromProduct(Product product) {
		ProductDao productDao = new ProductDao();
		productDao.setCost(product.getCost());
		productDao.setId(product.getId());
		productDao.setName(product.getName());
		productDao.setProductCode(product.getProductCode());
		return productDao;
	}

}
