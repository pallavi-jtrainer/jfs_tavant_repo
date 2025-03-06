package com.tavant.spring.boot.PostsBackend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tavant.spring.boot.PostsBackend.entity.Posts;
import com.tavant.spring.boot.PostsBackend.repositories.PostsRepository;

import jakarta.transaction.Transactional;

@Service
public class PostsService {

	@Autowired
	private PostsRepository postsRepo;
	
	public List<Posts> getAllPosts() {
		return postsRepo.findAll();
	}
	
	public List<Posts> getAllPostsByUser(long id) {
		return postsRepo.findByUserId(id);
	}
	
	public Posts getPostByTitle(String title) {
		return postsRepo.findByTitle(title);
	}
	
	public Posts getPostbyId(long id) {
		return postsRepo.findById(id).get();
	}
	
	public Posts savePostDetails(Posts post) {
		return postsRepo.save(post);
	}
	
	@Transactional
	public String updateTitle(long id, String title) {
		String str = "Unable to update title";
		
		int res = postsRepo.updatePostTitle(id, title);
		
		if(res > 0) 
			str = "Updated title for post with id: " + id;
		
		return str;
		
	}
	
	@Transactional
	public String updateBody(long id, String body) {
		String str = "Unable to update body of post";
		
		int res = postsRepo.updatePostBody(id, body);
		
		if(res > 0) 
			str = "Updated body for post with id: " + id;
		
		return str;
	}
 }
