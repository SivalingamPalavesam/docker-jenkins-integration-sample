package com.docker.exception;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomException  extends RuntimeException
{
	private HttpStatus httpStatus;

	  public CustomException(String message, HttpStatus httpStatus)
	  {
	    super(message);
	    this.httpStatus = httpStatus;
	  }

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}
	  

}
