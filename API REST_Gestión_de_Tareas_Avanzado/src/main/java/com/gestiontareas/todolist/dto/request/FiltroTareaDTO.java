package com.gestiontareas.todolist.dto.request;

import com.gestiontareas.todolist.model.EstadoTarea;

import lombok.Data;

// DTO para filtrar tareas según ciertos criterios, como estado, usuario asignado o título
@Data  // Anotación de Lombok para generar getters, setters, toString, equals y hashCode automáticamente
public class FiltroTareaDTO {
	private EstadoTarea estado;
	private Long usuarioId;
	private String titulo;

}
