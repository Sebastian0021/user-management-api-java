package com.primeraEntrega.jpa.primeraEntrega.service;

import com.primeraEntrega.jpa.primeraEntrega.model.Rol;
import com.primeraEntrega.jpa.primeraEntrega.model.Usuario;
import com.primeraEntrega.jpa.primeraEntrega.repository.RolRepository;
import com.primeraEntrega.jpa.primeraEntrega.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private RolRepository rolRepository;


    public List<Usuario> obtenerTodosLosUsuarios() {
        return usuarioRepository.findAll();
    }

    public Usuario guardarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public Usuario obtenerUsuarioPorId(Long id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    public void eliminarUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }
}