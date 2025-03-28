package com.tavant.spring.boot.TaskManagementSystem.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tavant.spring.boot.TaskManagementSystem.entity.TaskStatus;
import com.tavant.spring.boot.TaskManagementSystem.entity.Tasks;

@Repository
public interface TasksRepository extends JpaRepository<Tasks, Integer>{

	public List<Tasks> findAllByStartDate(LocalDate start);
	public List<Tasks> findAllByDueDate(LocalDate due);
	public List<Tasks> findAllByUserId(int id);
	public List<Tasks> findAllByStatus(TaskStatus status);
	public List<Tasks> findByUserIdAndStatus(int id, TaskStatus status);
	
	@Modifying
	@Query("update Tasks t set t.status = :stat where t.id = :id")
	public int updateStatus(@Param("id") int id, @Param("stat") TaskStatus stat);
	
	@Modifying
	@Query("update Tasks t set t.dueDate = :due where t.id = :id")
	public int resetDueDate(@Param("id") int id, @Param("due") LocalDate due);
}
