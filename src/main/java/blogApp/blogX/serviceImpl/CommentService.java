package blogApp.blogX.serviceImpl;

import java.util.List;

import Payloads.CommentDto;

public interface CommentService {
CommentDto createComment(long postId,CommentDto commentDto);
List<CommentDto> getCommentByPostId(long postId);
CommentDto getCommentById(long postId,long commentId);
CommentDto updateComment(long postId, long commentId, CommentDto updatedComment);
void deleteComment(long postId, long commentId );
}
