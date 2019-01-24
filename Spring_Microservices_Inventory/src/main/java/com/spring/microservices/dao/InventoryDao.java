package com.spring.microservices.dao;

import lombok.Data;

@Data
public class InventoryDao {

	private int id;
	
	private String productCode;
	
	private int qnty;
}
