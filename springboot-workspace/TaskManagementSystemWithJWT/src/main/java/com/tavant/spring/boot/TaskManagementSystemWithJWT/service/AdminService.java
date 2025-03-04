package com.tavant.spring.boot.TaskManagementSystemWithJWT.service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.tavant.spring.boot.TaskManagementSystemWithJWT.config.JwtUtil;
import com.tavant.spring.boot.TaskManagementSystemWithJWT.dto.TaskDto;
import com.tavant.spring.boot.TaskManagementSystemWithJWT.dto.UserDto;
import com.tavant.spring.boot.TaskManagementSystemWithJWT.entity.Task;
import com.tavant.spring.boot.TaskManagementSystemWithJWT.entity.User;
import com.tavant.spring.boot.TaskManagementSystemWithJWT.repository.TaskRepository;
import com.tavant.spring.boot.TaskManagementSystemWithJWT.repository.UserRepository;
import com.tavant.spring.boot.TaskManagementSystemWithJWT.utils.TaskStatus;
import com.tavant.spring.boot.TaskManagementSystemWithJWT.utils.UserRole;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AdminService {
	private final UserRepository userRepository;
    private final TaskRepository taskRepository;
    
    private TaskStatus mapStringToTaskStatus(String status){
        return switch (status){
            case "PENDING" -> TaskStatus.PENDING;
            case "INPROGRESS" -> TaskStatus.INPROGRESS;
            case "COMPLETED" -> TaskStatus.COMPLETED;
            default -> TaskStatus.CANCELLED;
        };
    }

    public List<TaskDto> searchTaskByTaskName(String title) {
        return taskRepository.findAllByTaskNameContaining(title)
                .stream()
                .sorted(Comparator.comparing(Task::getDueDate).reversed())
                .map(Task::getTaskDto)
                .collect(Collectors.toList());
    }
    
    public List<UserDto> getUsers() {
        return userRepository.findAll()
                .stream()
                .filter(user -> user.getUserRole() == UserRole.EMPLOYEE)
                .map(User::getUserDto)
                .collect(Collectors.toList());
    }
    
    public TaskDto createTask(TaskDto taskDto) {
        Optional<User> optionalUser = userRepository.findById(taskDto.getUserId());
        if(optionalUser.isPresent()){
            Task task = new Task();
            task.setTaskName(taskDto.getTaskName());
            task.setDueDate(taskDto.getDueDate());
            task.setTaskStatus(TaskStatus.INPROGRESS);
            task.setUser(optionalUser.get());
            return taskRepository.save(task).getTaskDto();
        }
        return null;
    }
    
    public List<TaskDto> getAllTasks() {
        return taskRepository.findAll()
                .stream()
                .sorted(Comparator.comparing(Task::getDueDate).reversed())
                .map(Task::getTaskDto)
                .collect(Collectors.toList());
    }
    
    public TaskDto updateTask(Long id, TaskDto taskDto) {

        Optional<Task> optionalTask = taskRepository.findById(id);
        Optional<User> optionalUser = userRepository.findById(taskDto.getUserId());
        if(optionalTask.isPresent() && optionalUser.isPresent()){
            Task existingTask = optionalTask.get();
            existingTask.setTaskName(taskDto.getTaskName());
            existingTask.setDueDate(taskDto.getDueDate());
            existingTask.setTaskStatus(mapStringToTaskStatus(String.valueOf(taskDto.getTaskStatus())));
            existingTask.setUser(optionalUser.get());
            return taskRepository.save(existingTask).getTaskDto();
        }
        return null;
    }
    
    public TaskDto getTaskById(Long id) {

        Optional<Task> optionalTask = taskRepository.findById(id);
        return optionalTask.map(Task::getTaskDto).orElse(null);
    }

}
