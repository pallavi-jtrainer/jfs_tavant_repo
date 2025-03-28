package com.tavant.spring.boot.PostsBackend.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tavant.spring.boot.PostsBackend.entity.Users;
import com.tavant.spring.boot.PostsBackend.repositories.UsersRepository;

import jakarta.transaction.Transactional;

@Service
public class UsersService {

	@Autowired
	private UsersRepository repo;
	
	public List<Users> getAllUsers() {
		return repo.findAll();
	}
	
	public Optional<Users> getUserById(long id) {
		return repo.findByUserId(id);
	}
	
	public Optional<Users> getUserByEmail(String email) {
		return repo.findByEmail(email);
	}
	
	public Optional<Users> getUserByUsername(String name) {
		return repo.findByUsername(name);
	}
	
	public Users saveUserDetails(Users user) {
		return repo.save(user);
	}
	
	@Transactional
	public String updateUserEmail(long id, String email) {
		String str = "Unable to update email for user with id: " + id;
		
		int res = repo.updateEmail(id, email);
		
		if(res > 0) {
			str = "Updated email for user with id: " + id;
		}
		
		return str;
	}
	
	@Transactional
	public String updateUserPassword(long id, String pass) {
		String str = "Unable to update password for user with id: " + id;
		
		int res = repo.updatePassword(id, pass);
		
		if(res > 0) {
			str = "Updated password for user with id: " + id;
		}
		
		return str;
	}
}
