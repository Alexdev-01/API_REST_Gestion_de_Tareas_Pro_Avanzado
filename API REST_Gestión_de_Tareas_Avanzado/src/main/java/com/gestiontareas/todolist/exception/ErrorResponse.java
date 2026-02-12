package com.gestiontareas.todolist.exception;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // Lombok annotation to generate getters, setters, and other utility methods
@AllArgsConstructor // Lombok annotation to generate a constructor with all fields
@NoArgsConstructor // Lombok annotation to generate a no-argument constructor
public class ErrorResponse { 
	
	private LocalDateTime timestamp;
	private int status;
	private String error;
	private String message;
	private String path;
	
}