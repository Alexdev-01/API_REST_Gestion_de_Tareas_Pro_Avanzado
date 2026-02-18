package com.gestiontareas.todolist.service;

public interface UsuarioService {

	UsuarioResponseDTO crearUsuario(UsuarioRequestDTO request);

	UsuarioResponseDTO obtenerUsuarioPorId(Long id);
}
