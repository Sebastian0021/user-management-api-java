package com.primeraEntrega.jpa.primeraEntrega.repository;


import com.primeraEntrega.jpa.primeraEntrega.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}