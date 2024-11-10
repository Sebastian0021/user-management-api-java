package com.primeraEntrega.jpa.primeraEntrega.dto;

import lombok.Data;
import java.util.Set;

@Data
public class RolDTO {
    private Long id;
    private String nombre;
    private Set<String> usuarios;
}