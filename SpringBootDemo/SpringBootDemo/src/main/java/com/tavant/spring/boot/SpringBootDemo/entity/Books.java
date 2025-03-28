package com.tavant.spring.boot.SpringBootDemo.entity;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="books")
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Books {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bookId;
	
	@NotBlank(message="Title cannot be blank")
	@Column(name="title", nullable=false)
	private String title;
	
	@NotBlank(message="Author cannot be blank")
	@Column(name="author", nullable=false)
	private String author;
	
	
	@Column(name="release_year", nullable=false)
	private int releaseYear;
	
	@Column(name="price", nullable=false)
	private double price;

	public Books(String title, String author, int releaseYear, double price) {
		this.title = title;
		this.author = author;
		this.releaseYear = releaseYear;
		this.price = price;
	}	
}
