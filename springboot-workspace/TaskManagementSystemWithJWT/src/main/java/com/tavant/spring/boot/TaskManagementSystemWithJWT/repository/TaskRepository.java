package com.tavant.spring.boot.TaskManagementSystemWithJWT.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tavant.spring.boot.TaskManagementSystemWithJWT.entity.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long>{
	public List<Task> findAllByTaskNameContaining(String name);

    public List<Task> findAllByUserId(Long id);
}
