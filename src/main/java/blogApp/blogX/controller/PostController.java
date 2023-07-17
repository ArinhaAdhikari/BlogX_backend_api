package blogApp.blogX.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import Payloads.PostDto;
import blogApp.blogX.serviceImpl.PostService;

@RestController
@RequestMapping("/api/posts")
public class PostController {
private PostService postService;

public PostController(PostService postService) {
	super();
	this.postService = postService;
}
@PostMapping
public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto){
	return new ResponseEntity<>(postService.createPost(postDto),HttpStatus.CREATED);
}

@GetMapping
public List<PostDto> getAllPosts()
{
	return postService.getAllPosts();
}

@GetMapping("/{id}")
public ResponseEntity<PostDto> getPostById(@PathVariable Long id)
{
	return ResponseEntity.ok(postService.getPostById(id));
}
	 
}
