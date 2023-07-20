package blogApp.blogX.entity;

import org.hibernate.annotations.ManyToAny;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Comment {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
	
private String name;
private String email;
private String body;

@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="post_id", nullable=false)
private Post post;


}
