package com.gestiontareas.todolist.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity	// Indica que esta clase es una entidad JPA que se mapeará a una tabla en la base de datos
@Table(name = "tareas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Tarea {

	@Id	// Indica que este campo es la clave primaria de la entidad
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Indica que el valor de este campo se generará automáticamente por la base de datos
	private Long id;

	@Column(nullable = false)	// Establece que el campo título no puede ser nulo en la base de datos
	private String titulo;

	@Column(length = 1000)	// Establece una longitud máxima de 1000 caracteres para la descripción
	private String descripcion;

	@Enumerated(EnumType.STRING)	// Indica que el campo estado se almacenará como una cadena en la base de datos, utilizando los nombres de las constantes del enum
	@Column(nullable = false)	// Establece que el campo estado no puede ser nulo en la base de datos
	private EstadoTarea estado;

	@Column(nullable = false)  // Establece que el campo fechaCreacion no puede ser nulo en la base de datos
    private LocalDateTime fechaCreacion;

	//Relación ManyToOne con Usuario
	@ManyToOne  // Indica que esta entidad tiene una relación de muchos a uno con la entidad Usuario
	@JoinColumn(name = "usuario_id", nullable = false) // Especifica la columna de unión en la base de datos que se utilizará para esta relación, y establece que no puede ser nula  
	private Usuario usuario;

	@PrePersist	// Indica que este método se ejecutará antes de que la entidad se persista en la BBDD, lo que permite establecer valores predeterminados o realizar acciones antes de guardar la entidad
	// En este caso, se establece la fecha de creación actual y el estado inicial de la tarea como PENDIENTE si no se ha establecido previamente
	public void prePersist() {
		this.fechaCreacion = LocalDateTime.now();
		if (this.estado == null) {
			this.estado = EstadoTarea.PENDIENTE;
		}
	}
}