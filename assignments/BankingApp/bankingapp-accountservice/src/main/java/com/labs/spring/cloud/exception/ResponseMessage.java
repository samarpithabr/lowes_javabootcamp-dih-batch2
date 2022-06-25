package com.labs.spring.cloud.exception;

public class ResponseMessage {
//  private String code;
//  public String getCode() {
//		return code;
//	}
//	public void setCode(String code) {
//		this.code = code;
//	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	private String message;
	
	private String status;
		
	public ResponseMessage() {
		
	}

	public ResponseMessage(String status, String message) {
		super();
		this.status = status;
		this.message = message;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	

}
