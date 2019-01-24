package com.spring.microservices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.microservices.dao.InventoryDao;
import com.spring.microservices.service.InventoryService;

@RestController
@RequestMapping(value="/api/inventory")
public class InventoryController {

	@Autowired
	private InventoryService inventoryService;
	
	@GetMapping(value="/{code}", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<InventoryDao> getInventoryByCode(@PathVariable("code") String code) {
		InventoryDao inventory = inventoryService.getInventoryByCode(code);
		return new ResponseEntity<InventoryDao>(inventory, HttpStatus.OK);
	}
	
	@GetMapping(produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<InventoryDao>> getAllInventories() {
		List<InventoryDao> allInventory = inventoryService.getAllInventories();
		return new ResponseEntity<List<InventoryDao>>(allInventory, HttpStatus.OK);
	}
}
