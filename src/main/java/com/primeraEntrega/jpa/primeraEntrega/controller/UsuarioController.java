package com.primeraEntrega.jpa.primeraEntrega.controller;

import com.primeraEntrega.jpa.primeraEntrega.dto.UsuarioDTO;
import com.primeraEntrega.jpa.primeraEntrega.service.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public List<UsuarioDTO> obtenerTodosLosUsuarios() {
        return usuarioService.obtenerTodosLosUsuarios();
    }

    @PostMapping
    public UsuarioDTO guardarUsuario(@RequestBody UsuarioDTO usuarioDTO) {
        return usuarioService.guardarUsuario(usuarioDTO);
    }

    @GetMapping("/{id}")
    public UsuarioDTO obtenerUsuarioPorId(@PathVariable Long id) {
        return usuarioService.obtenerUsuarioPorId(id);
    }

    @DeleteMapping("/{id}")
    public void eliminarUsuario(@PathVariable Long id) {
        usuarioService.eliminarUsuario(id);
    }

    @PostMapping("/{id}/roles/{rolId}")
    public UsuarioDTO asignarRolAUsuario(@PathVariable Long id, @PathVariable Long rolId) {
        return usuarioService.asignarRolAUsuario(id, rolId);
    }

    // put (Anda raro)
    @PutMapping("/{id}/roles")
    public UsuarioDTO actualizarRolesDeUsuario(@PathVariable Long id, @RequestBody List<Long> rolIds) {
        return usuarioService.actualizarRolesDeUsuario(id, rolIds);
    }
}
