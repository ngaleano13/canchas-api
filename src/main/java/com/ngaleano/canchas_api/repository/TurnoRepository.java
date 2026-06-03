package com.ngaleano.canchas_api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ngaleano.canchas_api.model.Turno;

public interface TurnoRepository extends JpaRepository<Turno, Long> {
    
    List<Turno> findByCanchaId(Long canchaId);
}
