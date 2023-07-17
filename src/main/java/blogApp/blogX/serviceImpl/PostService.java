package blogApp.blogX.serviceImpl;

import java.util.List;

import Payloads.PostDto;
import blogApp.blogX.entity.Post;

public interface PostService {
PostDto createPost(PostDto postDto);
List<PostDto> getAllPosts();
PostDto getPostById(Long id);
}
