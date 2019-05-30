package service;

import javax.ejb.ApplicationException;

import rest.ErrorMessages;

@ApplicationException
public class AppException extends RuntimeException{
	
	private ErrorMessages error;
	
	public AppException(ErrorMessages error) {
		this.error = error;
	}

	public ErrorMessages getError() {
		return error;
	}

	public void setError(ErrorMessages error) {
		this.error = error;
	}
	
	
	
	

}
