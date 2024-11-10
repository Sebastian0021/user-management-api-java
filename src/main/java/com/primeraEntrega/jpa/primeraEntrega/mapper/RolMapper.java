package com.primeraEntrega.jpa.primeraEntrega.mapper;

import com.primeraEntrega.jpa.primeraEntrega.dto.RolDTO;
import com.primeraEntrega.jpa.primeraEntrega.model.Rol;
import org.springframework.stereotype.Component;
import java.util.stream.Collectors;

@Component
public class RolMapper {

    public RolDTO toDto(Rol rol) {
        RolDTO dto = new RolDTO();
        dto.setId(rol.getId());
        dto.setNombre(rol.getNombre());
        dto.setUsuarios(rol.getUsuarios().stream()
                            .map(usuario -> usuario.getNombre())
                            .collect(Collectors.toSet()));
        return dto;
    }

    public Rol toEntity(RolDTO rolDTO) {
        Rol rol = new Rol();
        rol.setId(rolDTO.getId());
        rol.setNombre(rolDTO.getNombre());
        return rol;
    }
}