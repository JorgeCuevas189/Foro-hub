# Forum Hub

Este es un proyecto de ejemplo de un foro hub creado con Java y Spring Boot. Implementa autenticación JWT y proporciona endpoints para listar, crear, actualizar y eliminar tópicos.

## Requisitos

- Java 11+
- Maven

## Instrucciones para correr el proyecto

1. Clonar el repositorio
2. Navegar al directorio del proyecto
3. Ejecutar `mvn spring-boot:run`
4. Acceder a `http://localhost:8080`

## Endpoints

- `POST /api/auth/login`: Autenticación, devuelve un token JWT
- `GET /api/topics`: Listar tópicos
- `POST /api/topics`: Crear un nuevo tópico (requiere autenticación)
- `PUT /api/topics/{id}`: Actualizar un tópico (requiere autenticación)
- `DELETE /api/topics/{id}`: Eliminar un tópico (requiere autenticación)
