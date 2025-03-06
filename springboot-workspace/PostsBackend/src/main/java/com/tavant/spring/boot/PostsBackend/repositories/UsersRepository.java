package com.tavant.spring.boot.PostsBackend.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tavant.spring.boot.PostsBackend.entity.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long>{
	public Optional<Users> findByUserId(long id);
	public Optional<Users> findByEmail(String email);
	public Optional<Users> findByUsername(String name);
	
	@Modifying
	@Query("update Users u set u.email = :email where u.id=:id")
	public int updateEmail(@Param("id") long id, @Param("email") String email);
	
	@Modifying
	@Query("update Users u set u.password = :password where u.id=:id")
	public int updatePassword(@Param("id") long id, @Param("password") String password);
	
}
