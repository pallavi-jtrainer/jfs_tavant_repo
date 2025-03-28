package com.tavant.spring.boot.TaskManagementSystemWithJWT.dto;

import lombok.Data;

@Data
public class AuthenticationRequest {

	private String email;
	private String password;
}
