package com.gestiontareas.todolist.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.gestiontareas.todolist.dto.request.TareaRequestDTO;
import com.gestiontareas.todolist.dto.response.TareaResponseDTO;
import com.gestiontareas.todolist.model.EstadoTarea;
import com.gestiontareas.todolist.model.Tarea;

// Interfaz que define los métodos del servicio de tareas. Establece las operaciones que se pueden realizar sobre las tareas.
public interface TareaService {

	// Método para crear una nueva tarea, recibe un objeto TareaRequestDTO con los datos de la tarea a crear y devuelve un objeto TareaResponseDTO con los datos de la tarea creada
	TareaResponseDTO crearTarea(TareaResponseDTO dto);
	
	// Método para listar las tareas de un usuario específico, recibe el ID del usuario y un objeto Pageable para la paginación, y devuelve una página de objetos TareaResponseDTO con los datos de las tareas del usuario
	Page<TareaResponseDTO> listarTareasPorUsuario(Long usuarioId, Pageable pageable);
	
	// Método para actualizar una tarea existente, recibe el ID de la tarea a actualizar y un objeto TareaRequestDTO con los nuevos datos de la tarea, y devuelve un objeto TareaResponseDTO con los datos de la tarea actualizada
	TareaResponseDTO actualizarTarea(Long id, TareaRequestDTO dto);
	
	// Método para eliminar una tarea, recibe el ID de la tarea a eliminar y no devuelve ningún valor
	void elimarTarea(Long id);
	
	// Método para cambiar el estado de una tarea, recibe el ID de la tarea y el nuevo estado a asignar, y devuelve un objeto TareaResponseDTO con los datos de la tarea actualizada con el nuevo estado
	TareaResponseDTO cambiarEstado(Long id, EstadoTarea nuevoEstado);

	// Método para listar todas las tareas con paginación, recibe un objeto Pageable para la paginación y devuelve una página de objetos TareaResponseDTO con los datos de todas las tareas
	Page<TareaResponseDTO> listarTodas(Pageable pageable);
}
