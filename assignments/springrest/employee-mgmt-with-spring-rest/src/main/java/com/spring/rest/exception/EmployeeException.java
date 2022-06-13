package com.spring.rest.exception;


	public class EmployeeException extends Exception{
		
		public EmployeeException() {
			super();
		}

		public EmployeeException(String message, Throwable cause) {
			super(message, cause);
		}

		public EmployeeException(String message) {
			super(message);
		}

	}
