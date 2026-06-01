package com.ngaleano.canchas_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ngaleano.canchas_api.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    
}
