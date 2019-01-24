package com.spring.microservices;

import com.spring.microservices.dao.InventoryDao;
import com.spring.microservices.entity.Inventory;

public class Utilities {
	
	private Utilities() {
		
	}
	
	public static Inventory getInventoryFromDao(InventoryDao InventoryDao) {
		Inventory inventory = new Inventory();
		inventory.setId(InventoryDao.getId());
		inventory.setQnty(InventoryDao.getQnty());
		inventory.setProductCode(InventoryDao.getProductCode());
		return inventory;
	}
	
	public static InventoryDao getDaoFromInventory(Inventory inventory) {
		InventoryDao inventoryDao = new InventoryDao();
		inventoryDao.setQnty(inventory.getQnty());
		inventoryDao.setId(inventory.getId());
		inventoryDao.setProductCode(inventory.getProductCode());
		return inventoryDao;
	}

}
