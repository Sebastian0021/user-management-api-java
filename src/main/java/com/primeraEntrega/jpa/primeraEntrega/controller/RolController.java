package com.primeraEntrega.jpa.primeraEntrega.controller;

import com.primeraEntrega.jpa.primeraEntrega.dto.RolDTO;
// import com.primeraEntrega.jpa.primeraEntrega.model.Rol;
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
    public List<RolDTO> obtenerTodosLosRoles() {
        return rolService.obtenerTodosLosRoles();
    }

    @PostMapping
    public RolDTO guardarRol(@RequestBody RolDTO rolDTO) {
        return rolService.guardarRol(rolDTO);
    }

    @GetMapping("/{id}")
    public RolDTO obtenerRolPorId(@PathVariable Long id) {
        return rolService.obtenerRolPorId(id);
    }

    @DeleteMapping("/{id}")
    public void eliminarRol(@PathVariable Long id) {
        rolService.eliminarRol(id);
    }
}
