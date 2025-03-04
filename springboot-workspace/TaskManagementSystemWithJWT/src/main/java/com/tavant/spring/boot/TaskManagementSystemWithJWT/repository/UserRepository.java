package com.tavant.spring.boot.TaskManagementSystemWithJWT.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tavant.spring.boot.TaskManagementSystemWithJWT.entity.User;
import com.tavant.spring.boot.TaskManagementSystemWithJWT.utils.UserRole;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	public Optional<User> findByEmail(String email);
	public Optional<User> findByUserRole(UserRole userRole);
}
