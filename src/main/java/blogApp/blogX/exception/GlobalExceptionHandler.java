package blogApp.blogX.exception;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import Payloads.ErrorDetails;

@RestControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(ResourseNotFoundException.class)
	public ResponseEntity<ErrorDetails> resourseNotFoundException(ResourseNotFoundException e, WebRequest webRequest)
	{
		String msg=e.getMessage();
		return new  ResponseEntity<>(new ErrorDetails(new Date(), msg , false, webRequest.getDescription(false)), HttpStatus.NOT_FOUND);
		//webrequest give the api, true will give client data, so we use false
	}

	// to handel all other non specific type of exception
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails> GeneralisedException (Exception e, WebRequest webRequest)
	{
		String msg=e.getMessage();
		return new  ResponseEntity<>(new ErrorDetails(new Date(), msg , false, webRequest.getDescription(false)), HttpStatus.INTERNAL_SERVER_ERROR);
		//webrequest give the api, true will give client data, so we use false
	}
	

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException ex){
		Map<String, String> errors = new HashMap<>();
		
		BindingResult bindingResult = ex.getBindingResult();
		//BindingResult holds the result of a validation and binding and contains errors that may have occurred. The BindingResult must come right after the model object that is validated or else Spring fails to validate the object and throws an exception.
		
		bindingResult.getAllErrors().forEach(err->{
			String field = ((FieldError)err).getField();//this is the key,like age, name, email,general format type.fieldname.object
			String message = err.getDefaultMessage();
			errors.put(field, message);
		});
		return new ResponseEntity<Map<String,String>>(errors,HttpStatus.NOT_ACCEPTABLE);
	}
	
	@ExceptionHandler(BlogApiResponseException.class)
	public ResponseEntity<ErrorDetails> BlogApiResponseException(BlogApiResponseException e, WebRequest webRequest)
	{
		String msg=e.getMessage();
		return new  ResponseEntity<>(new ErrorDetails(new Date(), msg , false, webRequest.getDescription(false)), HttpStatus.BAD_REQUEST);
		//webrequest give the api, true will give client data, so we use false
	}
	
	
	@ExceptionHandler(AccessDeniedException.class)
	public ResponseEntity<ErrorDetails> AccessDeniedException(AccessDeniedException e, WebRequest webRequest)
	{
		String msg=e.getMessage();
		return new  ResponseEntity<>(new ErrorDetails(new Date(), msg , false, webRequest.getDescription(false)), HttpStatus.UNAUTHORIZED);
		//webrequest give the api, true will give client data, so we use false
	}
	
	


}
