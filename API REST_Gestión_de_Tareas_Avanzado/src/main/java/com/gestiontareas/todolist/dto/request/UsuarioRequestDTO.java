package com.gestiontareas.todolist.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

// Representa lo que entra por POST o PUT para los usuarios
@Data	// Clase DTO para las solicitudes de creación o actualización de usuarios
public class UsuarioRequestDTO {

	@NotBlank(message = "El nombre es obligatorio")	// El nombre no puede estar vacío
	private String nombre;

	@NotBlank(message = "El email es obligatorio")	// El email no puede estar vacío
	@Email(message = "El email debe tener un formato válido")	// El email debe tener un formato válido
	private String email;
}