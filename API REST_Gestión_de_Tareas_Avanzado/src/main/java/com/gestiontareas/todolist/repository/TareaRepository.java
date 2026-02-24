package com.gestiontareas.todolist.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gestiontareas.todolist.model.Tarea;

@Repository // Indica que esta clase es un repositorio de Spring Data JPA
// Al extender JpaRepository, esta interfaz hereda métodos para realizar operaciones CRUD (Create, Read, Update, Delete) y consultas personalizadas sobre la entidad Tarea, utilizando Long como tipo de dato para la clave primaria
public interface TareaRepository extends JpaRepository<Tarea, Long> {
	
	//List tareas por usuario con paginación
	Page<Tarea> findByUsuarioId(Long usuarioId, Pageable pageable);
	
	//List tareas por usuario y estado
	List<Tarea> findByUsuarioIdAndEstado(Long usuarioId, com.gestiontareas.todolist.model.EstadoTarea estado);
	
	

}
