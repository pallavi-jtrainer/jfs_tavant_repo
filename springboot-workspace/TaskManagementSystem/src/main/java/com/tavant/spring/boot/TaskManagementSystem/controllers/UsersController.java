package com.tavant.spring.boot.TaskManagementSystem.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tavant.spring.boot.TaskManagementSystem.entity.Users;
import com.tavant.spring.boot.TaskManagementSystem.exceptions.NoContentAvailableException;
import com.tavant.spring.boot.TaskManagementSystem.exceptions.ResourceNotFoundException;
import com.tavant.spring.boot.TaskManagementSystem.services.UsersService;

@RestController
@RequestMapping("/api/users")
public class UsersController {
	
	@Autowired
	private UsersService service;
	
	@GetMapping
	public ResponseEntity<List<Users>> listAll() throws NoContentAvailableException {
		return ResponseEntity.ok(service.listAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Users>> getUserById(@PathVariable int id) throws ResourceNotFoundException {
		return ResponseEntity.ok(service.getUserById(id));
	}
	
	@GetMapping("/email/{email}")
	public ResponseEntity<Users> getUserByEmail(@PathVariable String email) throws ResourceNotFoundException {
		return ResponseEntity.ok(service.getUserByEmail(email));
	}
	
	@GetMapping("/user/{name}")
	public ResponseEntity<Users> getUserByUsername(@PathVariable String name) throws ResourceNotFoundException {
		return ResponseEntity.ok(service.getUserByUsername(name));
	}
	
	@PostMapping
	public ResponseEntity<Users> saveUserDetails(@RequestBody Users user) {
		return ResponseEntity.ok(service.saveUser(user));
	}
	
	@PatchMapping("/updatepass/{id}/{pass}")
	public ResponseEntity<String> updatePassword(@PathVariable int id, @PathVariable String pass) throws ResourceNotFoundException {
		return ResponseEntity.ok(service.updatePassword(id, pass));
	}
	
	@PatchMapping("/update_email/{id}/{email}")
	public ResponseEntity<String> updateEmail(@PathVariable int id, @PathVariable String email) throws ResourceNotFoundException {
		return ResponseEntity.ok(service.updateEmail(id, email));
	}
}
