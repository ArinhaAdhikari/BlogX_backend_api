package Payloads;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CommentDto {

	private long id;
	@NotEmpty
	@Size(min=5 , message="name should contain atleast 5 letter")
	private String name;
	@NotEmpty
	
	private String email;
	@NotEmpty
	private String body;
}
