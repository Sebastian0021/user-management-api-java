package com.primeraEntrega.jpa.primeraEntrega.service;

import com.primeraEntrega.jpa.primeraEntrega.dto.UsuarioDTO;
import com.primeraEntrega.jpa.primeraEntrega.mapper.UsuarioMapper;
// import com.primeraEntrega.jpa.primeraEntrega.model.Rol;
import com.primeraEntrega.jpa.primeraEntrega.model.Usuario;
// import com.primeraEntrega.jpa.primeraEntrega.repository.RolRepository;
import com.primeraEntrega.jpa.primeraEntrega.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// import java.util.HashSet;
import java.util.List;
// import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private UsuarioMapper usuarioMapper;

    public List<UsuarioDTO> obtenerTodosLosUsuarios() {
        return usuarioRepository.findAll().stream()
                                .map(usuarioMapper::toDto)
                                .collect(Collectors.toList());
    }

    public UsuarioDTO guardarUsuario(UsuarioDTO usuarioDTO) {
        Usuario usuario = usuarioMapper.toEntity(usuarioDTO); // Convertir DTO a entidad
        Usuario savedUsuario = usuarioRepository.save(usuario);
        return usuarioMapper.toDto(savedUsuario); // Convertir entidad guardada a DTO
    }

    public UsuarioDTO obtenerUsuarioPorId(Long id) {
        return usuarioRepository.findById(id)
                                .map(usuarioMapper::toDto)
                                .orElse(null);
    }

    public void eliminarUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }
}
