package com.tavant.hibernate.HibernateOneToOneXML.entity;

public class Product {
	private int id;
	private int productId;
	private String productName;
	private double price;
	private ProductDetails productDetails;
	
	public Product() {}

	public Product(int productId, String productName, double price) {
		this.productId = productId;
		this.productName = productName;
		this.price = price;
	}

	public ProductDetails getProductDetails() {
		return productDetails;
	}
	
	public void setProductDetails(ProductDetails productDetails) {
		this.productDetails = productDetails;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", price=" + price + "]";
	}
}
