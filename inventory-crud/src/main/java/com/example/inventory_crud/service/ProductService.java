package com.example.inventory_crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.inventory_crud.entity.Product;
import com.example.inventory_crud.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository repository;
	
	//Post Method - one Product
	public Product saveProduct(Product product) {
		return repository.save(product);
	}
	
	//Post Method - list of Product
	public List<Product> saveProducts(List<Product> products) {
		return repository.saveAll(products);
	}
	
	//Get Method - all Products
	public List<Product> getProducts() {
		return repository.findAll();
	}
	
	//Get Method - by id
	public Product getProductById(int id) {
		return repository.findById(id).orElse(null);
	}
	
	//Get Method - by name
	public Product getProductByName(String name) {
		return repository.findByName(name);
	}
	
	//Put Method
	public Product updateProduct(Product product) {
		Product updatedProduct = repository.findById(product.getId()).orElse(null);
		updatedProduct.setName(product.getName());
		updatedProduct.setQuantity(product.getQuantity());
		updatedProduct.setPrice(product.getPrice());
		return repository.save(updatedProduct);
	}
	
	//Delete Method
	public String deleteProduct(int id) {
		repository.deleteById(id);
		return "Deleted product with the id: " + id;
	}
}
