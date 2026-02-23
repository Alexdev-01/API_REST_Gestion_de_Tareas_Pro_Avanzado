package com.gestiontareas.todolist.exception;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data	// Anotación de Lombok para generar getters, setters, toString, equals y hashCode automáticamente
@AllArgsConstructor // Anotación de Lombok para generar un constructor con todos los campos como parámetros
@NoArgsConstructor 	// Anotación de Lombok para generar un constructor sin parámetros
// Clase para representar la estructura de una respuesta de error, con información sobre la fecha y hora del error, el código de estado HTTP, el mensaje de error, la descripción del error y la ruta de la solicitud que causó el error
public class ErrorResponse { 
	
	private LocalDateTime timestamp;
	private int status;
	private String error;
	private String message;
	private String path;
	
}