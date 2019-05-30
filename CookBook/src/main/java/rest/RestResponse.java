package rest;

import javax.xml.bind.annotation.XmlRootElement;



@XmlRootElement
public class RestResponse {
	
	
	private int statusCode;
	private String statusMessage;
	
	
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	
	public int getStatusCode() {
		return statusCode;
	}
	
	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}
	
	public String getStatusMessage() {
		return statusMessage;
	}
	
	public void setRestResponse(ErrorMessages em) {
		
		this.setStatusCode(em.getCode());
		this.setStatusMessage(em.getMessage());;
	}
}
