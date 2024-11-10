package com.primeraEntrega.jpa.primeraEntrega.controller;

import com.primeraEntrega.jpa.primeraEntrega.dto.RolDTO;
// import com.primeraEntrega.jpa.primeraEntrega.model.Rol;
import com.primeraEntrega.jpa.primeraEntrega.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/roles")
@Tag(name = "Roles", description = "Operaciones relacionadas con los roles")
public class RolController {

    @Autowired
    private RolService rolService;

    @GetMapping
    @Operation(summary = "Obtener todos los roles", description = "Devuelve una lista de todos los roles disponibles en el sistema")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Lista de roles obtenida exitosamente"),
        @ApiResponse(responseCode = "500", description = "Error en el servidor")
    })
    public List<RolDTO> obtenerTodosLosRoles() {
        return rolService.obtenerTodosLosRoles();
    }

    @PostMapping
    @Operation(summary = "Guardar un nuevo rol", description = "Crea y guarda un nuevo rol en el sistema")
    @ApiResponses({
        @ApiResponse(responseCode = "201", description = "Rol creado exitosamente"),
        @ApiResponse(responseCode = "400", description = "Solicitud inválida"),
        @ApiResponse(responseCode = "500", description = "Error en el servidor")
    })
    public RolDTO guardarRol(@RequestBody RolDTO rolDTO) {
        return rolService.guardarRol(rolDTO);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener rol por ID", description = "Devuelve los detalles de un rol basado en su ID")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Rol encontrado"),
        @ApiResponse(responseCode = "404", description = "Rol no encontrado"),
        @ApiResponse(responseCode = "500", description = "Error en el servidor")
    })
    public RolDTO obtenerRolPorId(@Parameter(description = "ID del rol a obtener") @PathVariable Long id) {
        return rolService.obtenerRolPorId(id);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar rol", description = "Elimina un rol del sistema basado en su ID")
    @ApiResponses({
        @ApiResponse(responseCode = "204", description = "Rol eliminado exitosamente"),
        @ApiResponse(responseCode = "404", description = "Rol no encontrado"),
        @ApiResponse(responseCode = "500", description = "Error en el servidor")
    })
    public void eliminarRol(@Parameter(description = "ID del rol a eliminar") @PathVariable Long id) {
        rolService.eliminarRol(id);
    }
}