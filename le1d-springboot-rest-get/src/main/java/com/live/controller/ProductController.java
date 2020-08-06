package com.live.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.live.model.Product;

@RestController
public class ProductController {	
	List<Product> products = new ArrayList<Product>();
	@GetMapping("/products")
	public List<Product> getProducts() {
		// ideally connect to service, from service to repo, repo to db and fetch the
		// data.
		// for convenience create a stub collection
		products.add(new Product(100l, "SpringBoot.", "Book", 500.50f));
		products.add(new Product(101l, "Angular", "Book", 555.50f));
		return products;
	}
	@PostMapping("/products")
	public Product createProduct(@RequestBody Product product) {
		product.setProductId(1000L);
		products.add(product);
		return product;
	}
	@PutMapping("/products/{id}")
	public void updateProduct(@PathVariable(value="id") long productId) {
		Product Productvar2=null;
		int index=-1;
		for(Product Product1:products) {
			index++;
			if(Product1.getProductId()== productId) {
				Product1.setProductName("UpdatedProduct");
			}
			break;
		}
	}
	@DeleteMapping("/products/{id}")
	public void deleteProduct(@PathVariable(value="id") long productId) {
		Product productvar=null;
		int index=-1; 
		for(Product Product1:products) {
			index++;
			if(Product1.getProductId() == productId) {
				products.remove(index);
			}
			break;
			}
		}
		
	}
