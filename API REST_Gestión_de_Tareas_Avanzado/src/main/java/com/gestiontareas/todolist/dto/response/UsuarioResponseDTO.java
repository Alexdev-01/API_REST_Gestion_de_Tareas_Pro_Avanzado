package com.gestiontareas.todolist.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data	// Genera getters, setters, toString, equals y hashCode automáticamente
@AllArgsConstructor	// Genera un constructor con todos los campos como parámetros
@NoArgsConstructor	// Genera un constructor sin parámetros
// DTO de respuesta para el usuario, utilizado para enviar datos al cliente sin exponer información sensible
public class UsuarioResponseDTO {

	private Long id;
	private String nombre;
	private String email;
	
	
	
}
