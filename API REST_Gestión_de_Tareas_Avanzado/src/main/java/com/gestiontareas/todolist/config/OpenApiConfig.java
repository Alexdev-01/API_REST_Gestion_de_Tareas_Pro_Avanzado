package com.gestiontareas.todolist.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// Clase de configuración para OpenAPI (Swagger) que define la documentación de la API REST
@Configuration  //Indicar que esta clase es una clase de configuración
public class OpenApiConfig {
	
	@Bean  //Indicar que este método devuelve un bean que debe ser gestionado por el contenedor de Spring
	public OpenAPI customOpenAPI() {
		
		return new OpenAPI().info(new Info()
				.title("API REST - Gestión de Tareas")
				.version("1.0")
				.description("API profesional para la gestión de tareas con Spring Boot"));
	}

}
