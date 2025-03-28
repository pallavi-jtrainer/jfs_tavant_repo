package com.tavant.spring.boot.TaskManagementSystemWithJWT.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tavant.spring.boot.TaskManagementSystemWithJWT.dto.TaskDto;
import com.tavant.spring.boot.TaskManagementSystemWithJWT.service.TaskService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
@CrossOrigin("*")
public class TaskController {

	private final TaskService taskService;
	
	@GetMapping("/tasks")
	public ResponseEntity<List<TaskDto>> getTaskByUserId(){
        return ResponseEntity.ok(taskService.getTaskByUserId());
    }

    @GetMapping("/tasks/{id}/{status}")
    public ResponseEntity<TaskDto> updateTask(@PathVariable Long id, @PathVariable String status){
        TaskDto updatedTask = taskService.updateTask(id, status);
        if(updatedTask == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return  ResponseEntity.ok(updatedTask);
    }

    @GetMapping("/task/{id}")
    public ResponseEntity<TaskDto> getTaskById(@PathVariable Long id){
        return ResponseEntity.ok(taskService.getTaskById(id));
    }
    
}
