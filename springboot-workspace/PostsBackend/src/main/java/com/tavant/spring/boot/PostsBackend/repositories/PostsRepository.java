package com.tavant.spring.boot.PostsBackend.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tavant.spring.boot.PostsBackend.entity.Posts;

@Repository
public interface PostsRepository extends JpaRepository<Posts, Long>{

	public List<Posts> findByUserId(long id);
	public Posts findByTitle(String title);
	
	@Modifying
	@Query("update Posts p set p.title = :title where p.id = :id")
	public int updatePostTitle(@Param("id") long id, @Param("title") String title);
	
	@Modifying
	@Query("update Posts p set p.body = :body where p.id = :id")
	public int updatePostBody(@Param("id") long id, @Param("body") String body);
}
