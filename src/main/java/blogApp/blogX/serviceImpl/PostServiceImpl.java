package blogApp.blogX.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import Payloads.PostDto;
import blogApp.blogX.entity.Post;
import blogApp.blogX.exception.ResourseNotFoundException;
import blogApp.blogX.repository.PostRepository;
@Service
public class PostServiceImpl implements PostService {

	private PostRepository postRepository;
	
	public PostServiceImpl(PostRepository postRepository) {
		super();
		this.postRepository = postRepository;
	}

	@Override
	public PostDto createPost(PostDto postDto) {
		// TODO Auto-generated method stub
		// converting DTO to entity, createpost send postdto type, repo accepts post type, so postdto is converted
		//to post, saved to repo, then newpost is converted to Dto type ,responseentity takes body , statuscode.
		Post post =mapToEntity(postDto);
		Post newPost=postRepository.save(post);
		//converting entity to DTO
		PostDto postResponse=mapToDTO(newPost);
		return postResponse;
	}

	@Override
	public List<PostDto> getAllPosts() {
		// TODO Auto-generated method stub
	List<Post> posts=postRepository.findAll();
	 return posts.stream().map(post -> mapToDTO(post)).collect(Collectors.toList());
	}
	
	//convert dto to entity
	private Post mapToEntity(PostDto postDto)
	{
		Post post=new Post();
		post.setTitle(postDto.getTitle());
		post.setContent(postDto.getContent());
		post.setDescription(postDto.getDescription());
		return post;
	}
	//convert entity to dto
	private PostDto mapToDTO(Post post)
	{
				PostDto postDto=new PostDto();
				postDto.setId(post.getId());
				postDto.setContent(post.getContent());
				postDto.setDescription(post.getDescription());
				postDto.setTitle(post.getTitle());
				
				return postDto;
				
	}

	@Override
	public PostDto getPostById(Long id) {
		// TODO Auto-generated method stub
		Post post=postRepository.findById(id).orElseThrow(()-> new ResourseNotFoundException("post","id",id));
		return mapToDTO(post);
		}

	
	

}
