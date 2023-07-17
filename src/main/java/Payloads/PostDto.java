package Payloads;

import lombok.Data;

@Data
public class PostDto {

	private Long id;
	private String title;
	private String description;
	private String content;
	public Long getId() {
		return id;
	}
	public String getTitle() {
		return title;
	}
	public String getDescription() {
		return description;
	}
	public String getContent() {
		return content;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	
}
