package com.gestiontareas.todolist.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gestiontareas.todolist.model.Usuario;

@Repository // Indica que esta clase es un repositorio de Spring Data JPA
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByEmail(String email);

}
