package com.gestiontareas.todolist.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gestiontareas.todolist.model.Tarea;

@Repository // Indica que esta clase es un repositorio de Spring Data JPA
public interface TareaRepository extends JpaRepository<Tarea, Long> {
	
	Page<Tarea> findByUsuarioId(Long usuarioId, Pageable pageable);
	
	//List tareas por usuario y estado
	List<Tarea> findByUsuarioIdAndEstado(Long usuarioId, com.gestiontareas.todolist.model.EstadoTarea estado);
	
	

}
