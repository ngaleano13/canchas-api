package com.ngaleano.canchas_api.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ngaleano.canchas_api.model.EstadoReserva;
import com.ngaleano.canchas_api.model.Reserva;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {
    List<Reserva> findByUsuarioId(Long usuarioId);
    boolean existsByTurnoIdAndFecha(Long turnoId, LocalDate fecha);
    List<Reserva> findByEstado(EstadoReserva estado);
}
