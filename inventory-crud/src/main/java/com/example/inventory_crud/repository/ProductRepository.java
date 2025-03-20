package com.example.inventory_crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.inventory_crud.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

	Product findByName(String name);

}
