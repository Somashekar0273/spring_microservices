package com.spring.microservices.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.microservices.Utilities;
import com.spring.microservices.entity.Inventory;
import com.spring.microservices.repo.InventoryRepository;

@Repository("inventoryServiceDao")
public class InventoryServiceDao {

	@Autowired
	private InventoryRepository inventoryRepo;
	
	public InventoryDao getInventoryByCode(String code) {
		List<Inventory> listofInventory = inventoryRepo.findByProductCode(code);
		Inventory inventory = null;
		if (listofInventory.size() > 0) {
			inventory = listofInventory.get(0);
		}
		
		if (inventory != null) {
			return Utilities.getDaoFromInventory(inventory);
		}
		return null;
	}
	
	public List<InventoryDao> getAllInventories() {
		List<Inventory> listofInventory = inventoryRepo.findAll();
		List<InventoryDao> inventories = new ArrayList<>();
		for (Iterator<Inventory> iterator = listofInventory.iterator(); iterator.hasNext();) {
			Inventory inventory = (Inventory) iterator.next();
			inventories.add(Utilities.getDaoFromInventory(inventory));
		}
		return inventories;
	}
}
