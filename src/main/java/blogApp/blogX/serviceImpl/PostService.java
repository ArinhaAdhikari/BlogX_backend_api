package blogApp.blogX.serviceImpl;

import java.util.List;

import Payloads.PostDto;
import Payloads.PostResponse;
import blogApp.blogX.entity.Post;

public interface PostService {
PostDto createPost(PostDto postDto);
PostResponse getAllPosts(int pageNo, int pageSize, String sortByArg,String sortDir);
PostDto getPostById(Long id);
PostDto updatePost(PostDto postDto,Long id);
void deleteById(Long id);
}
