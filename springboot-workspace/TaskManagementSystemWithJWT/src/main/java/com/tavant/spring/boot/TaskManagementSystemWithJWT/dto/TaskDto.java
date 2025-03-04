package com.tavant.spring.boot.TaskManagementSystemWithJWT.dto;

import java.time.LocalDate;

import com.tavant.spring.boot.TaskManagementSystemWithJWT.utils.TaskStatus;

import lombok.Data;

@Data
public class TaskDto {
	private long id;
	private String taskName;
	private LocalDate dueDate;
	private TaskStatus taskStatus;
	private long userId;
	private String firstName;
	private String lastName;
}
