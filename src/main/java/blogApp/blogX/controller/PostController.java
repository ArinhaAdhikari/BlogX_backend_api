package blogApp.blogX.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import Payloads.PostDto;
import Payloads.PostResponse;
import blogApp.blogX.serviceImpl.PostService;
import blogApp.blogX.utility.AppConstants;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/posts")
public class PostController {
private PostService postService;

public PostController(PostService postService) {
	super();
	this.postService = postService;
}
@PreAuthorize("hasRole('ADMIN')")
@PostMapping
public ResponseEntity<PostDto> createPost(@Valid @RequestBody PostDto postDto){
	return new ResponseEntity<>(postService.createPost(postDto),HttpStatus.CREATED);
}

@GetMapping
public PostResponse getAllPosts(
		@RequestParam(value="pageNo", defaultValue=AppConstants.DEFAULT_PAGE_NUMBER ,required=false)int pageNo,
		@RequestParam(value="pageSize", defaultValue=AppConstants.DEFAULT_PAGE_SIZE, required=false)int pageSize,
		@RequestParam(value="sortByArg", defaultValue=AppConstants.DEFAULT_SORT_BY ,required=false)String sortByArg,
		@RequestParam(value="sortDir", defaultValue=AppConstants.DEFAULT_SORT__DIRECTION ,required=false)String sortDir
		)

{
	return postService.getAllPosts(pageNo,pageSize,sortByArg,sortDir);
}

@GetMapping("/{id}")
public ResponseEntity<PostDto> getPostById(@PathVariable Long id)
{
	return ResponseEntity.ok(postService.getPostById(id));
}

@PreAuthorize("hasRole('ADMIN')")
@PutMapping("/{id}")
public ResponseEntity<PostDto> updatePost(@Valid @RequestBody PostDto postDto,@PathVariable(name="id") Long id)
{
	PostDto postResponse=postService.updatePost(postDto, id);
	return new ResponseEntity<>(postResponse,HttpStatus.OK);
}

@PreAuthorize("hasRole('ADMIN')")
@DeleteMapping("/{id}")
public ResponseEntity<String> deletePost(@PathVariable Long id)
{
	postService.deleteById(id);
	return new ResponseEntity<>("post deleted successfully", HttpStatus.OK);
	
}
	 
}
