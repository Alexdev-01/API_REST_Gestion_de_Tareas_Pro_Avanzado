package com.gestiontareas.todolist.exception;

// Excepción personalizada para manejar errores de solicitud incorrecta (HTTP 400 Bad Request)
public class BadRequestException extends RuntimeException{
	
	public BadRequestException (String messager) {
		super(messager);
	}
}
