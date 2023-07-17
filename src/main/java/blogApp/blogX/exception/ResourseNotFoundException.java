package blogApp.blogX.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourseNotFoundException extends RuntimeException{
private String resourceName;
private String fieldName;
private String fieldValue;
private Long fieldVal;
public ResourseNotFoundException(String resourceName, String fieldName, String fieldValue) {
	super(String.format("%s not found with %s:%s",resourceName,fieldName,fieldValue));
	this.resourceName = resourceName;
	this.fieldName = fieldName;
	this.fieldValue = fieldValue;
}

public ResourseNotFoundException(String resourceName, String fieldName, Long fieldVal) {
	super(String.format("%s not found with %s:%s",resourceName,fieldName,fieldVal));
	this.resourceName = resourceName;
	this.fieldName = fieldName;
	this.fieldVal = fieldVal;
}

public String getResourceName() {
	return resourceName;
}
public String getFieldName() {
	return fieldName;
}
public String getFieldValue() {
	return fieldValue;
}
public Long getFieldVal() {
	return fieldVal;
}





}

