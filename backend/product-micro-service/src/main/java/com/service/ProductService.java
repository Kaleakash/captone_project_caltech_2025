package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Product;
import com.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	ProductRepository productRepository;
	
	public String storeProduct(Product product) {
		Optional<Product> result = productRepository.findById(product.getPid());
		if(result.isPresent()) {
			return "Product id must be unique";
		}else {
			productRepository.save(product);
			return "Product stored successfully";
		}
	}
	public String deleteProduct(int pid) {
		Optional<Product> result = productRepository.findById(pid);
		if(result.isPresent()) {
			productRepository.deleteById(pid);
			return "Product deleted successfully";
		}else {
			return "Product not present";
		}
	}
	public String updateProduct(Product product) {
		Optional<Product> result = productRepository.findById(product.getPid());
		if(result.isPresent()) {
			Product productFromDb = result.get();
			productFromDb.setPrice(product.getPrice());
			productFromDb.setQty(product.getQty());
			productFromDb.setImageurl(product.getImageurl());
			productRepository.saveAndFlush(productFromDb);
			return "Product details updated successfully";
		}else {
			return "Product not present";
		}
	}
	public List<Product> findAllProducts() {
		return productRepository.findAll();
	}
	
	public Product findProduct(int pid) {
		Optional<Product> result = productRepository.findById(pid);
		if(result.isPresent()) {
			Product productFromDb = result.get();
			return productFromDb;
		}else {
			return null;
		}
	}
}
