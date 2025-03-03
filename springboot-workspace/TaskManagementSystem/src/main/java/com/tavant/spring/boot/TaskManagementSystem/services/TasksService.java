package com.tavant.spring.boot.TaskManagementSystem.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tavant.spring.boot.TaskManagementSystem.entity.TaskStatus;
import com.tavant.spring.boot.TaskManagementSystem.entity.Tasks;
import com.tavant.spring.boot.TaskManagementSystem.exceptions.DateMismatchException;
import com.tavant.spring.boot.TaskManagementSystem.exceptions.NoContentAvailableException;
import com.tavant.spring.boot.TaskManagementSystem.exceptions.ResourceNotFoundException;
import com.tavant.spring.boot.TaskManagementSystem.repositories.TasksRepository;

@Service
public class TasksService {
	
	@Autowired
	private TasksRepository repo;
	
	public List<Tasks> listAllTasks() {
		return repo.findAll();
	}
	
	public List<Tasks> listAllTasksByUserId(int id) throws NoContentAvailableException{
		return repo.findAllByUserId(id);
	}
	
	public List<Tasks> listAllByDueDate(LocalDate date) {
		return repo.findAllByDueDate(date);
	}
	
	public List<Tasks> listAllByStartDate(LocalDate date) {
		return repo.findAllByStartDate(date);
	}
	
	public List<Tasks> listAllByUserIdAndStatus(int id, TaskStatus status) {
		return repo.findByUserIdAndStatus(id, status);
	}
	
	public List<Tasks> listAllTasksByStatus(TaskStatus status) {
		return repo.findAllByStatus(status);
	}
	
	public Optional<Tasks> retrieveById(int id) throws ResourceNotFoundException {
		Optional<Tasks> t = repo.findById(id);
		
		if(t == null) {
			throw new ResourceNotFoundException("Task with id: " + id + " not found");
		}
		
		return t;
	}
	
	public Tasks saveTaskDetails(Tasks task) throws DateMismatchException {
		if(!task.getStartDate().isBefore(task.getDueDate())) {
			throw new DateMismatchException("Start Date should be earlier than Due Date");
		}
		
		return repo.save(task);
	}
	
	public String updateTaskStatus(int id, TaskStatus status) throws ResourceNotFoundException {
		String str = "Unable to update status of task with id: " + id;
		
		Tasks t = repo.findById(id).get();
			
		if(t == null) {
			throw new ResourceNotFoundException("Task with id: " + id + " not found");
		}
		
		int res = repo.updateStatus(id, status);
		
		if(res > 0) {
			str = "Status for task with id: " + id + " updated sucessfully";
		}
		
		
		return str;
	}
	
	public String resetDueDate(int id, LocalDate date) throws DateMismatchException, ResourceNotFoundException {
		String str = "Unable to reset the due date of task with id: " + id;
		
		Tasks t = repo.findById(id).get();
		
		if(t == null) {
			throw new ResourceNotFoundException("Task with id: " + id + " not found");
		}
		
		if(!t.getStartDate().isBefore(date)) {
			throw new DateMismatchException("Start Date should be earlier than Due Date"); 
		}
		
		int res = repo.resetDueDate(id, date);
		if(res > 0) {
			str = "Due Date for task with id: " + id + " updated sucessfully";
		}
		
		return str;
	}
}
