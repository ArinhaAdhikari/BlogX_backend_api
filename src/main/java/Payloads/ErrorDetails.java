package Payloads;

import java.util.Date;
 
public class ErrorDetails {

	private Date date;
	private String message;
	private boolean status;
	private String apiLink;
	public ErrorDetails(Date date, String message, boolean status, String apiLink) {
		super();
		this.date = date;
		this.message = message;
		this.status = status;
		this.apiLink = apiLink;
	}
	public Date getDate() {
		return date;
	}
	public String getMessage() {
		return message;
	}
	public boolean getStatus() {
		return status;
	}
	public String getApiLink() {
		return apiLink;
	}
	
	
	
}
