package Payloads;

import java.util.Set;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PostDto {

	private Long id;
	@NotEmpty
	@Size(min=5 , message="name should contain atleast 5 letter")
	private String title;
	@NotEmpty
	@Size(min=5 , message="description should contain atleast 5 letter")
	private String description;
	@NotEmpty
	@Size(min=5 , message="contain should contain atleast 5 letter")
	private String content;
	private Set<CommentDto> comments;
//	public Long getId() {
//		return id;
//	}
//	public String getTitle() {
//		return title;
//	}
//	public String getDescription() {
//		return description;
//	}
//	public String getContent() {
//		return content;
//	}
//	public void setId(Long id) {
//		this.id = id;
//	}
//	public void setTitle(String title) {
//		this.title = title;
//	}
//	public void setDescription(String description) {
//		this.description = description;
//	}
//	public void setContent(String content) {
//		this.content = content;
//	}
//	
	
}
