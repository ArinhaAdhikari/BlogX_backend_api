package blogApp.blogX.serviceImpl;


import java.util.List;
import java.util.stream.Collectors;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import Payloads.PostDto;
import Payloads.PostResponse;
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
	public PostResponse getAllPosts(int pageNo, int pageSize, String sortByArg,String sortDir) {
		// TODO Auto-generated method stub
		//check if sorting is asending wise or decending based on val passed 
		Sort sort=sortDir.equalsIgnoreCase(Sort.Direction.ASC.name())?Sort.by(sortByArg).ascending():Sort.by(sortByArg).descending();
		
		Pageable pageable= PageRequest.of(pageNo, pageSize,sort);
		
	Page<Post> posts=postRepository.findAll(pageable);
	
	//to get content for page obj
	List<Post> ListofPosts=posts.getContent();
	List<PostDto> content= ListofPosts.stream().map(post -> mapToDTO(post)).collect(Collectors.toList());
	PostResponse postResponse= new PostResponse();
	postResponse.setContent(content);
	postResponse.setPageNo(posts.getNumber());
	postResponse.setPageSize(posts.getSize());
	postResponse.setTotalElements(posts.getTotalElements());
	postResponse.setTotalPages(posts.getTotalPages());
	postResponse.setLast(posts.isLast());
	
	return postResponse;
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

	@Override
	public PostDto updatePost(PostDto postDto, Long id) {
		// TODO Auto-generated method stub
		Post post=postRepository.findById(id).orElseThrow(()-> new ResourseNotFoundException("post","id",id));
		post.setTitle(postDto.getTitle());
		post.setContent(postDto.getContent());
		post.setDescription(postDto.getDescription());
		Post updatedpost=postRepository.save(post);
		return mapToDTO(updatedpost);
	}

	@Override
	public void deleteById(Long id) {
		Post post=postRepository.findById(id).orElseThrow(()-> new ResourseNotFoundException("post", "id", id));	
		postRepository.delete(post);
	
	}

	
	

}
