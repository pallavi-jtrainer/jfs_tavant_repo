package com.tavant.spring.boot.TaskManagementSystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tavant.spring.boot.TaskManagementSystem.entity.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, Integer>{

	public Users findByEmail(String email);
	public Users findByUsername(String name);
	
	@Modifying
	@Query("update Users u set u.password = :pass where u.id = :id")
	public int updatePassword(@Param("id") int id, @Param("pass") String pass);
	
	@Modifying
	@Query("update Users u set u.email = :email where u.id = :id")
	public int updateEmail(@Param("id") int id, @Param("email") String email);
}
