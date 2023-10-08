package com.cgi.user.exception;

public class UserNotFoundException extends RuntimeException{
	public UserNotFoundException() {
		super("User Not Found on server");
	}
	public UserNotFoundException(String message) {
		super(message);
	}
}
