package com.cgi.user.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cgi.user.payload.ApiResponse;

//Centralized Exception handler
@RestControllerAdvice
public class GlobalExceptionhandler {
	//response Entity sendind data and code called response Status code
	@ExceptionHandler
	public ResponseEntity<ApiResponse> handlerUserNotFoundException(UserNotFoundException ex){
		String message = ex.getMessage();
		ApiResponse reponse = ApiResponse.builder().message(message).success(true).status(HttpStatus.NOT_FOUND).build(); //builder is building object of a ApiResponse class
		return new ResponseEntity<ApiResponse>(reponse, HttpStatus.NOT_FOUND);
	}

}
