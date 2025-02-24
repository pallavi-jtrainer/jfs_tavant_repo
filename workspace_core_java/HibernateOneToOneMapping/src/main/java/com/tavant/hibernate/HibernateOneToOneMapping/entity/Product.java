package com.tavant.hibernate.HibernateOneToOneMapping.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="product")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "product_id", nullable = false, unique=true)
	private int productId;
	
	@Column(name = "product_name", nullable = false, length=150)
	private String productName;
	
	@Column(name="price", nullable=false)
	private double price;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="detail_id")
	private ProductDetails details;
	
	public Product() {}

	public Product(int productId, String productName, double price) {
		this.productId = productId;
		this.productName = productName;
		this.price = price;
	}

	public ProductDetails getDetails() {
		return details;
	}
	
	public void setDetails(ProductDetails details) {
		this.details = details;
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
		return "Product [productId=" + productId + ", productName=" + productName + ", price=" + price
				+ "details= " + details.toString() + "]";
	}
	
	
}
