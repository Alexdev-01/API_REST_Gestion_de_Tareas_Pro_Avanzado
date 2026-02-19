package com.gestiontareas.todolist.service;

import com.gestiontareas.todolist.dto.request.UsuarioRequestDTO;
import com.gestiontareas.todolist.dto.response.UsuarioResponseDTO;

public interface UsuarioService {

	UsuarioResponseDTO crearUsuario(UsuarioRequestDTO request);

	UsuarioResponseDTO obtenerUsuarioPorId(Long id);
}
