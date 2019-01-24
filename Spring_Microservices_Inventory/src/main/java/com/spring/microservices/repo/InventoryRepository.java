package com.spring.microservices.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.microservices.entity.Inventory;
import java.lang.String;
import java.util.List;

public interface InventoryRepository extends JpaRepository<Inventory, Number>{

	List<Inventory> findByProductCode(String productcode);
}
