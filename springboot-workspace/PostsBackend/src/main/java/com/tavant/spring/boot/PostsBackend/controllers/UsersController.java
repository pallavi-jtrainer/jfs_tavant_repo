package com.tavant.spring.boot.PostsBackend.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tavant.spring.boot.PostsBackend.entity.Users;
import com.tavant.spring.boot.PostsBackend.services.UsersService;

@RestController
@RequestMapping("/api")
@CrossOrigin("http://localhost:4200")
public class UsersController {

	@Autowired
	private UsersService service;
	
	@GetMapping("/users")
	public ResponseEntity<List<Users>> listAllUsers() {
		return ResponseEntity.ok(service.getAllUsers());
	}
	
	@GetMapping("/user/{id}")
	public ResponseEntity<Optional<Users>> getUserDetailsById(@PathVariable long id) {
		return ResponseEntity.ok(service.getUserById(id));
	}
	
	@GetMapping("/email/{email}")
	public ResponseEntity<Optional<Users>> getUserDetailsByEmail(@PathVariable String email) {
		return ResponseEntity.ok(service.getUserByEmail(email));
	}
	
	@GetMapping("/name/{name}")
	public ResponseEntity<Optional<Users>> getUserDetailsByUsername(@PathVariable String name) {
		return ResponseEntity.ok(service.getUserByUsername(name));
	}
	
	@PostMapping("/user")
	public ResponseEntity<Users> saveUserDetails(@RequestBody Users user) {
		return ResponseEntity.ok(service.saveUserDetails(user));
	}
	
	@PatchMapping("/update/{id}/{email}")
	public ResponseEntity<String> updateEmail(@PathVariable long id, @PathVariable String email) {
		return ResponseEntity.ok(service.updateUserEmail(id, email));
	}
	
	@PatchMapping("/pass/{id}/{pass}")
	public ResponseEntity<String> updatePassword(@PathVariable long id, @PathVariable String pass) {
		return ResponseEntity.ok(service.updateUserPassword(id, pass));
	}
}
