package com.tavant.spring.boot.TaskManagementSystem.controllers;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tavant.spring.boot.TaskManagementSystem.entity.TaskStatus;
import com.tavant.spring.boot.TaskManagementSystem.entity.Tasks;
import com.tavant.spring.boot.TaskManagementSystem.exceptions.DateMismatchException;
import com.tavant.spring.boot.TaskManagementSystem.exceptions.NoContentAvailableException;
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
			throw new NoContentAvailableException("Table is empty. Add Data before retrieval");
		}
		
		return ResponseEntity.ok(tasks);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Tasks>> getTaskById(@PathVariable int id) throws ResourceNotFoundException {
		Optional<Tasks> t = service.retrieveById(id);
//		try {
//			t = service.retrieveById(id);
//		} catch (ResourceNotFoundException e) {
//			return ResponseEntity.notFound().build();
//		}
		
		return ResponseEntity.ok(t);
	}
	
	@GetMapping("/start/{date}")
	public ResponseEntity<List<Tasks>> listAllTasksByStartDate(@PathVariable LocalDate date) throws NoContentAvailableException{
		List<Tasks> tasks = service.listAllByStartDate(date);
		return ResponseEntity.ok(tasks);
	}
	
	@GetMapping("/end/{date}")
	public ResponseEntity<List<Tasks>> listAllTasksByDueDate(@PathVariable LocalDate date) throws NoContentAvailableException{
		List<Tasks> tasks = service.listAllByDueDate(date);
		return ResponseEntity.ok(tasks);
	}
	
	@GetMapping("/user/{id}")
	public ResponseEntity<List<Tasks>> listAllTasksByUserId(@PathVariable int id) throws NoContentAvailableException{
		List<Tasks> tasks = service.listAllTasksByUserId(id);
		return ResponseEntity.ok(tasks);
	}
	
	@GetMapping("/uns/{id}/{status}")
	public ResponseEntity<List<Tasks>> listAllTasksByUserIdAndStatus(@PathVariable int id, @PathVariable String stat) throws NoContentAvailableException{
		TaskStatus status = TaskStatus.valueOf(stat);
		
		List<Tasks> tasks = service.listAllByUserIdAndStatus(id, status);
		return ResponseEntity.ok(tasks);
	}
	
	@GetMapping("/list/{status}")
	public ResponseEntity<List<Tasks>> listAllTasksByStatus(@PathVariable String stat) throws NoContentAvailableException{
		TaskStatus status = TaskStatus.valueOf(stat);
		
		List<Tasks> tasks = service.listAllTasksByStatus(status);
		return ResponseEntity.ok(tasks);
	}
	
	@PostMapping
	public ResponseEntity<Tasks> saveTaskDetails(@RequestBody Tasks task) throws DateMismatchException {
//		Tasks t = null;
//		try {
//			t = service.saveTaskDetails(task);
//		} catch (DateMismatchException e) {
//			System.out.println(e.getMessage());
//		}
		
		Tasks t = service.saveTaskDetails(task);
		return ResponseEntity.ok(t);
	}
	
	@PatchMapping("/status/{id}/{stat}")
	public ResponseEntity<String> updateStatus(@PathVariable int id, @PathVariable String stat) throws ResourceNotFoundException {
		TaskStatus status = TaskStatus.valueOf(stat.toUpperCase());
		
		String str = service.updateTaskStatus(id, status);
		
		return ResponseEntity.ok(str);
	}
	
	@PatchMapping("/duedate/{id}/{date}")
	public ResponseEntity<String> resetDueDate(@PathVariable int id, @PathVariable LocalDate date) throws DateMismatchException, ResourceNotFoundException{
		String str = service.resetDueDate(id, date);
		
		return ResponseEntity.ok(str);
	}
}
