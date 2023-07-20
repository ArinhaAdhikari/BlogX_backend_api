package blogApp.blogX.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import blogApp.blogX.entity.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long>{
List<Comment> findByPostId(long PostId);
}
