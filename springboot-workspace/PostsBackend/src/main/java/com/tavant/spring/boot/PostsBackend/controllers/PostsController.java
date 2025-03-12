package com.tavant.spring.boot.PostsBackend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tavant.spring.boot.PostsBackend.entity.Posts;
import com.tavant.spring.boot.PostsBackend.services.PostsService;

@RestController
@RequestMapping("/api")
@CrossOrigin("http://localhost:4200")
public class PostsController {

	@Autowired
	private PostsService service;
	
	@GetMapping("/posts")
	public ResponseEntity<List<Posts>> getAllPosts() {
		return ResponseEntity.ok(service.getAllPosts());
	}
	
	@GetMapping("/posts/user/{id}")
	public ResponseEntity<List<Posts>> getAllPostsForUser(@PathVariable long id) {
		return ResponseEntity.ok(service.getAllPostsByUser(id));
	}
	
	@GetMapping("/post/{id}")
	public ResponseEntity<Posts> getPostById(@PathVariable long id) {
		return ResponseEntity.ok(service.getPostbyId(id));
	}
	
	@GetMapping("/post/title/{title}")
	public ResponseEntity<Posts> getPostByTitle(@PathVariable String title) {
		return ResponseEntity.ok(service.getPostByTitle(title));
	}
	
	@PostMapping("/posts")
	public ResponseEntity<Posts> savePostDetails(@RequestBody Posts post) {
		return ResponseEntity.ok(service.savePostDetails(post));
	}
	
	@PatchMapping("/post/update/{id}/{title}")
	public ResponseEntity<String> updatePostTitle(@PathVariable long id, @PathVariable String title) {
		return ResponseEntity.ok(service.updateTitle(id, title));
	}
	
	@PatchMapping("/post/body/{id}/{body}")
	public ResponseEntity<String> updatePostBody(@PathVariable long id, @PathVariable String body) {
		return ResponseEntity.ok(service.updateBody(id, body));
	}
}
