package com.gestiontareas.todolist.service;

import java.util.List;

import com.gestiontareas.todolist.dto.request.UsuarioRequestDTO;
import com.gestiontareas.todolist.dto.response.UsuarioResponseDTO;

// Interfaz que define los métodos del servicio de usuarios. Establece las operaciones que se pueden realizar sobre los usuarios.
public interface UsuarioService {

	UsuarioResponseDTO crearUsuario(UsuarioRequestDTO request);

	UsuarioResponseDTO obtenerUsuarioPorId(Long id);

	List<UsuarioResponseDTO> listarUsuarios();
}
