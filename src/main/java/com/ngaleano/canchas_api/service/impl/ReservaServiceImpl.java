package com.ngaleano.canchas_api.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ngaleano.canchas_api.exception.RecursoNoEncontradoException;
import com.ngaleano.canchas_api.exception.TurnoNoDisponibleException;
import com.ngaleano.canchas_api.model.EstadoReserva;
import com.ngaleano.canchas_api.model.Reserva;
import com.ngaleano.canchas_api.repository.ReservaRepository;
import com.ngaleano.canchas_api.service.ReservaService;

@Service
public class ReservaServiceImpl implements ReservaService {

    @Autowired
    private ReservaRepository reservaRepository;

    @Override
    public void crear(Reserva reserva) {
        if (reservaRepository.existsByTurnoIdAndFecha(reserva.getTurno().getId(), reserva.getFecha())) {
            throw new TurnoNoDisponibleException("El turno ya esta reservado para esa fecha");
        }
        reserva.setEstado(EstadoReserva.PENDIENTE);
        reserva.setFechaCreacion(LocalDateTime.now());
        reserva.setFechaLimiteSeña(LocalDateTime.now().plusHours(6));
        reservaRepository.save(reserva);
    }

    @Override
    public Reserva buscarPorId(Long id) {
        return reservaRepository.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException("Reserva no encontrada"));
    }

    @Override
    public List<Reserva> listarPorUsuario(Long usuarioId) {
        return reservaRepository.findByUsuarioId(usuarioId);
    }

    @Override
    public void cancelar(Long id) {
        Reserva reserva = buscarPorId(id);
        reserva.setEstado(EstadoReserva.CANCELADA);
        reservaRepository.save(reserva);
    }

    @Override
    public void confirmar(Long id) {
        Reserva reserva = buscarPorId(id);
        reserva.setEstado(EstadoReserva.CONFIRMADA);
        reservaRepository.save(reserva);
    }

}
