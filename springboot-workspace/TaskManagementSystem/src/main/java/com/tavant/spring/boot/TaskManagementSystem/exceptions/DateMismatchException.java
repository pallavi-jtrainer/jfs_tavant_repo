package com.tavant.spring.boot.TaskManagementSystem.exceptions;

public class DateMismatchException extends Exception{

	private static final long serialVersionUID = 1L;

	public DateMismatchException(String msg) {
		super(msg);
	}
}
