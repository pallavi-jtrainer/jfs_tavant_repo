package com.tavant.spring.boot.TaskManagementSystem.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tavant.spring.boot.TaskManagementSystem.entity.Tasks;
import com.tavant.spring.boot.TaskManagementSystem.exceptions.DateMismatchException;
import com.tavant.spring.boot.TaskManagementSystem.exceptions.ResourceNotFoundException;
import com.tavant.spring.boot.TaskManagementSystem.services.TasksService;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

	@Autowired
	private TasksService service;
	
	@GetMapping
	public ResponseEntity<List<Tasks>> listAllTasks() {
		List<Tasks> tasks = service.listAllTasks();
		
		if(tasks.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		
		return ResponseEntity.ok(tasks);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Tasks> getTaskById(@PathVariable int id) {
		Tasks t;
		try {
			t = service.retrieveById(id);
		} catch (ResourceNotFoundException e) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(t);
	}
	
	@PostMapping
	public ResponseEntity<Tasks> saveTaskDetails(Tasks task) throws DateMismatchException {
//		Tasks t = null;
//		try {
//			t = service.saveTaskDetails(task);
//		} catch (DateMismatchException e) {
//			System.out.println(e.getMessage());
//		}
		
		Tasks t = service.saveTaskDetails(task);
		return ResponseEntity.ok(t);
	}
	
	
}
