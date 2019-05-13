package com.webservices.exception;

public class ItemNotFoundException extends Exception {

	private static final long serialVersionUID = 4351720088030656859L;
	private int errorId;

	public int getErrorId() {
		return errorId;
	}

	public ItemNotFoundException(String msg) {
		super(msg);
		
	}

	public ItemNotFoundException(String msg, Throwable cause) {
		super(msg, cause);
	}
}