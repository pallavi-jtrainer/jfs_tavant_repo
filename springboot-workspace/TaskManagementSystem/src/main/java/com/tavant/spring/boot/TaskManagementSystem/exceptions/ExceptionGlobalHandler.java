package com.tavant.spring.boot.TaskManagementSystem.exceptions;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class ExceptionGlobalHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<Map<String, Object>> handleResourceNotFoundException(ResourceNotFoundException ex) {
        Map<String, Object> errorDetails = new HashMap<>();
        errorDetails.put("timestamp", LocalDateTime.now());
        errorDetails.put("message", ex.getMessage());
        errorDetails.put("status", HttpStatus.NOT_FOUND.value());

        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }
	
//	@ExceptionHandler(ResourceNotFoundException.class)
//	@ResponseStatus(HttpStatus.NOT_FOUND)
//	public ResponseEntity<ErrorMessage> resourceNotFoundExceptionHandler(
//			ResourceNotFoundException ex, WebRequest req) {
//		ErrorMessage errorMessage = new ErrorMessage(
//				HttpStatus.NOT_FOUND.value(), 
//				ex.getMessage(),
//				LocalDateTime.now());
//		return new ResponseEntity<ErrorMessage>(errorMessage, HttpStatus.NOT_FOUND);
//	}
	
	@ExceptionHandler(DateMismatchException.class)
	 @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
	public ResponseEntity<ErrorMessage> dateMismatchExceptionHandler(
			DateMismatchException ex, WebRequest req) {
		ErrorMessage errorMessage = new ErrorMessage(
				HttpStatus.NOT_ACCEPTABLE.value(),
				ex.getMessage(), 
				LocalDateTime.now());
		return new ResponseEntity<ErrorMessage>(errorMessage, HttpStatus.NOT_ACCEPTABLE);
	}
	
	@ExceptionHandler(NoContentAvailableException.class)
	public ResponseEntity<ErrorMessage> noContentAvailableExceptionHandler(
			NoContentAvailableException ex, WebRequest req) {
		ErrorMessage errorMessage = new ErrorMessage(
				HttpStatus.NOT_FOUND.value(), 
				ex.getMessage(),
				LocalDateTime.now());
		return new ResponseEntity<ErrorMessage>(errorMessage, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(Exception.class)
	 @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ResponseEntity<ErrorMessage> globalExceptionHandler(
			Exception ex, WebRequest req) {
		ErrorMessage errorMessage = new ErrorMessage(
				HttpStatus.INTERNAL_SERVER_ERROR.value(), 
				ex.getMessage(),
				LocalDateTime.now());
		return new ResponseEntity<ErrorMessage>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
