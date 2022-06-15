package com.example.empapp.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;
@ResponseStatus(HttpStatus.NOT_FOUND)
public class CannotCreateTRansException extends Exception {
	public CannotCreateTRansException(String message) {
		super(message);
	}

}