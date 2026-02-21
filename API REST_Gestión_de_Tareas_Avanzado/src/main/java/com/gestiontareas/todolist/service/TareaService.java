package com.gestiontareas.todolist.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.gestiontareas.todolist.dto.request.TareaRequestDTO;
import com.gestiontareas.todolist.dto.response.TareaResponseDTO;
import com.gestiontareas.todolist.model.EstadoTarea;
import com.gestiontareas.todolist.model.Tarea;

public interface TareaService {
	//TareaResponseDTO crear(TareaRequestDTO dto);

	TareaResponseDTO crearTarea(TareaResponseDTO dto);
	
	Page<TareaResponseDTO> listarTareasPorUsuario(Long usuarioId, Pageable pageable);
	
	TareaResponseDTO actualizarTarea(Long id, TareaRequestDTO dto);
	
	void elimarTarea(Long id);
	
	TareaResponseDTO cambiarEstado(Long id, EstadoTarea nuevoEstado);

	Page<TareaResponseDTO> listarTodas(Pageable pageable);
}
