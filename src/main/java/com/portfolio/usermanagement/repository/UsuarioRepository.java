package com.portfolio.usermanagement.repository;


import com.portfolio.usermanagement.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}