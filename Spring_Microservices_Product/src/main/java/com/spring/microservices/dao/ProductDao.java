package com.spring.microservices.dao;

import lombok.Data;

@Data
public class ProductDao {

	private int id;
	
	private String productCode;
	
	private String name;
	
	private double cost;
	
	private boolean stockStatus;
}
