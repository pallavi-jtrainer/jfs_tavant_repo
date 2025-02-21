package com.tavant.hibernate.HibernateOneToOneMapping.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="product_details")
public class ProductDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "details_id", nullable=false, unique=true)
	private int detailsId;
	
	@Column(name="category", nullable=false)
	private String category;
	
	@Column(name="brand", nullable=false)
	private String brand;
	
	public ProductDetails() {}

	public ProductDetails(int detailsId, String category, String brand) {
		this.detailsId = detailsId;
		this.category = category;
		this.brand = brand;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getDetailsId() {
		return detailsId;
	}

	public void setDetailsId(int detailsId) {
		this.detailsId = detailsId;
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
		return "ProductDetails [detailsId=" + detailsId + ", category=" + category + ", brand=" + brand + "]";
	}
	
	
}
