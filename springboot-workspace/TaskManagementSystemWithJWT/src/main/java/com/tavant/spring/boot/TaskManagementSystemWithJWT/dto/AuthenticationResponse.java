package com.tavant.spring.boot.TaskManagementSystemWithJWT.dto;

import com.tavant.spring.boot.TaskManagementSystemWithJWT.utils.UserRole;

import lombok.Data;

@Data
public class AuthenticationResponse {
	 private String jwt;
     private Long userId;
     private UserRole userRole;
}
