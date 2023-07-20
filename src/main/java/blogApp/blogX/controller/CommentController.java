package blogApp.blogX.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Payloads.CommentDto;
import blogApp.blogX.serviceImpl.CommentService;

@RestController
@RequestMapping("/api/")
public class CommentController {
	private CommentService commentService;

	public CommentController(CommentService commentService) {
		super();
		this.commentService = commentService;
	}
@PostMapping("/posts/{postId}/comments")
 public ResponseEntity<CommentDto> createComment(@PathVariable(value= "postId")long postId,
		 @RequestBody CommentDto commentDto){
	 return new ResponseEntity<>(commentService.createComment(postId, commentDto),HttpStatus.CREATED);
 }

@GetMapping("/posts/{postId}/comments")
public List<CommentDto> geCommentByPostId(@PathVariable long postId){
	return commentService.getCommentByPostId(postId);
}
@GetMapping("/posts/{postId}/comments/{commentId}")
public ResponseEntity<CommentDto> getCommentById(@PathVariable long postId, @PathVariable long  commentId)
{
	CommentDto commentDto=commentService.getCommentById(postId, commentId);
return	new ResponseEntity<>(commentDto,HttpStatus.OK);
}

@PutMapping("/posts/{postId}/comments/{commentId}")
public ResponseEntity<CommentDto> updatedComment(@PathVariable long postId,@PathVariable long commentId,@RequestBody CommentDto updatedComment)
{
	CommentDto newComment=commentService.updateComment(postId, commentId, updatedComment);
			return new ResponseEntity<>(newComment,HttpStatus.OK);
}

@DeleteMapping("/posts/{postId}/comments/{commentId}")
public ResponseEntity<String> deleteComment(@PathVariable long postId,@PathVariable  long commentId)
{
	commentService.deleteComment(postId, commentId);
return new ResponseEntity<>("comment deleted",HttpStatus.OK);
}


}
