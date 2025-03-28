package com.tavant.spring.boot.TaskManagementSystem.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="tasks")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Tasks {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="task_name", nullable=false)
	private String taskName;
	
	@Column(name="status", nullable=false)
	private TaskStatus status;
	
	@Column(name="start_date", nullable=false)
	private LocalDate startDate;
	
	@Column(name="due_date", nullable=false)
	private LocalDate dueDate;
	
	@Column(name="user_id", nullable=false)
	private int userId;

}
