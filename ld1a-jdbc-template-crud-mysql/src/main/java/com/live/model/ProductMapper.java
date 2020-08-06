package com.live.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class ProductMapper implements RowMapper<Product>{

	@Override
	public Product mapRow(ResultSet resultSet, int rowNum) throws SQLException {
		Product product = new Product();
		product.setProductId(resultSet.getInt("PRODUCT_ID"));
		product.setProductName(resultSet.getString("PRODUCT_NAME"));
		product.setPrice(resultSet.getFloat("PRICE"));
		return product;
	}

}