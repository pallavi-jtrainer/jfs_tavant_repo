package com.tavant.spring.boot.TaskManagementSystemWithJWT.service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tavant.spring.boot.TaskManagementSystemWithJWT.config.JwtUtil;
import com.tavant.spring.boot.TaskManagementSystemWithJWT.dto.TaskDto;
import com.tavant.spring.boot.TaskManagementSystemWithJWT.entity.Task;
import com.tavant.spring.boot.TaskManagementSystemWithJWT.entity.User;
import com.tavant.spring.boot.TaskManagementSystemWithJWT.repository.TaskRepository;
import com.tavant.spring.boot.TaskManagementSystemWithJWT.utils.TaskStatus;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TaskService {
	
	private final TaskRepository repo;
	private final JwtUtil jwtUtil;
	
	public List<TaskDto> getTaskByUserId() {

        User user = jwtUtil.getLoggedInUser();
        if(user != null){
             return repo.findAllByUserId(user.getId())
                    .stream()
                    .sorted(Comparator.comparing(Task::getDueDate).reversed())
                    .map(Task::getTaskDto)
                    .collect(Collectors.toList());
        }
        throw new EntityNotFoundException("User not found");
    }
	
	private TaskStatus mapStringToTaskStatus(String status){
        return switch (status){
            case "PENDING" -> TaskStatus.PENDING;
            case "INPROGRESS" -> TaskStatus.INPROGRESS;
            case "COMPLETED" -> TaskStatus.COMPLETED;
            default -> TaskStatus.CANCELLED;
        };
    }
	
	public TaskDto updateTask(Long id, String status) {
        Optional<Task> optionalTask = repo.findById(id);
        if(optionalTask.isPresent()){
            Task existingTask = optionalTask.get();
            existingTask.setTaskStatus(mapStringToTaskStatus(status));
            return repo.save(existingTask).getTaskDto();
        }
        throw new EntityNotFoundException("Task not found");
    }
	
	public TaskDto getTaskById(Long id) {
        Optional<Task> optionalTask = repo.findById(id);
        return optionalTask.map(Task::getTaskDto).orElse(null);
    }
}
