package Payloads;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PostResponse {
	private List<PostDto> content;
	private int pageNo;
	private int pageSize;
	private int totalPages;
	private long totalElements;
	private boolean last;
	

}
