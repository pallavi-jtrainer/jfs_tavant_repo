package com.sample.spring.boot.SpringBootJWT.controllers;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sample.spring.boot.SpringBootJWT.entity.ERole;
import com.sample.spring.boot.SpringBootJWT.entity.Role;
import com.sample.spring.boot.SpringBootJWT.entity.User;
import com.sample.spring.boot.SpringBootJWT.payload.request.LoginRequest;
import com.sample.spring.boot.SpringBootJWT.payload.request.RegisterRequest;
import com.sample.spring.boot.SpringBootJWT.payload.response.MessageResponse;
import com.sample.spring.boot.SpringBootJWT.payload.response.UserInfoResponse;
import com.sample.spring.boot.SpringBootJWT.repository.RoleRepository;
import com.sample.spring.boot.SpringBootJWT.repository.UserRepository;
import com.sample.spring.boot.SpringBootJWT.security.jwt.JwtUtils;
import com.sample.spring.boot.SpringBootJWT.security.services.UserDetailsImpl;

import jakarta.validation.Valid;

@CrossOrigin(origins = "*", maxAge= 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {

	@Autowired
	AuthenticationManager authManager;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	RoleRepository roleRepository;
	
	@Autowired
	PasswordEncoder encoder;
	
	@Autowired
	JwtUtils jwtUtils;
	
	@PostMapping("/login")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
		Authentication authentication = authManager
		        .authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

		    SecurityContextHolder.getContext().setAuthentication(authentication);

		    UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

		    ResponseCookie jwtCookie = jwtUtils.generateJwtCookie(userDetails);

		    List<String> roles = userDetails.getAuthorities().stream()
		        .map(item -> item.getAuthority())
		        .collect(Collectors.toList());

		    return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, jwtCookie.toString())
		        .body(new UserInfoResponse(userDetails.getId(),
		                                   userDetails.getUsername(),
		                                   userDetails.getEmail(),
		                                   roles));
	}
	
	@PostMapping("/register")
	public ResponseEntity<?> registerUser(@Valid @RequestBody RegisterRequest registerRequest) {
		if(userRepository.existsByUsername(registerRequest.getUsername())) {
			return ResponseEntity.badRequest().body(new MessageResponse("Error: Username is already taken!"));
		}
		
		if(userRepository.existsByEmail(registerRequest.getEmail())) {
			return ResponseEntity.badRequest().body(new MessageResponse("Error: Email already exists!"));
		}
		
		User user = new User(registerRequest.getUsername(), 
				registerRequest.getEmail(),
				encoder.encode(registerRequest.getPassword()));
		
		Set<String> role = registerRequest.getRole();
		Set<Role> roles = new HashSet<Role>();
		
		if(role == null) {
			Role userRole = roleRepository.findByName(ERole.ROLE_USER)
					.orElseThrow(() -> new RuntimeException("Error: Role not found"));
			roles.add(userRole);
		} else {
			Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
					.orElseThrow(() -> new RuntimeException("Error: Role not found"));
			roles.add(adminRole);
		}
		
		user.setRoles(roles);
		userRepository.save(user);
		
		return ResponseEntity.ok(new MessageResponse("User Registered Successfully"));
		
	}
	
	@PostMapping("/signout")
	public ResponseEntity<?> logoutUser() {
		ResponseCookie cookie = jwtUtils.getCleanJwtCookie();
		return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, cookie.toString())
				.body(new MessageResponse("You've been signed out!!"));
		
	}
}
