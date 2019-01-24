package com.spring.microservices.dao;

import lombok.Data;

@Data
public class InventoryTemplate {

	private int id;
	
	private String productCode;
	
	private int qnty;
}