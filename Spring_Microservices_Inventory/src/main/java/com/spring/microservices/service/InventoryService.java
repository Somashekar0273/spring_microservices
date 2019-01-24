package com.spring.microservices.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.microservices.dao.InventoryDao;
import com.spring.microservices.dao.InventoryServiceDao;

@Service("inventoryService")
public class InventoryService {

	@Autowired
	private InventoryServiceDao inventoryServiceDao;
	
	
	public InventoryDao getInventoryByCode(String code) {
		return inventoryServiceDao.getInventoryByCode(code);
	}
	
	public List<InventoryDao> getAllInventories() {
		return inventoryServiceDao.getAllInventories();
	}
}
