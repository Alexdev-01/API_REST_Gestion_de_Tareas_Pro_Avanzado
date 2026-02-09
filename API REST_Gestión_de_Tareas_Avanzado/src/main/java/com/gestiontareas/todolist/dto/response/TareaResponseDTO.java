package com.gestiontareas.todolist.dto.response;

import java.time.LocalDateTime;
import com.gestiontareas.todolist.model.EstadoTarea;
import lombok.Data;
import com.gestiontareas.todolist.model.EstadoTarea;

//Representa lo que sale por GET al cliente
@Data // Clase DTO para las respuestas de las tareas
public class TareaResponseDTO {
	
	private Long id;
	private String Titulo;
	private String descripcion;
	private EstadoTarea estado;
	private LocalDateTime fechaCreacion;
	private Long usuarioId;

}
