package com.gestiontareas.todolist.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gestiontareas.todolist.dto.request.UsuarioRequestDTO;
import com.gestiontareas.todolist.dto.response.UsuarioResponseDTO;
import com.gestiontareas.todolist.exception.ResourceNotFoundException;
import com.gestiontareas.todolist.model.Usuario;
import com.gestiontareas.todolist.repository.UsuarioRepository;

import lombok.RequiredArgsConstructor;

@Service	// Anotación que indica que esta clase es un servicio de Spring
@RequiredArgsConstructor	// Genera un constructor con los campos finales
// Implementación de la interfaz UsuarioService, que contiene la lógica de negocio para gestionar los usuarios. Esta clase utiliza el repositorio para interactuar con la BBDD y realizar las operaciones definidas en la interfaz.
public class UsuarioServiceImpl implements UsuarioService {
	
	private final UsuarioRepository usuarioRepository;

	// El método crearUsuario recibe un DTO con los datos del usuario a crear, construye una entidad Usuario a partir de esos datos, guarda la entidad en la base de datos utilizando el repositorio y devuelve un DTO con los datos del usuario creado. Este método utiliza el patrón Builder para construir la entidad Usuario, lo que mejora la legibilidad y mantenibilidad del código.
	@Override
	public UsuarioResponseDTO crearUsuario(UsuarioRequestDTO request) {
		
		Usuario usuario = Usuario.builder().nombre(request.getNombre()).email(request.getEmail()).build();
		Usuario guardado = usuarioRepository.save(usuario);
		
		return new UsuarioResponseDTO(guardado.getId(), guardado.getNombre(), guardado.getEmail());
	}

	// El método obtenerUsuarioPorId recibe el ID de un usuario, busca la entidad Usuario correspondiente en la base de datos utilizando el repositorio, y si no encuentra el usuario, lanza una excepción ResourceNotFoundException. Si encuentra el usuario, devuelve un DTO con los datos del usuario encontrado.
	@Override
	public UsuarioResponseDTO obtenerUsuarioPorId(Long id) {
		Usuario usuario = usuarioRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado con id: " + id));

		return new UsuarioResponseDTO(usuario.getId(), usuario.getNombre(), usuario.getEmail());
	}
	
	// El método listarUsuarios busca todas las entidades Usuario en la base de datos utilizando el repositorio, y luego convierte cada entidad en un DTO UsuarioResponseDTO utilizando un stream y el método map. Finalmente, devuelve una lista de DTOs con los datos de todos los usuarios encontrados.
	@Override
	public List<UsuarioResponseDTO> listarUsuarios() {
		return usuarioRepository.findAll().stream()
				.map(usuario -> new UsuarioResponseDTO(
						usuario.getId(),
						usuario.getNombre(),
						usuario.getEmail()))
				.toList();
	}
}
