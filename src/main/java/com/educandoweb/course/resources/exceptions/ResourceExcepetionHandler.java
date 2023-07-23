package com.educandoweb.course.resources.exceptions;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.educandoweb.course.services.exceptions.DataBaseException;
import com.educandoweb.course.services.exceptions.ResourceNotFoundExcepetion;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice // vai entercipar as expcetion que acontecerem para que eu consiga fazer o tratamento
public class ResourceExcepetionHandler {
	
	@ExceptionHandler(ResourceNotFoundExcepetion.class) // capaz de entercipa para poder cair aqui dentro  
	public ResponseEntity<StandarError> resourceNotFound(ResourceNotFoundExcepetion e, HttpServletRequest request ){
		String error = "Resource not found";
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandarError err = new StandarError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(err);
		
		
	}
	@ExceptionHandler(DataBaseException.class)
	public ResponseEntity<StandarError> DataBase( DataBaseException e, HttpServletRequest request ){
		String error = "DataBase error";
		HttpStatus status = HttpStatus.BAD_REQUEST;
		StandarError err = new StandarError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(err);
		
		
	}
}
