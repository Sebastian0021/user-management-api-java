# API de Gestión de Usuarios y Roles

API REST desarrollada en Java con Spring Boot para gestionar usuarios y roles en una base de datos. Esta API permite crear, leer, actualizar y eliminar usuarios y roles, así como gestionar las relaciones entre ellos.

## Tecnologías

- **Java **: Lenguaje de programación.
- **Spring Boot**: Framework para construir aplicaciones Java de manera rápida y sencilla.
- **Spring Data JPA**: Manejo de la persistencia y gestión de las bases de datos.
- **H2 Database**: Base de datos en memoria para desarrollo y pruebas.
- **Lombok**: Simplifica el código Java eliminando código repetitivo.
- **Swagger/OpenAPI**: Documentación de la API.

## Estructura del Proyecto

- `controller`: Controladores REST para los endpoints de la API.
- `model`: Entidades de base de datos.
- `repository`: Interfaces de repositorio para acceso a datos.
- `service`: Lógica de negocio para interactuar con las bases de datos.
- `dto`: Data Transfer Objects (DTOs) para transferir datos entre capas.
- `mapper`: Clases de mapeo entre entidades y DTOs.
- `config`: Configuraciones, incluyendo la configuración de OpenAPI/Swagger.

### Endpoints principales

| Método | Endpoint                   | Descripción                    |
| ------ | -------------------------- | ------------------------------ |
| GET    | `/api/usuarios`            | Obtener todos los usuarios     |
| GET    | `/api/usuarios/{id}`       | Obtener un usuario por su ID   |
| POST   | `/api/usuarios`            | Crear un nuevo usuario         |
| PUT    | `/api/usuarios/{id}/roles` | Actualizar roles de un usuario |
| DELETE | `/api/usuarios/{id}`       | Eliminar un usuario            |
| GET    | `/api/roles`               | Obtener todos los roles        |
| GET    | `/api/roles/{id}`          | Obtener un rol por su ID       |
| POST   | `/api/roles`               | Crear un nuevo rol             |
| DELETE | `/api/roles/{id}`          | Eliminar un rol                |
