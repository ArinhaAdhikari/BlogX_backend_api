package blogApp.blogX.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity

public class Post {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
private String title;
private String description;
private String content;




@Override
public String toString() {
	return "Post [id=" + id + ", title=" + title + ", description=" + description + ", content=" + content + "]";
}
public Post() {
	super();
	// TODO Auto-generated constructor stub
}
public Post(Long id, String title, String description, String content) {
	super();
	this.id = id;
	this.title = title;
	this.description = description;
	this.content = content;
}
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
