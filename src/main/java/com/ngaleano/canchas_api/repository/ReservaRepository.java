package com.ngaleano.canchas_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ngaleano.canchas_api.model.Reserva;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {
    
}
