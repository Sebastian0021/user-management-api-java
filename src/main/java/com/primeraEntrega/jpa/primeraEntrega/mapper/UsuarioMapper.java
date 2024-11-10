package com.primeraEntrega.jpa.primeraEntrega.mapper;

import com.primeraEntrega.jpa.primeraEntrega.dto.UsuarioDTO;
import com.primeraEntrega.jpa.primeraEntrega.model.Usuario;
import org.springframework.stereotype.Component;
import java.util.stream.Collectors;

@Component
public class UsuarioMapper {

    public UsuarioDTO toDto(Usuario usuario) {
        UsuarioDTO dto = new UsuarioDTO();
        dto.setId(usuario.getId());
        dto.setNombre(usuario.getNombre());
        dto.setRoles(usuario.getRoles().stream()
                          .map(rol -> rol.getNombre())
                          .collect(Collectors.toSet()));
        return dto;
    }

    public Usuario toEntity(UsuarioDTO usuarioDTO) {
        Usuario usuario = new Usuario();
        usuario.setId(usuarioDTO.getId());
        usuario.setNombre(usuarioDTO.getNombre());
        return usuario;
    }
}