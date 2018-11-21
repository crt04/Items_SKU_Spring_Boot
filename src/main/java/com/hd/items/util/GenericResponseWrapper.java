package com.hd.items.util;

import com.fasterxml.jackson.annotation.JsonInclude;

public class GenericResponseWrapper<T>{


	public T getResult() {
		return result;
	}

	public void setResult(T result) {
		this.result = result;
	}

	@JsonInclude(JsonInclude.Include.NON_NULL)
	public  T result ;



	public  String message ;

	public Integer statusCode;
	
	
	public GenericResponseWrapper() {
		super();
	}
	

	public GenericResponseWrapper(T result) {
		super();
		this.result = result;
	}


	public GenericResponseWrapper(T result, String message) {
		super();
		this.result = result;
		this.message = message;
	}

	public GenericResponseWrapper(T result, String message, Integer statusCode) {
		super();
		this.result = result;
		this.message = message;
		this.statusCode = statusCode;
	}

	public GenericResponseWrapper(String message, Integer statusCode) {
		super();
		this.message = message;
		this.statusCode = statusCode;
	}



	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Integer getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}
}
