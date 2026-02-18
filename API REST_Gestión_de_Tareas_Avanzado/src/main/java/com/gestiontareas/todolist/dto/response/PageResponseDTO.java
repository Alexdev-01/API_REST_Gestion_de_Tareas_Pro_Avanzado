package com.gestiontareas.todolist.dto.response;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data  // Anotación de Lombok para generar getters, setters, toString, equals y hashCode automáticamente
@AllArgsConstructor  // Anotación de Lombok para generar un constructor con todos los argumentos
public class PageResponseDTO<T> {
	
	private List<T> content;
	private int page;
	private int size;
	private long totalElements;
	private int totalPages;
	
	

}
