package com.portfolio.usermanagement.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API de Gestión de Usuarios y Roles")
                        .description("API REST para la gestión de usuarios y roles en el sistema, incluyendo creación, actualización, y eliminación de usuarios y roles.")
                        .version("1.0.0")
                        .contact(new Contact()
                                .name("Soporte de la API")
                                .email("rolesyusuariosapi@gmail.com")
                                .url("https://www.linkedin.com/in/sebastianpenalozafuentes/"))
                        .license(new License()
                                .name("Licencia Apache 2.0")
                                .url("http://www.apache.org/licenses/LICENSE-2.0.html"))
                )
                .servers(List.of(
                        new Server().url("http://localhost:8080").description("Servidor local de desarrollo")
                ))
                .externalDocs(new ExternalDocumentation()
                        .description("Documentación adicional")
                        .url("https://github.com/Sebastian0021/JavaCoderHouse/tree/newdb"));
    }
}
