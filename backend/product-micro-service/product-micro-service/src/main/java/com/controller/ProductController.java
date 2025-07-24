package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Product;
import com.service.ProductService;

@RestController
@RequestMapping("product")
@CrossOrigin
public class ProductController {

	@Autowired
	ProductService productService;
	
	@PostMapping(value = "store",consumes = MediaType.APPLICATION_JSON_VALUE)
	public String addProduct(@RequestBody Product product) {
		return productService.storeProduct(product);
	}
	
	@PutMapping(value = "update",consumes = MediaType.APPLICATION_JSON_VALUE)
	public String updateProduct(@RequestBody Product product) {
		return productService.updateProduct(product);
	}
	
	@DeleteMapping(value = "delete/{pid}")
	public String deleteProduct(@PathVariable int pid) {
		return productService.deleteProduct(pid);
	}
	
	@GetMapping(value = "find",produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Product> findAllProducts() {
		return productService.findAllProducts();
	}
}
