package com.gestiontareas.todolist.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gestiontareas.todolist.model.Usuario;

@Repository // Indica que esta clase es un repositorio de Spring Data JPA
// Al extender JpaRepository, esta interfaz hereda métodos para realizar operaciones CRUD (Create, Read, Update, Delete) y consultas personalizadas sobre la entidad Usuario, utilizando Long como tipo de dato para la clave primaria
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	// Método personalizado para encontrar un usuario por su email, devuelve un Optional<Usuario> que puede contener un usuario si se encuentra uno con el email especificado, o estar vacío si no se encuentra ningún usuario con ese email
    Optional<Usuario> findByEmail(String email);

}
