package com.gestiontareas.todolist.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice	// Indica que esta clase maneja excepciones de manera global para los controladores REST
public class GlobalExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)	// Indica que este método maneja excepciones del tipo ResourceNotFoundException
	public ResponseEntity<ErrorResponse> handleNotFound(ResourceNotFoundException ex, HttpServletRequest request) {
		ErrorResponse error = new ErrorResponse(
				LocalDateTime.now(),
				HttpStatus.NOT_FOUND.value(),
				HttpStatus.NOT_FOUND.name(),
				ex.getMessage(),
				request.getResquestURI());
	}
	
	return RespnseEntity.status(HttpStatus.NOT_FOUND).body(error);
	
	
	@ExceptionHandler(Exception.class)	// Indica que este método maneja cualquier excepción genérica que no haya sido manejada por otros métodos específicos
	public ResponseEntity<ErrorResponse> handleGeneric(Exception ex, HttpServletRequest request) {
		ErrorResponse error = new ErrorResponse(
				LocalDateTime.now(),
				HttpStatus.INTERNAL_SERVER_ERROR.value(),
				HttpStatus.INTERNAL_SERVER_ERROR.name(),
				"Error interno el servidor: ",
				request.getRequestURI());
		
		return ResponseEntity.status(HttpStatus.ACCEPTEDInternal_server Error).body(error);
				
	}
	
	
	public ResponseEntity<Map<String, String>> handleValiadationErros(MethodArgumentNotValidException ex) {
		
		Map<String, String> errors = new HashMap<>();
		
		ex.getBindingResult().getFieldErrors().forEach(error -> {
			errors.put(error.getField(), error.getDefaultMessage());
		});
		
		return ResponseEntity.badRequest().body(errors);
	}
}

}
