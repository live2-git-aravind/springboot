package com.live.repository;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.live.model.Product;
import com.live.model.ProductMapper;
@Repository
public class ProductRepositoryImpl implements ProductRepository {
	
JdbcTemplate jdbcTemplate;

private final String SELECT_PRODUCTS = "SELECT * FROM PRODUCTS";
private final String SELECT_PRODUCT_BY_ID = "SELECT * FROM PRODUCTS WHERE PRODUCT_ID = ?";
private final String CREATE_PRODUCT = "INSERT INTO PRODUCTS (PRODUCT_ID, PRODUCT_NAME, PRICE) VALUES (?,?,?)";
private final String UPDATE_PRODUCT = "UPDATE PRODUCTS SET  PRODUCT_NAME=? , PRICE = ? WHERE PRODUCT_ID = ?";
private final String DELETE_PRODUCT = "DELETE FROM PRODUCTS WHERE PRODUCT_ID = ?";
@Autowired
ProductRepositoryImpl(DataSource dataSource){
	jdbcTemplate = new JdbcTemplate(dataSource);
}
@Override
public List<Product> getProducts() {
	ProductMapper productMapper = new ProductMapper();
	List<Product> products = jdbcTemplate.query(SELECT_PRODUCTS,productMapper);
	return products;
}
@Override
public Product getProductById(int productId) {
			        
	return jdbcTemplate.queryForObject(SELECT_PRODUCT_BY_ID, new Object[]{productId}, new ProductMapper());
			
}

	@Override
	public boolean createProduct(Product product) {
		int noofRowsInserted=jdbcTemplate.update(CREATE_PRODUCT,product.getProductId(),product.getProductName(),product.getPrice());
	return(noofRowsInserted >0);
	}
	
		@Override
		public boolean updateProduct(Product product) {
			int noofRowsUpdated=jdbcTemplate.update(UPDATE_PRODUCT,product.getProductName(),product.getPrice(),product.getProductId());
		return(noofRowsUpdated >0);
		}
	

	
	@Override
	public boolean deleteProduct(int productId) {
		int noofRowsDeleted=jdbcTemplate.update(DELETE_PRODUCT,productId);
		return (noofRowsDeleted >0);
	}
	

}