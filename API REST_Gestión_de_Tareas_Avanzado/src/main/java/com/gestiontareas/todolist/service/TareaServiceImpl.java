package com.gestiontareas.todolist.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.gestiontareas.todolist.dto.request.TareaRequestDTO;
import com.gestiontareas.todolist.dto.response.TareaResponseDTO;
import com.gestiontareas.todolist.exception.ResourceNotFoundException;
import com.gestiontareas.todolist.model.EstadoTarea;
import com.gestiontareas.todolist.model.Tarea;
import com.gestiontareas.todolist.model.Usuario;
import com.gestiontareas.todolist.repository.TareaRepository;
import com.gestiontareas.todolist.repository.UsuarioRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import lombok.RequiredArgsConstructor;

@Service // Indica que esta clase es un servicio de Spring
@RequiredArgsConstructor // Genera un constructor con los campos finales
public class TareaServiceImpl implements TareaService {

	private final TareaRepository tareaRepository;
    private final UsuarioRepository usuarioRepository;


	// Método para crear una nueva tarea
	@Override
	public TareaResponseDTO crearTarea(TareaResponseDTO dto) {
		
        Usuario usuario = usuarioRepository.findById(dto.getUsuarioId())
                .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado"));

		Tarea tarea = new Tarea();
		tarea.setTitulo(dto.getTitulo());	// Establece el título de la tarea
		tarea.setDescripcion(dto.getDescripcion());	// Establece la descripción de la tarea
		tarea.setEstado(EstadoTarea.PENDIENTE); // Establece el estado inicial como PENDIENTE
		tarea.setFechaCreacion(LocalDateTime.now()); // Establece la fecha de creación actual
		tarea.setUsuario(usuario);
				
		return mapToDTO(tareaRepository.save(tarea));
	}
	
	// Mapea una entidad Tarea a un DTO de respuesta
	@Override
	public Page<TareaResponseDTO> listarTareasPorUsuario (Long usuarioId, Pageable pageable) {
		
		Page<Tarea> tareasPage = tareaRepository.findByUsuarioId(usuarioId, pageable);
		
		return tareasPage.map(this::mapToDTO);
	}
	
	
	// Método para actualizar una tarea existente
	@Override
	public TareaResponseDTO actualizarTarea(Long id, TareaRequestDTO  dto) {
		Tarea tarea = tareaRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Tarea no encontrada con id: " + id));
		tarea.setTitulo(dto.getTitulo());
		tarea.setDescripcion(dto.getDescripcion());
		
		return mapToDTO(tareaRepository.save(tarea));
	}
	
	// Método para eliminar una tarea por su ID
	@Override
	public void elimarTarea(Long id) {
		Tarea tarea = tareaRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Tarea no encontrada con id: " + id));
		tareaRepository.delete(tarea);		
	}
	
	
	// Método para cambiar el estado de una tarea
	@Override
	public TareaResponseDTO cambiarEstado(Long id, EstadoTarea nuevoEstado) {
		Tarea tarea = tareaRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Tarea no encontrada con id: " + id));
		tarea.setEstado(nuevoEstado);
		
		return mapToDTO(tareaRepository.save(tarea));
	}
	
	//Metodo Mapea una entidad Tarea a un DTO de respuesta
	private TareaResponseDTO mapToDTO(Tarea tarea) {
		TareaResponseDTO dto = new TareaResponseDTO();
		dto.setId(tarea.getId());
		dto.setTitulo(tarea.getTitulo());
		dto.setDescripcion(tarea.getDescripcion());
		dto.setEstado(tarea.getEstado());
		dto.setFechaCreacion(tarea.getFechaCreacion());
		dto.setUsuarioId(tarea.getUsuario().getId());
		return dto;
	}
	
}
