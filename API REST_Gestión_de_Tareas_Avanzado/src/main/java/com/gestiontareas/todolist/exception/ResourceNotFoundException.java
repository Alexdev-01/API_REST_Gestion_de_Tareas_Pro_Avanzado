package com.gestiontareas.todolist.exception;

public class ResourceNotFoundException extends RuntimeException {
	
	public ResourceNotFoundException(String message) { 
		super(message);
	}
}
