package com.primeraEntrega.jpa.primeraEntrega.service;

import com.primeraEntrega.jpa.primeraEntrega.dto.UsuarioDTO;
import com.primeraEntrega.jpa.primeraEntrega.mapper.UsuarioMapper;
import com.primeraEntrega.jpa.primeraEntrega.model.Rol;
// import com.primeraEntrega.jpa.primeraEntrega.model.Rol;
import com.primeraEntrega.jpa.primeraEntrega.model.Usuario;
import com.primeraEntrega.jpa.primeraEntrega.repository.RolRepository;
// import com.primeraEntrega.jpa.primeraEntrega.repository.RolRepository;
import com.primeraEntrega.jpa.primeraEntrega.repository.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
// import java.util.HashSet;
import java.util.List;
import java.util.Optional;
// import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private RolRepository rolRepository;

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

    public UsuarioDTO asignarRolAUsuario(Long usuarioId, Long rolId) {
        Optional<Usuario> usuarioOpt = usuarioRepository.findById(usuarioId);
        Optional<Rol> rolOpt = rolRepository.findById(rolId);

        if (usuarioOpt.isPresent() && rolOpt.isPresent()) {
            Usuario usuario = usuarioOpt.get();
            Rol rol = rolOpt.get();

            usuario.getRoles().add(rol);
            Usuario usuarioActualizado = usuarioRepository.save(usuario);

            return usuarioMapper.toDto(usuarioActualizado);
        } else {
            throw new RuntimeException("Usuario o Rol no encontrado");
        }
    }

    // put (Anda raro)
    public UsuarioDTO actualizarRolesDeUsuario(Long usuarioId, List<Long> rolIds) {
        Optional<Usuario> usuarioOpt = usuarioRepository.findById(usuarioId);
        if (!usuarioOpt.isPresent()) {
            throw new RuntimeException("Usuario no encontrado");
        }

        Usuario usuario = usuarioOpt.get();

        List<Rol> roles = rolRepository.findAllById(rolIds);
        usuario.setRoles(new HashSet<>(roles));

        for (Rol rol : roles) {
            rol.getUsuarios().add(usuario);
        }

        rolRepository.saveAll(roles); 
        Usuario usuarioActualizado = usuarioRepository.save(usuario);

        return usuarioMapper.toDto(usuarioActualizado);
    }
}
