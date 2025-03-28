package com.tavant.spring.boot.TaskManagementSystem.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tavant.spring.boot.TaskManagementSystem.entity.Users;
import com.tavant.spring.boot.TaskManagementSystem.exceptions.NoContentAvailableException;
import com.tavant.spring.boot.TaskManagementSystem.exceptions.ResourceNotFoundException;
import com.tavant.spring.boot.TaskManagementSystem.repositories.UsersRepository;

@Service
public class UsersService {

	@Autowired
	private UsersRepository repo;
	
	public List<Users> listAll() {
		List<Users> users = repo.findAll();
		
		if(users.isEmpty()) {
			throw new NoContentAvailableException("Table is empty. Please add users!");
		}
		
		return users;
	}
	
	public Optional<Users> getUserById(int id) throws ResourceNotFoundException {
		Optional<Users> user = repo.findById(id);
		
		if(!user.isPresent()) {
			throw new ResourceNotFoundException("User with id: " + id + " not found");
		}
		
		return user;
	}
	
	public Users getUserByEmail(String email) throws ResourceNotFoundException {
		Users u = repo.findByEmail(email);
		
		if(u == null) {
			throw new ResourceNotFoundException("User with email: " + email + " not found");
		}
		
		return u;
	}
	
	public Users getUserByUsername(String name) throws ResourceNotFoundException {
		Users u = repo.findByUsername(name);
		
		if(u == null) {
			throw new ResourceNotFoundException("User with name: " + name + " not found");
		}
		
		return u;
	}
	
	public Users saveUser(Users user) {
		return repo.save(user);
	}
	
	public String updatePassword(int id, String pass) throws ResourceNotFoundException {
		String str = "Unable to update password";
		
		Optional<Users> user = repo.findById(id);
		
		if(user.isPresent()) {
			int res = repo.updatePassword(id, pass);
			
			if(res > 0) 
				str = "Password updated successfully";
		} else
			throw new ResourceNotFoundException("User with id: " + id + " not found");
		
		return str;
	}
	
	public String updateEmail(int id, String email) throws ResourceNotFoundException {
		String str = "Unable to update email";
		
		Optional<Users> user = repo.findById(id);
		
		if(user.isPresent()) {
			int res = repo.updateEmail(id, email);
			
			if(res > 0) 
				str = "Email updated successfully";
		} else
			throw new ResourceNotFoundException("User with id: " + id + " not found");
		
		return str;
		
	}
	
}
