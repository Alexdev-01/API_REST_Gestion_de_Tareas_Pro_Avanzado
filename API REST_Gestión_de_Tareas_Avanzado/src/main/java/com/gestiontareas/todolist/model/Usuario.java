package com.gestiontareas.todolist.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity	// Indica que esta clase es una entidad JPA que se mapeará a una tabla en la BBDD
@Table(name = "usuarios")	// Especifica el nombre de la tabla en la BBDD que se utilizará para esta entidad
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Usuario {
	
	@Id	// Indica que este campo es la clave primaria de la entidad
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Indica que el valor de este campo se generará automáticamente por la BBDD
	private Long id;
	
	@Column(nullable = false)	// Establece que el campo nombre no puede ser nulo en la BBDD
	private String nombre;
	
	@Column(nullable = false, unique = true)	// Establece que el campo email no puede ser nulo y debe ser único en la BBDD
	private String email;
	
	@OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true) // Indica que esta entidad tiene una relación de uno a muchos con la entidad Tarea, donde el campo "usuario" en la entidad Tarea es el propietario de la relación. Además, se establece que las operaciones de persistencia en Usuario se propaguen a las tareas relacionadas, y que las tareas huérfanas (sin un usuario asociado) se eliminen automáticamente.
	private List<Tarea> tareas; // Relación OneToMany con Tarea, un usuario puede tener muchas tareas
	
}
