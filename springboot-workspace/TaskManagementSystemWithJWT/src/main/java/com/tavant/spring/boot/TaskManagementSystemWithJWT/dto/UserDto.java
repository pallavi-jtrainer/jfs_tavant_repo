package com.tavant.spring.boot.TaskManagementSystemWithJWT.dto;

import com.tavant.spring.boot.TaskManagementSystemWithJWT.utils.UserRole;

import lombok.Data;

@Data
public class UserDto {
	private long id;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private UserRole userRole;
}
