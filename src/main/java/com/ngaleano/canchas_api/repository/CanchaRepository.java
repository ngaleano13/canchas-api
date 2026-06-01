package com.ngaleano.canchas_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ngaleano.canchas_api.model.Cancha;


public interface CanchaRepository extends JpaRepository<Cancha, Long> {
    
}
