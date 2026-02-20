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

@RestController
@RequestMapping("/api/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

	private final UsuarioService usuarioService;

	@PostMapping
	public ResponseEntity<UsuarioResponseDTO> crearUsuario(@Valid @RequestBody UsuarioRequestDTO request) {
		UsuarioResponseDTO response = usuarioService.crearUsuario(request);
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}

	@GetMapping("/{id}")
	public ResponseEntity<UsuarioResponseDTO> obtenerUsuarioPorId(@PathVariable Long id) {
		UsuarioResponseDTO response = usuarioService.obtenerUsuarioPorId(id);
		return ResponseEntity.ok(response);
	}
	
	@GetMapping
	public ResponseEntity<List<UsuarioResponseDTO>> listarUsuarios() {
		List<UsuarioResponseDTO> usuarios = usuarioService.listarUsuarios();
		return ResponseEntity.ok(usuarios);
	}
	
}
