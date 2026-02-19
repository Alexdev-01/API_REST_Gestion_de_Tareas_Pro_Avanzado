package com.gestiontareas.todolist.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration  //Indicar que esta clase es una clase de configuración
public class OpenApiConfig {
	
	@Bean  //Indicar que este método devuelve un bean que debe ser gestionado por el contenedor de Spring
	public OpenAPI customOpenAPI() {
		
		return new OpenAPI().info(new info()
				.tittle("API REST - Gestión de Tareas")
				.version("1.0")
				.description("API profesional para la gestión de tareas con Spring Boot"));
	}

}
