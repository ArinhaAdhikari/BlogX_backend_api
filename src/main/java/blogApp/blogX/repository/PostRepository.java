package blogApp.blogX.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import blogApp.blogX.entity.Post;

public interface PostRepository extends JpaRepository<Post, Long> {

}
