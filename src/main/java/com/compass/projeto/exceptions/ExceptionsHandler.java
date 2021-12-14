package com.compass.projeto.exceptions;

import java.util.NoSuchElementException;

import javax.el.MethodNotFoundException;
import javax.persistence.EntityNotFoundException;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.HttpClientErrorException.Forbidden;
import org.springframework.web.client.HttpClientErrorException.Unauthorized;

@ControllerAdvice
public class ExceptionsHandler{

	
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Object> exceptionValidation(MethodArgumentNotValidException exception){
		return new ResponseEntity<>(new ExceptionResponse(exception.getFieldError().getField(), HttpStatus.BAD_REQUEST.value(), exception.getFieldError().getDefaultMessage()), HttpStatus.BAD_REQUEST);
	}
	
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<Object> exceptionNoSuchElement(NoSuchElementException exception){
		return new ResponseEntity<>(new ExceptionResponse(HttpStatus.NOT_FOUND.value(), exception.getMessage()), HttpStatus.NOT_FOUND);
	}

	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	@ExceptionHandler(MethodNotFoundException.class)
	public ResponseEntity<Object> exceptionMethodNotFound(MethodNotFoundException exception){
		return new ResponseEntity<>(new ExceptionResponse(HttpStatus.NOT_FOUND.value(), exception.getMessage()), HttpStatus.NOT_FOUND);
	}
	
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity<Object> exceptionEntityNotFound(EntityNotFoundException exception){
		return new ResponseEntity<>(new ExceptionResponse(HttpStatus.NOT_FOUND.value(), exception.getMessage()), HttpStatus.NOT_FOUND);
	}
	
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	@ExceptionHandler(EmptyResultDataAccessException.class)
	public ResponseEntity<Object> exceptionEmptyResultDataAccess(EmptyResultDataAccessException exception){
		return new ResponseEntity<>(new ExceptionResponse(HttpStatus.NOT_FOUND.value(), exception.getMessage()), HttpStatus.NOT_FOUND);
	}
	
	@ResponseStatus(code = HttpStatus.METHOD_NOT_ALLOWED)
	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
	public ResponseEntity<Object> exceptionMethodNotSupported(HttpRequestMethodNotSupportedException exception){
		return new ResponseEntity<>(new ExceptionResponse(HttpStatus.METHOD_NOT_ALLOWED.value(), exception.getMessage()), HttpStatus.METHOD_NOT_ALLOWED);
	}
	
	@ResponseStatus(code = HttpStatus.UNAUTHORIZED)
	@ExceptionHandler(Unauthorized.class)
	public ResponseEntity<Object> exceptionUnauthorized(Unauthorized exception){
		return new ResponseEntity<>(new ExceptionResponse(HttpStatus.UNAUTHORIZED.value(), exception.getMessage()), HttpStatus.UNAUTHORIZED);
	}
	
	@ResponseStatus(code = HttpStatus.FORBIDDEN)
	@ExceptionHandler(Forbidden.class)
	public ResponseEntity<Object> exceptionForbidden(Forbidden exception){
		return new ResponseEntity<>(new ExceptionResponse(HttpStatus.FORBIDDEN.value(), exception.getMessage()), HttpStatus.FORBIDDEN);
	}
}
