
# 📋 API REST - Gestión de Tareas (Profesional Avanzado)

API RESTful desarrollada con Spring Boot para la gestión de tareas (To-Do List), diseñada bajo una arquitectura profesional en capas y preparada para entornos reales.

Esta versión avanzada incorpora:

✅ DTOs como contrato estable de API

✅ Manejo global de errores (@ControllerAdvice)

✅ Respuestas JSON uniformes

✅ Paginación con Pageable

✅ Filtros dinámicos con Specification

✅ Documentación automática con OpenAPI / Swagger

Proyecto orientado a portfolio backend profesional, buenas prácticas empresariales y preparación para arquitecturas escalables.

---

## 🚀 Tecnologías Utilizadas

### Backend
- **Java** - Lenguaje de programación principal  
- **Spring Boot** - Framework para desarrollo de aplicaciones Java  
- **Spring Web** - Creación de endpoints REST  
- **Spring Data JPA** - Capa de persistencia y acceso a datos  
- **Hibernate** - ORM (Object-Relational Mapping)  
- **Lombok** - Reducción de código boilerplate  
- **Bean Validation** - Validación de datos de entrada  
- **Springdoc OpenAPI** - Automatiza la generación de documentación de APIs REST 

### Base de Datos
- **MySQL** - Sistema de gestión de base de datos relacional  

### Gestión de Proyecto
- **Maven** - Gestión de dependencias y construcción del proyecto  

---

## 📌 Funcionalidades

👤 Gestión de Usuarios

Crear usuario

Listar usuarios

Obtener usuario por ID

📋 Gestión de Tareas

Crear tareas asociadas a un usuario

Listar tareas por usuario

Actualizar tareas

Eliminar tareas

Cambiar estado (PENDIENTE, EN_PROGRESO, COMPLETADA)

Paginación de resultados

Filtros dinámicos

---

## 🏗️ Arquitectura del Proyecto

Arquitectura en capas (Layered Architecture). Separación clara de responsabilidades y desacoplamiento entre API y entidades:

```
📦 com.gestiontareas
│
├── 📁 controller/      → Endpoints REST
├── 📁 service/         → Lógica de negocio
├── 📁 repository/      → Acceso a datos (JPA)
├── 📁 model/           → Entidades JPA
├── 📁 dto/
│   ├── 📁 request/     → DTOs de entrada
│   └── 📁 response/    → DTOs de salida
├── 📁 exception/       → Manejo global de errores
├── 📁 specification/   → Filtros dinámicos
├── 📁 config/          → Configuración y OpenAPI
└── 📄 ApiRestGestionTareasApplication.java
```

---

## 📡 Endpoints Disponibles

👤 Usuarios
| Método HTTP | Endpoint | Descripción |
|------------|----------|-------------|
| `POST` | `/api/usuarios` | Crear usuario |
| `GET` | `/api/usuarios` | Listar usuarios |
| `GET` | `/api/usuarios/{id}` | Obtener usuario por ID |

📋 Tareas
| Método HTTP | Endpoint | Descripción |
|------------|----------|-------------|
| `POST` | `/api/tareas` | Crear tarea |
| `GET` | `/api/tareas/usuario/{usuarioId}` | Listar tareas por usuario (paginado) |
| `PUT` | `/api/tareas/{id}` | /api/tareas/{id} |
| `DELETE` | `/api/tareas/{id}` | Actualizar tarea |
| `PATCH` | `/api/tareas/{id}/estado` | Cambiar estado |


---

## 🧠 Contrato de API (DTOs)

La API no expone directamente las entidades JPA.  
Utiliza **DTOs** para garantizar un contrato estable y seguro.

### 📥 TareaRequestDTO
```json
{
  "titulo": "Completar documentación",
  "descripcion": "Actualizar README",
  "estado": "PENDIENTE",
  "usuarioId": 1
}

```
### 📤 TareaResponseDTO
```json
{
  "id": 1,
  "titulo": "Completar documentación",
  "descripcion": "Actualizar README",
  "estado": "PENDIENTE",
  "fechaCreacion": "2026-02-04T14:30:00",
  "usuarioId": 1
}
```
---

## ⚠️ Manejo Global de Errores
La API devuelve respuestas JSON uniformes:

```
{
  "timestamp": "2026-02-20T12:00:00",
  "status": 404,
  "error": "NOT_FOUND",
  "message": "Usuario no encontrado",
  "path": "/api/usuarios/99"
}

```
Centralizado mediante @ControllerAdvice.

---

## 📖 Documentación Swagger
Disponible en:
```
http://localhost:8080/swagger-ui/index.html
```
Permite probar la API directamente desde el navegador.

---

## 🛠️ Requisitos Previos

- Java JDK
- MySQL
- Maven (opcional si se usa el wrapper)
- IDE recomendado: IntelliJ IDEA, Eclipse o Spring Tools
- Postman o herramienta similar para probar la API

---

⚙️ Configuración del Proyecto
Crear la base de datos

`CREATE DATABASE gestion_tareas;`

Ejecutar la aplicación

`mvn spring-boot:run`


La API estará disponible en:

`http://localhost:8080`

---

## 📊 Modelo de Datos
### **Entidad Usuario**

- id
- nombre
- email

### **Entidad Tarea**

- id
- titulo
- descripcion
- estado
- fechaCreacion
- usuario (relación ManyToOne)

---

## 👨‍💻 Autor

Alejandro C.  
Proyecto de Portfolio – Spring Boot + MySQL

⭐ Si este proyecto te resulta útil, no dudes en darle una estrella en GitHub

