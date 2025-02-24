package com.tavant.hibernate.HibernateOneToOneXML.entity;

public class ProductDetails {
	private int id;
	private int productId;
	private String category;
	private String brand;
	private Product product;
	
	public ProductDetails(int detailsId, String category, String brand) {
		this.productId = detailsId;
		this.category = category;
		this.brand = brand;
	}
	
	public ProductDetails() {}

	public Product getProduct() {
		return product;
	}
	
	public void setProduct(Product product) {
		this.product = product;
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

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	@Override
	public String toString() {
		return "ProductDetails [productId=" + productId + ", category=" + category + ", brand=" + brand + "]";
	}
}
