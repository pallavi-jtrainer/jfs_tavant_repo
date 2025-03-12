package com.tavant.spring.boot.PostsBackend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="users")
@Data
@NoArgsConstructor
public class Users {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long userId;
	
	@Column(name = "first_name", nullable = false, length=150)
	private String firstName;
	
	@Column(name = "last_name", nullable = false, length=150)
	private String lastName;
	
	@Column(name = "username", nullable = false, length=50, unique=true)
	private String username;
	
	@Column(name = "password", nullable = false, length=150)
	private String password;
	
	@Column(name = "email", nullable=false, length=150, unique=true)
	private String email;

	public Users(String firstName, String lastName, String username, 
			String password, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.email = email;
	}
}
