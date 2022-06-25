package com.labs.spring.cloud.exception;

import java.sql.SQLException;

import org.hibernate.exception.JDBCConnectionException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//@SuppressWarnings("serial")
//public class CannotCreateTransactionException extends JDBCConnectionException, SqlException {
//	public CannotCreateTransactionException(String exception) {
//		super(exception);		
//	}
//}

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CannotCreateTransactionException extends Exception {
	public CannotCreateTransactionException(String message) {
		super(message);
	}

}