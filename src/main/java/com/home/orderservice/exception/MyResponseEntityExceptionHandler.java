package com.home.orderservice.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class MyResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllException(Exception ex, WebRequest request) throws Exception {

		OrderException orderException = new OrderException(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity(orderException, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(OrderNotFoundException.class)
	public final ResponseEntity<Object> handleOrderNotFoundException(OrderNotFoundException ex, WebRequest request)
			throws Exception {

		OrderException orderException = new OrderException(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity(orderException, HttpStatus.NOT_FOUND);
	}
}
