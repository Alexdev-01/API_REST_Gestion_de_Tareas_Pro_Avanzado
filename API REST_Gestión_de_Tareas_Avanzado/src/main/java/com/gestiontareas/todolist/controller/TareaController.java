package com.gestiontareas.todolist.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gestiontareas.todolist.dto.request.TareaRequestDTO;
import com.gestiontareas.todolist.dto.response.TareaResponseDTO;
import com.gestiontareas.todolist.model.EstadoTarea;
import com.gestiontareas.todolist.model.Tarea;
import com.gestiontareas.todolist.service.TareaService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

/*Este Controller:
 * recibe HTTP
 * llama al service
 * devuelve respuesta*/


@RestController	// Indica que esta clase es un controlador REST de Spring
@RequestMapping("/api/tareas")	// Define la ruta base para las solicitudes de este controlador
@RequiredArgsConstructor	// Genera un constructor con los campos finales
public class TareaController {
	
	private final TareaService tareaService;
	
	// Método para crear una nueva tarea
	@PostMapping
	public ResponseEntity<TareaResponseDTO> crearTarea(@Valid @RequestBody TareaResponseDTO dto) {	// @Valid indica que se deben validar las restricciones del DTO; @RequestBody indica que el cuerpo de la solicitud se mapea al objeto dto
		return ResponseEntity.status(HttpStatus.CREATED).body(tareaService.crearTarea(dto));
	}
	
	// Método para listar todas las tareas de un usuario específico
	@GetMapping("/usuario/{usuarioID}")
	public ResponseEntity<List<TareaResponseDTO>> listaPorUsuario(@PathVariable Long usuarioID) {	// @PathVariable indica que el valor de la variable de ruta se mapea al parámetro usuarioID
		return  ResponseEntity.ok(tareaService.listarTareasPorUsuario(usuarioID));
	}
	
	// Método para actualizar una tarea existente
	@PutMapping("/{id}")
	public ResponseEntity<TareaResponseDTO> actualizarTarea(@PathVariable Long id, @Valid @RequestBody TareaRequestDTO dto) { 	// @PathVariable indica que el valor de la variable de ruta se mapea al parámetro id; @Valid indica que se deben validar las restricciones del DTO; @RequestBody indica que el cuerpo de la solicitud se mapea al objeto dto
	    return ResponseEntity.ok(tareaService.actualizarTarea(id, dto));
	}
	
	// Método para eliminar una tarea por su ID
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminarTarea(@PathVariable Long id) {	// @PathVariable indica que el valor de la variable de ruta se mapea al parámetro id
		tareaService.elimarTarea(id);
		return ResponseEntity.noContent().build();
	}
	
	// Método para cambiar el estado de una tarea
	@PatchMapping("/{id}/estado")
	public ResponseEntity<TareaResponseDTO> cambiarEstado(@PathVariable Long id, @RequestParam EstadoTarea estado) {	// @PathVariable indica que el valor de la variable de ruta se mapea al parámetro id; @RequestParam indica que el valor del parámetro de consulta se mapea al parámetro estado
		return ResponseEntity.ok(tareaService.cambiarEstado(id, estado));
	}
	
	@GetMapping("/usuario/{usuarioId}")  // Define una ruta para listar tareas por usuario con paginación
	// Este método captura el ID del usuario de la ruta y los parámetros de paginación, llama al servicio para obtener las tareas paginadas y devuelve una respuesta con el estado HTTP 200 (OK) y el contenido de la página de tareas
	public ResponseEntity<Page<TareaResponseDTO>> listar(@PathVariable Long usuarioId, Pageable pageable) {	// @PathVariable indica que el valor de la variable de ruta se mapea al parámetro usuarioId; Pageable es un objeto que contiene información sobre la paginación y ordenamiento de los resultados
		
		return ResponseEntity.ok(tareaService.listarTareasPorUsuario(usuarioId, pageable));
	} 

}
