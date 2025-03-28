package com.tavant.spring.boot.PostsBackend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="posts")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Posts {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name="title", nullable=false, length=50, unique=true)
	private String title;
	
	@Column(name="body", nullable=false, length=250)
	private String body;
	
	@Column(name="user_id", nullable=false)
	private long userId;

	public Posts(String title, String body, long userId) {
		this.title = title;
		this.body = body;
		this.userId = userId;
	}
	
	
}
