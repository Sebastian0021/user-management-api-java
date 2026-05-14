# User & Role Management API (Spring Boot)

Este proyecto es una API RESTful desarrollada en Java utilizando el framework Spring Boot. Su propósito es proveer un sistema robusto para la gestión de Usuarios y Roles (RBAC - Role Based Access Control), demostrando la implementación de una arquitectura en capas, buenas prácticas de diseño y persistencia de datos relacionales.

### Características Principales

- **Gestión de Usuarios:** Endpoints para crear, leer, actualizar y eliminar (CRUD) registros de usuarios en el sistema.
- **Gestión de Roles:** Administración de los roles de acceso disponibles y su respectiva asignación.
- **Arquitectura Multicapa:** Separación clara de responsabilidades utilizando Controladores (Controllers), Servicios (Services) y Repositorios (Repositories).
- **Patrón DTO (Data Transfer Object):** Implementación de DTOs y Mappers para aislar el modelo de dominio (Entidades JPA) de los datos expuestos en los endpoints, garantizando seguridad y flexibilidad en las respuestas.
- **Persistencia de Datos:** Integración con Spring Data JPA y base de datos embebida (H2) para el almacenamiento relacional fluido.
- **Documentación Interactiva:** Integración con Swagger/OpenAPI para explorar y probar la API de forma visual.

### Tecnologías Utilizadas

- **Java 17+**
- **Spring Boot:** Framework principal para la creación de la aplicación REST.
- **Spring Data JPA:** Abstracción para el manejo de persistencia e interacción con la base de datos.
- **H2 Database:** Motor de base de datos relacional embebido, ideal para entornos de desarrollo y pruebas rápidas.
- **Maven:** Herramienta de gestión de dependencias y construcción del proyecto.
- **Swagger / Springdoc OpenAPI:** Para la auto-generación de la documentación de la API.

### Requisitos Previos

- Java Development Kit (JDK) 17 o superior.
- Apache Maven (opcional, el proyecto incluye un Maven Wrapper `mvnw`).
- Un IDE compatible con Java (IntelliJ IDEA, Eclipse, VS Code).

### Instalación y Ejecución Local

1.  **Clonar el repositorio:**
    ```bash
    git clone -b newdb https://github.com/Sebastian0021/user-management-api-java.git
    cd user-management-api-java
    ```

2.  **Construir el proyecto:**
    Utilizando el wrapper de Maven incluido para descargar dependencias y compilar:
    ```bash
    ./mvnw clean install
    ```
    *(En Windows utiliza `mvnw.cmd clean install`)*

3.  **Ejecutar la aplicación:**
    ```bash
    ./mvnw spring-boot:run
    ```

El servidor se iniciará y estará escuchando peticiones en el puerto por defecto (usualmente `http://localhost:8080`).

### Documentación de la API (Swagger)

Con la aplicación en ejecución, puedes acceder a la interfaz de usuario de OpenAPI/Swagger para interactuar con los endpoints directamente desde tu navegador:

- **Swagger UI:** `http://localhost:8080/swagger-ui.html`
- **OpenAPI Docs (JSON):** `http://localhost:8080/v3/api-docs`

### Estructura del Proyecto

El código fuente sigue las convenciones estándar de Spring Boot:

- `controller/`: Define los puntos de entrada REST (`UsuarioController`, `RolController`).
- `service/`: Contiene la lógica de negocio de la aplicación.
- `repository/`: Interfaces de Spring Data JPA para el acceso a datos.
- `model/`: Entidades JPA que mapean directamente a las tablas de la base de datos (`Usuario`, `Rol`).
- `dto/`: Objetos de transferencia de datos utilizados en los requests y responses.
- `mapper/`: Clases o utilidades para transformar Entidades a DTOs y viceversa.
- `config/`: Clases de configuración global (ej. configuración de OpenAPI).
