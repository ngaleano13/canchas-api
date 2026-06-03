package com.ngaleano.canchas_api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ngaleano.canchas_api.model.Pago;

public interface PagoRepository extends JpaRepository<Pago, Long> {
    List<Pago> findByReservaId(Long reservaId);
}
