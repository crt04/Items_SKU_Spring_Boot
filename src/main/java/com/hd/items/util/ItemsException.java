package com.hd.items.util;

public class ItemsException extends Exception {

    private static final long serialVersionUID = 1L;
    private Integer errorCode;
	public ItemsException() {
		super();
	}

	public ItemsException(String msg, Throwable cause) {
		super(msg, cause);
		
	}
	public ItemsException(String msg, Throwable cause,Integer errorCode) {
		super(msg, cause);
		this.errorCode=errorCode;
	}
	
	public ItemsException(String message) {
		super(message);
	}

	public ItemsException(Throwable cause) {
		super(cause);
	}

	public Integer getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(Integer errorCode) {
		this.errorCode = errorCode;
	}

}