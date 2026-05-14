package com.portfolio.usermanagement.service;

import com.portfolio.usermanagement.dto.RolDTO;
import com.portfolio.usermanagement.mapper.RolMapper;
import com.portfolio.usermanagement.model.Rol;
import com.portfolio.usermanagement.repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RolService {

    @Autowired
    private RolRepository rolRepository;

    @Autowired
    private RolMapper rolMapper;

    public List<RolDTO> obtenerTodosLosRoles() {
        return rolRepository.findAll().stream()
                            .map(rolMapper::toDto)
                            .collect(Collectors.toList());
    }

    public RolDTO guardarRol(RolDTO rolDTO) {
        Rol rol = rolMapper.toEntity(rolDTO); // Convertir DTO a entidad
        Rol savedRol = rolRepository.save(rol);
        return rolMapper.toDto(savedRol); // Convertir entidad guardada a DTO
    }

    public RolDTO obtenerRolPorId(Long id) {
        return rolRepository.findById(id)
                            .map(rolMapper::toDto)
                            .orElse(null);
    }

    public void eliminarRol(Long id) {
        rolRepository.deleteById(id);
    }
}

