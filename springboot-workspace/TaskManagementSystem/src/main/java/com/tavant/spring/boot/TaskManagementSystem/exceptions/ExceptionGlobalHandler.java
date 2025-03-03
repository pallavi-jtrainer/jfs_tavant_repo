package com.tavant.spring.boot.TaskManagementSystem.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class ExceptionGlobalHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ErrorMessage> resourceNotFoundExceptionHandler(
			ResourceNotFoundException ex, WebRequest req) {
		ErrorMessage errorMessage = new ErrorMessage(
				HttpStatus.NOT_FOUND.value(), 
				ex.getMessage(),
				LocalDateTime.now());
		return new ResponseEntity<ErrorMessage>(errorMessage, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(DateMismatchException.class)
	public ResponseEntity<ErrorMessage> dateMismatchExceptionHandler(
			DateMismatchException ex, WebRequest req) {
		ErrorMessage errorMessage = new ErrorMessage(
				HttpStatus.NOT_ACCEPTABLE.value(),
				ex.getMessage(), 
				LocalDateTime.now());
		return new ResponseEntity<ErrorMessage>(errorMessage, HttpStatus.NOT_ACCEPTABLE);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorMessage> globalExceptionHandler(
			Exception ex, WebRequest req) {
		ErrorMessage errorMessage = new ErrorMessage(
				HttpStatus.INTERNAL_SERVER_ERROR.value(), 
				ex.getMessage(),
				LocalDateTime.now());
		return new ResponseEntity<ErrorMessage>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
