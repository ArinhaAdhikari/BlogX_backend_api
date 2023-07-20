package blogApp.blogX.serviceImpl;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import Payloads.CommentDto;
import blogApp.blogX.entity.Comment;
import blogApp.blogX.entity.Post;
import blogApp.blogX.exception.BlogApiResponseException;
import blogApp.blogX.exception.ResourseNotFoundException;
import blogApp.blogX.repository.CommentRepository;
import blogApp.blogX.repository.PostRepository;
@Service
public class CommentServiceImpl implements CommentService{

	private CommentRepository commentRepository;
	private PostRepository postRepository;

	
	
	public CommentServiceImpl(CommentRepository commentRepository, PostRepository postRepository) {
		super();
		this.commentRepository = commentRepository;
		this.postRepository=postRepository;
	}



	@Override
	public CommentDto createComment(long postId, CommentDto commentDto) {
		// TODO Auto-generated method stub
		Comment comment=mapToEntity(commentDto);
		Post post=postRepository.findById(postId).orElseThrow(()->new ResourseNotFoundException("Post","id", postId));
		comment.setPost(post);
		Comment newComment=commentRepository.save(comment);
		 return mapToDto(newComment);
		
	}
	
	private CommentDto mapToDto(Comment comment)
	{
		CommentDto commentDto=new CommentDto();
		commentDto.setBody(comment.getBody());
		commentDto.setEmail(comment.getEmail());
		commentDto.setId(comment.getId());
		commentDto.setName(comment.getName());
		return commentDto;
	}
	
	private Comment mapToEntity(CommentDto commentDto)
	{
		Comment comment=new Comment();
		comment.setBody(commentDto.getBody());
		comment.setEmail(commentDto.getEmail());
		comment.setId(commentDto.getId());
		comment.setName(commentDto.getName());
		return comment;
	}



	@Override
	public List<CommentDto> getCommentByPostId(long postId) {
		// TODO Auto-generated method stub
		List<Comment> comments= commentRepository.findByPostId(postId);
		return comments.stream().map(comment -> mapToDto(comment)).collect(Collectors.toList());
		}



	@Override
	public CommentDto getCommentById(long postId,long commentId) {
		// TODO Auto-generated method stub
		Post post=postRepository.findById(postId).orElseThrow(()-> new ResourseNotFoundException("post","id",postId));
		
		Comment comment=commentRepository.findById(commentId).orElseThrow(() ->new ResourseNotFoundException("comment", "comment id", commentId));
		if(!comment.getPost().getId().equals(post.getId()))
		{
			throw new BlogApiResponseException(HttpStatus.BAD_REQUEST, "No comment belong to  this post id");
		}
		return mapToDto(comment);
		
		
	}



	@Override
	public CommentDto updateComment(long postId, long commentId, CommentDto updatedComment) {
		// TODO Auto-generated method stub
Post post=postRepository.findById(postId).orElseThrow(()-> new ResourseNotFoundException("post","id",postId));
		
		Comment comment=commentRepository.findById(commentId).orElseThrow(() ->new ResourseNotFoundException("comment", "comment id", commentId));
		if(!comment.getPost().getId().equals(post.getId()))
		{
			throw new BlogApiResponseException(HttpStatus.BAD_REQUEST, "No comment belong to  this post id");
		}
		
		
	comment.setName(updatedComment.getName());
	comment.setBody(updatedComment.getBody());
	comment.setEmail(updatedComment.getEmail());
	Comment newcom= commentRepository.save(comment);
	  return mapToDto(newcom);
	
	}



	@Override
	public void deleteComment(long postId, long commentId) {
		// TODO Auto-generated method stub

Post post=postRepository.findById(postId).orElseThrow(()-> new ResourseNotFoundException("post","id",postId));
		
		Comment comment=commentRepository.findById(commentId).orElseThrow(() ->new ResourseNotFoundException("comment", "comment id", commentId));
		if(!comment.getPost().getId().equals(post.getId()))
		{
			throw new BlogApiResponseException(HttpStatus.BAD_REQUEST, "No comment belong to  this post id");
		}
 commentRepository.delete(comment);
		
	}
	

}
