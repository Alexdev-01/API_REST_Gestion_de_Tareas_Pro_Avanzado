package com.gestiontareas.todolist.service;

import org.springframework.stereotype.Service;

import com.gestiontareas.todolist.dto.request.UsuarioRequestDTO;
import com.gestiontareas.todolist.dto.response.UsuarioResponseDTO;
import com.gestiontareas.todolist.exception.ResourceNotFoundException;
import com.gestiontareas.todolist.model.Usuario;
import com.gestiontareas.todolist.repository.UsuarioRepository;

import lombok.RequiredArgsConstructor;

@Service	// Anotación que indica que esta clase es un servicio de Spring
@RequiredArgsConstructor	// Genera un constructor con los campos finales
public class UsuarioServiceImpl implements UsuarioService {
	
	private final UsuarioRepository usuarioRepository;

	@Override
	public UsuarioResponseDTO crearUsuario(UsuarioRequestDTO request) {
		
		Usuario usuario = Usuario.builder().nombre(request.getNombre()).email(request.getEmail()).build();
		Usuario guardado = usuarioRepository.save(usuario);
		
		return new UsuarioResponseDTO(guardado.getId(), guardado.getNombre(), guardado.getEmail());
	}

	@Override
	public UsuarioResponseDTO obtenerUsuarioPorId(Long id) {
		
		Usuario usuario = usuarioRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado con id: " + id));

		return UsuarioResponseDTO(usuario.getId(), usuario.getNombre(), usuario.getEmail());
	}
	
}
