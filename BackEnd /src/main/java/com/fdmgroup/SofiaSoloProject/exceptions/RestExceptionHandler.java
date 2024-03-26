package com.fdmgroup.SofiaSoloProject.exceptions;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;


import com.fdmgroup.SofiaSoloProject.exceptions.ApiErrorResponse;

import org.springframework.http.HttpStatus;

@RestControllerAdvice
public class RestExceptionHandler {
	
	/* Have to use these next lines of code for every exception you create */
	
	// The exception we want to handle
	@ExceptionHandler(NotFoundException.class)
	// The HTTP status you want associated - eg. 404 in this case
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ApiErrorResponse handle(NotFoundException e) {
		
		return new ApiErrorResponse(e.getMessage());
	
	}
	
	
	@ExceptionHandler(NotAllowedException.class)
	@ResponseStatus(HttpStatus.FORBIDDEN)
	public ApiErrorResponse handle(NotAllowedException e) {
		
		return new ApiErrorResponse(e.getMessage());
	
	}

}
