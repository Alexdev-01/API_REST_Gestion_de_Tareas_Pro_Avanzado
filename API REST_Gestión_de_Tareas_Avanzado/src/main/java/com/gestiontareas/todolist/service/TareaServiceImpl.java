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
// Implementación de la interfaz TareaService, que contiene la lógica de negocio para gestionar las tareas. Esta clase utiliza los repositorios para interactuar con la BBDD y realizar las operaciones definidas en la interfaz.
public class TareaServiceImpl implements TareaService {

	private final TareaRepository tareaRepository;
    private final UsuarioRepository usuarioRepository;

	@Override
	// Método para crear una nueva tarea. Recibe un DTO con los datos de la tarea a crear, busca el usuario asociado y guarda la tarea en la base de datos, devolviendo un DTO con los datos de la tarea creada.
	public TareaResponseDTO crearTarea(TareaResponseDTO dto) {
		
		// Busca el usuario asociado a la tarea utilizando el ID del usuario proporcionado en el DTO. Si el usuario no existe, lanza una excepción ResourceNotFoundException.
        Usuario usuario = usuarioRepository.findById(dto.getUsuarioId())
                .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado"));

		Tarea tarea = new Tarea();
		tarea.setTitulo(dto.getTitulo());	
		tarea.setDescripcion(dto.getDescripcion());	
		tarea.setEstado(EstadoTarea.PENDIENTE); 
		tarea.setFechaCreacion(LocalDateTime.now());
		tarea.setUsuario(usuario);
				
		return mapToDTO(tareaRepository.save(tarea));
	}

	@Override
	// Método para listar las tareas de un usuario específico. Recibe el ID del usuario y un objeto Pageable para la paginación, busca las tareas asociadas al usuario en la BBDD y devuelve una página de DTOs con los datos de las tareas.
	public Page<TareaResponseDTO> listarTareasPorUsuario (Long usuarioId, Pageable pageable) {
		
		Page<Tarea> tareasPage = tareaRepository.findByUsuarioId(usuarioId, pageable);	// Busca las tareas asociadas al usuario utilizando el ID del usuario y la paginación proporcionada. Devuelve una página de tareas.
		
		return tareasPage.map(this::mapToDTO);
	}
	
	
	@Override
	// Recibe el ID de la tarea a actualizar y un DTO con los nuevos datos de la tarea, busca la tarea en la BBDD, actualiza sus campos y guarda los cambios, devolviendo un DTO con los datos de la tarea actualizada.
	public TareaResponseDTO actualizarTarea(Long id, TareaRequestDTO  dto) {
		Tarea tarea = tareaRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Tarea no encontrada con id: " + id));
		tarea.setTitulo(dto.getTitulo());
		tarea.setDescripcion(dto.getDescripcion());
		
		return mapToDTO(tareaRepository.save(tarea));
	}
	
	@Override
	// Recibe el ID de la tarea a eliminar, busca la tarea en la BBDD y la elimina. Si la tarea no existe, lanza una excepción ResourceNotFoundException.
	public void elimarTarea(Long id) {
		Tarea tarea = tareaRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Tarea no encontrada con id: " + id));
		tareaRepository.delete(tarea);		
	}
		
	@Override
	// Recibe el ID de la tarea y el nuevo estado a asignar, busca la tarea en la BBDD, actualiza su estado y guarda los cambios, devolviendo un DTO con los datos de la tarea actualizada con el nuevo estado.
	public TareaResponseDTO cambiarEstado(Long id, EstadoTarea nuevoEstado) {
		Tarea tarea = tareaRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Tarea no encontrada con id: " + id));
		tarea.setEstado(nuevoEstado);
		
		return mapToDTO(tareaRepository.save(tarea));
	}
	
	// Recibe una entidad Tarea y devuelve un DTO TareaResponseDTO con los datos de la tarea, incluyendo el ID del usuario asociado.
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

	@Override
	// Método para listar todas las tareas con paginación. Recibe un objeto Pageable para la paginación, busca todas las tareas en la BBDD y devuelve una página de DTOs con los datos de todas las tareas.
	public Page<TareaResponseDTO> listarTodas(Pageable pageable) {
		return tareaRepository.findAll(pageable)
				.map(this::mapToDTO);
	}
	
}
