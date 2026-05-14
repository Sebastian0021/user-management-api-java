package com.portfolio.usermanagement.dto;

import lombok.Data;
import java.util.Set;

@Data
public class RolDTO {
    private Long id;
    private String nombre;
    private Set<String> usuarios;
}