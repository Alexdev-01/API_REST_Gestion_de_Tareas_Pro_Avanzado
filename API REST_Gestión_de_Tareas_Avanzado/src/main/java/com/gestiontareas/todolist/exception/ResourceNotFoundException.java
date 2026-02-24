package com.gestiontareas.todolist.exception;

// Excepción personalizada para manejar errores de recurso no encontrado (HTTP 404 Not Found)
public class ResourceNotFoundException extends RuntimeException {
	
	public ResourceNotFoundException(String message) { 
		super(message);
	}
}
