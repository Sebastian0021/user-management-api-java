package com.portfolio.usermanagement.dto;

import lombok.Data;
import java.util.Set;

@Data
public class UsuarioDTO {
    private Long id;
    private String nombre;
    private Set<String> roles;
}