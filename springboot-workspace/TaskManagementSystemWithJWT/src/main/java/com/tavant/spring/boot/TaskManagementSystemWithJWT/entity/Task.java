package com.tavant.spring.boot.TaskManagementSystemWithJWT.entity;

import java.time.LocalDate;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tavant.spring.boot.TaskManagementSystemWithJWT.dto.TaskDto;
import com.tavant.spring.boot.TaskManagementSystemWithJWT.utils.TaskStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="tasks")
@Data
public class Task {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(nullable = false)
	private String taskName;
	
	@Column(nullable=false)
	private LocalDate dueDate;
	
	@Column(nullable = false)
	private TaskStatus taskStatus;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private User user;

	public TaskDto getTaskDto(){
        TaskDto taskDto = new TaskDto();

        taskDto.setId(id);
        taskDto.setTaskName(taskName);
        taskDto.setDueDate(dueDate);
        taskDto.setFirstName(user.getFirstName());
        taskDto.setLastName(user.getLastName());
        taskDto.setUserId(user.getId());
        taskDto.setTaskStatus(taskStatus);
        return taskDto;
    }
}
