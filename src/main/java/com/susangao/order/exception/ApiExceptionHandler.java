package com.susangao.order.exception;

import java.time.ZoneId;
import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler {
	@ExceptionHandler(value = {OrderServiceException.class})
	public ResponseEntity<Object> handleApiRequestException(OrderServiceException e){
		//1. Create payload containing exception details
		HttpStatus badRequest = HttpStatus.BAD_REQUEST;
		ApiException apiException = new ApiException(e.getMessage(),
				         HttpStatus.BAD_REQUEST,
				         ZonedDateTime.now(ZoneId.of("Z"))
		                 );
		//2. return response entity
		return new ResponseEntity<>(apiException, badRequest);
	}
}
