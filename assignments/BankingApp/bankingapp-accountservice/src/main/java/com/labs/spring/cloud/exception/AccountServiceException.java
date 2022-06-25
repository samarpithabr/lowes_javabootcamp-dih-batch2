package com.labs.spring.cloud.exception;

public class AccountServiceException extends RuntimeException {

    private String code;
    private String message;

    public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public AccountServiceException(String message) {
        super(message);
    }
}
