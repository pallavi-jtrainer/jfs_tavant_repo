package com.tavant.spring.boot.TaskManagementSystem.exceptions;

public class ResourceNotFoundException extends Exception{
	
	private static final long serialVersionUID = 1L;

	public ResourceNotFoundException(String msg) {
		super(msg);
	}
}
