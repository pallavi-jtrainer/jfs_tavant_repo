package com.sample.spring.boot.SpringBootJWT.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sample.spring.boot.SpringBootJWT.entity.ERole;
import com.sample.spring.boot.SpringBootJWT.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{
	public Optional<Role> findByName(ERole name);
}
