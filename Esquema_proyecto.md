```text
📦 com.gestiontareas.todolist
│
├── 📁 controller/ → Capa de presentación (REST API)
│ ├── TareaController.java
│ └── UsuarioController.java
│
├── 📁 service/ → Lógica de negocio
│ ├── TareaService.java
│ ├── TareaServiceImpl.java
│ ├── UsuarioService.java
│ └── UsuarioServiceImpl.java
│
├── 📁 repository/ → Acceso a datos (Spring Data JPA)
│ ├── TareaRepository.java
│ └── UsuarioRepository.java
│
├── 📁 model/ → Entidades de dominio (JPA)
│ ├── Tarea.java
│ ├── Usuario.java
│ └── EstadoTarea.java
│
├── 📁 dto/ → Data Transfer Objects (Contrato API)
│ ├── request/
│ │ ├── TareaRequestDTO.java
│ │ ├── UsuarioRequestDTO.java
│ │ └── FiltroTareaDTO.java
│ │
│ └── response/
│ ├── TareaResponseDTO.java
│ ├── UsuarioResponseDTO.java
│ └── PageResponseDTO.java
│
├── 📁 exception/ → Manejo global de errores
│ ├── GlobalExceptionHandler.java
│ ├── ResourceNotFoundException.java
│ ├── BadRequestException.java
│ └── ErrorResponse.java
│
├── 📁 specification/ → Filtros dinámicos (JPA Specifications)
│ └── TareaSpecification.java
│
├── 📁 config/ → Configuración y documentación
│ ├── SwaggerConfig.java
│ └── OpenApiConfig.java
│
└── 📄 ApiRestGestionTareasApplication.java

```
