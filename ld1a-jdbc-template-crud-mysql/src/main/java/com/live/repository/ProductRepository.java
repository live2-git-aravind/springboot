package com.live.repository;

import java.util.List;

import com.live.model.Product;

public interface ProductRepository {


public List<Product> getProducts();

Product getProductById(int productId);
boolean createProduct(Product product);
boolean updateProduct(Product product);
boolean deleteProduct(int productId);

}