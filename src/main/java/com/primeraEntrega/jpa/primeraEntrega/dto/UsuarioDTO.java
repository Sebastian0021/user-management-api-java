package com.primeraEntrega.jpa.primeraEntrega.dto;

import lombok.Data;
import java.util.Set;

@Data
public class UsuarioDTO {
    private Long id;
    private String nombre;
    private Set<String> roles;
}