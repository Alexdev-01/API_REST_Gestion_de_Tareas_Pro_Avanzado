package com.gestiontareas.todolist.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gestiontareas.todolist.dto.request.UsuarioRequestDTO;
import com.gestiontareas.todolist.dto.response.UsuarioResponseDTO;
import com.gestiontareas.todolist.service.UsuarioService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

// Clase de controlador REST que maneja las solicitudes relacionadas con los usuarios
@RestController // Indica que esta clase es un controlador REST de Spring
@RequestMapping("/api/usuarios") // Define la ruta base para las solicitudes de este controlador
@RequiredArgsConstructor // Genera un constructor con los campos finales
public class UsuarioController {

	private final UsuarioService usuarioService;

	// Método para crear un nuevo usuario
	@PostMapping	// @PostMapping indica que este método maneja solicitudes HTTP POST a la ruta "/api/usuarios"
	public ResponseEntity<UsuarioResponseDTO> crearUsuario(@Valid @RequestBody UsuarioRequestDTO request) {
		UsuarioResponseDTO response = usuarioService.crearUsuario(request);
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}

	// Método para obtener un usuario por su ID
	@GetMapping("/{id}")	// @PathVariable indica que el valor de la variable de ruta se mapea al parámetro id
	public ResponseEntity<UsuarioResponseDTO> obtenerUsuarioPorId(@PathVariable Long id) {
		UsuarioResponseDTO response = usuarioService.obtenerUsuarioPorId(id);
		return ResponseEntity.ok(response);
	}
	
	// Método para obtener un usuario por su nombre de usuario
	@GetMapping	// Método para listar todos los usuarios
	public ResponseEntity<List<UsuarioResponseDTO>> listarUsuarios() {
		List<UsuarioResponseDTO> usuarios = usuarioService.listarUsuarios();
		return ResponseEntity.ok(usuarios);
	}
	
}
