package com.tavant.spring.boot.TaskManagementSystem.exceptions;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ErrorMessage {

	private int statusCode;
	private String message;
	private LocalDateTime timestamp;
	
}
