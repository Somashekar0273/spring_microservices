package com.spring.microservices.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.spring.microservices.Utilities;
import com.spring.microservices.entity.Product;
import com.spring.microservices.repo.ProductRepository;


@Repository("productServiceDao")
public class ProductServiceDao {

	@Autowired
	private ProductRepository prodRepo;
	
	@Autowired
	private RestTemplate restTemplate; 
	
	public ProductDao getProductByCode(String code) {
		List<Product> listofProducts = prodRepo.findByProductCode(code);
		Product product = null;
		if (listofProducts.size() > 0) {
			product = listofProducts.get(0);
		}
		
		if (product != null) {
			
			return getProductDaoWithStatus(product);
		}
		return null;
	}
	
	public List<ProductDao> getAllProducts() {
		List<Product> listofProducts = prodRepo.findAll();
		List<ProductDao> listofProds = new ArrayList<>();
		for (Iterator<Product> iterator = listofProducts.iterator(); iterator.hasNext();) {
			Product product = (Product) iterator.next();
			listofProds.add(getProductDaoWithStatus(product));
		}
		return listofProds;
	}
	
	private ProductDao getProductDaoWithStatus(Product prod) {
		ProductDao dao = null;
		if (prod != null) {
			dao = Utilities.getDaoFromProduct(prod);
			String url = "http://eureka-service-inventory-client/api/inventory/"+prod.getProductCode();
			ResponseEntity<InventoryTemplate> responseEntity = restTemplate.getForEntity(url, InventoryTemplate.class);
			if (responseEntity.getStatusCode() == HttpStatus.OK) {
				dao.setStockStatus(responseEntity.getBody().getQnty() > 0);
			}
		}
		return dao;
	}
}
