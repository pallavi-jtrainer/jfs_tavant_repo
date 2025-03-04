package com.tavant.spring.boot.TaskManagementSystemWithJWT.service;

import java.util.Optional;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.tavant.spring.boot.TaskManagementSystemWithJWT.dto.RegisterRequest;
import com.tavant.spring.boot.TaskManagementSystemWithJWT.dto.UserDto;
import com.tavant.spring.boot.TaskManagementSystemWithJWT.entity.User;
import com.tavant.spring.boot.TaskManagementSystemWithJWT.repository.UserRepository;
import com.tavant.spring.boot.TaskManagementSystemWithJWT.utils.UserRole;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {
	private final UserRepository userRepository;
	
	@PostConstruct
    public void createAdminAccount(){
        Optional<User> optionalUser = userRepository.findByUserRole(UserRole.ADMIN);
        if(optionalUser.isEmpty()){
            User user = new User();
            user.setEmail("admin@test.com");
            user.setFirstName("admin");
            user.setLastName("admin");
            user.setPassword(new BCryptPasswordEncoder().encode("admin"));
            user.setUserRole(UserRole.ADMIN);
            userRepository.save(user);
            System.out.println("Admin account created successfully!");
        }else{
            System.out.println("Admin account already exist!");
        }
    }
	
	 public UserDto registerUser(RegisterRequest registerReq) {
        User user = new User();
        user.setEmail(registerReq.getEmail());
        user.setFirstName(registerReq.getFirstName());
        user.setLastName(registerReq.getLastName());
        user.setPassword(new BCryptPasswordEncoder().encode(registerReq.getPassword()));
        user.setUserRole(UserRole.EMPLOYEE);
        User createdUser = userRepository.save(user);
        return createdUser.getUserDto();
	 }
	 
	 public boolean hasUserWithEmail(String email) {
	     return userRepository.findByEmail(email).isPresent();
	 }
}
