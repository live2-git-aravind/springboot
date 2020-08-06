package com.live.model;

public class Product {
private Long productId;
private String productName;
private String description;
private float price;
public Product() {
	super();
}
public Product(Long productId, String productName, String description, float price) {
	super();
	this.productId = productId;
	this.productName = productName;
	this.description = description;
	this.price = price;
}
public String getProductName() {
	return productName;
}
public void setProductName(String productName) {
	this.productName = productName;
}
public String getDescription() {
	return description;
}
public float getPrice() {
	return price;
}
public Long getProductId() {
	return productId;
}
public void setDescription(String description) {
	this.description = description;
}
public void setPrice(float price) {
	this.price = price;
}
public void setProductId(Long productId) {
	this.productId = productId;
}
@Override
public String toString() {
	return "Product [productId=" + productId + ", productName=" + productName + ", description=" + description
			+ ", price=" + price + "]";
}
}