package com.primeraEntrega.jpa.primeraEntrega.controller;

import com.primeraEntrega.jpa.primeraEntrega.model.Rol;
import com.primeraEntrega.jpa.primeraEntrega.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/roles")
public class RolController {

    @Autowired
    private RolService rolService;

    @GetMapping
    public List<Rol> obtenerTodosLosRoles() {
        return rolService.obtenerTodosLosRoles();
    }

    @PostMapping
    public Rol guardarRol(@RequestBody Rol rol) {
        return rolService.guardarRol(rol);
    }

    @GetMapping("/{id}")
    public Rol obtenerRolPorId(@PathVariable Long id) {
        return rolService.obtenerRolPorId(id);
    }

    @DeleteMapping("/{id}")
    public void eliminarRol(@PathVariable Long id) {
        rolService.eliminarRol(id);
    }
}
