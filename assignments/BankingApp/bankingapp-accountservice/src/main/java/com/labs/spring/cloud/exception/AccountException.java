package com.labs.spring.cloud.exception;

public class AccountException extends Exception{

	public AccountException() {
		// TODO Auto-generated constructor stub
	}
	public AccountException(String message) {
		super(message);
	}
	public AccountException(String message, Throwable cause) {
		super(message, cause);
	}
}
