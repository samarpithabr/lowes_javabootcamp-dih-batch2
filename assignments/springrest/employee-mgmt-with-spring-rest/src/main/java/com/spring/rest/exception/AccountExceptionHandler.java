package com.spring.rest.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.spring.rest.model.ResponseMessage;

@ControllerAdvice
public class AccountExceptionHandler {
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ResponseMessage> handleGenericErrors(Exception ex) {
		ResponseMessage response = new ResponseMessage("Failure",ex.getMessage());
		return ResponseEntity.internalServerError().body(response);
		 
	}

}
