package com.spring.microservices.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.microservices.entity.Product;
import java.lang.String;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Number>{

	List<Product> findByProductCode(String productcode);
}
