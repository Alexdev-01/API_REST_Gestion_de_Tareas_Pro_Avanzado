package com.gestiontareas.todolist.dto.response;

import java.time.LocalDateTime;
import com.gestiontareas.todolist.model.EstadoTarea;
import lombok.Data;
import com.gestiontareas.todolist.model.EstadoTarea;

@Data  // Anotación de Lombok para generar getters, setters, toString, equals y hashCode automáticamente
// Clase DTO para representar la respuesta de una tarea, con información sobre su id, título, descripción, estado, fecha de creación y el id del usuario al que pertenece
public class TareaResponseDTO {
	
	private Long id;
	private String Titulo;
	private String descripcion;
	private EstadoTarea estado;
	private LocalDateTime fechaCreacion;
	private Long usuarioId;

}
