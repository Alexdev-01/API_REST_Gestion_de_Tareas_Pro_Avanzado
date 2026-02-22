package com.gestiontareas.todolist.dto.request;

import lombok.Data;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

// Representa lo que entra por POST o PUT para las tareas
@Data // Clase DTO para las solicitudes de creación o actualización de tareas
public class TareaRequestDTO {
	
	@NotBlank // El título no puede estar vacío
	private String Titulo;
	
	private String descripcion;
	
	@NotNull // El estado no puede ser null
	private Long usuarioId;

}
