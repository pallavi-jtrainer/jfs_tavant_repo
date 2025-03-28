package com.sample.spring.boot.SpringBootJWT.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sample.spring.boot.SpringBootJWT.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	public Optional<User> findByUsername(String username);
	public Optional<User> findByEmail(String email);
	public Boolean existsByUsername(String username);
	public Boolean existsByEmail(String email);
}
