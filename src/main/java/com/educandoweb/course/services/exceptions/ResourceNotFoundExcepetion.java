package com.educandoweb.course.services.exceptions;

public class ResourceNotFoundExcepetion extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public ResourceNotFoundExcepetion(Object id) {
		super("Resource not found. Id "+id);
	}
	
}
