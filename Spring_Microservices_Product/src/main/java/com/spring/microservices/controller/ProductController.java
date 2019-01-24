package com.spring.microservices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.microservices.dao.ProductDao;
import com.spring.microservices.service.ProductService;

@RestController
@RequestMapping(value="/api/product")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	private String message;
	
	@GetMapping(value="/welcome")
	public String welcome() {
		return message;
	}
	
	@GetMapping(value="/{code}", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ProductDao> getProductByCode(@PathVariable("code") String code) {
		ProductDao productByCode = productService.getProductByCode(code);
		return new ResponseEntity<ProductDao>(productByCode, HttpStatus.OK);
	}
	
	@GetMapping(produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ProductDao>> getAllProducts() {
		List<ProductDao> allProducts = productService.getAllProducts();
		return new ResponseEntity<List<ProductDao>>(allProducts, HttpStatus.OK);
	}
}
