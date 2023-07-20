package blogApp.blogX.exception;

import org.springframework.http.HttpStatus;

public class BlogApiResponseException extends RuntimeException {
private HttpStatus status;
private String message;
public BlogApiResponseException(String message, HttpStatus status, String message2) {
	super(message);
	this.status = status;
	message = message2;
}
public BlogApiResponseException(HttpStatus status, String message) {
	super();
	this.status = status;
	this.message = message;
}
public HttpStatus getStatus() {
	return status;
}
public String getMessage() {
	return message;
}
public void setStatus(HttpStatus status) {
	this.status = status;
}
public void setMessage(String message) {
	this.message = message;
}


	
}
