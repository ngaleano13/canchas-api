package com.ngaleano.canchas_api.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ngaleano.canchas_api.exception.RecursoNoEncontradoException;
import com.ngaleano.canchas_api.model.EstadoReserva;
import com.ngaleano.canchas_api.model.Pago;
import com.ngaleano.canchas_api.model.Reserva;
import com.ngaleano.canchas_api.model.TipoPago;
import com.ngaleano.canchas_api.repository.PagoRepository;
import com.ngaleano.canchas_api.repository.ReservaRepository;
import com.ngaleano.canchas_api.service.PagoService;

public class PagoServiceImpl implements PagoService {

    @Autowired
    private PagoRepository pagoRepository;

    @Autowired
    private ReservaRepository reservaRepository;

    @Override
    public void registrarPago(Pago pago) {
        Reserva reserva = reservaRepository.findById(pago.getReserva().getId())
                .orElseThrow(() -> new RecursoNoEncontradoException("Reserva no encontrada"));

        switch (pago.getTipoPago()) {
            case SEÑA:
                if (reserva.getEstado() != EstadoReserva.PENDIENTE) {
                    throw new IllegalStateException("La reserva no está en estado de seña");
                }
                if (LocalDateTime.now().isAfter(reserva.getFechaLimiteSeña())) {
                    reserva.setEstado(EstadoReserva.EXPIRADA);
                    reservaRepository.save(reserva);
                    throw new IllegalStateException("El plazo para realizar la seña ha expirado");
                }
                reserva.setEstado(EstadoReserva.CONFIRMADA);
                reservaRepository.save(reserva);
                break;
            case TOTAL:
                if (reserva.getEstado() != EstadoReserva.CONFIRMADA) {
                    throw new IllegalStateException("La reserva no está en estado confirmada");
                }
                reserva.setEstado(EstadoReserva.SALDADA);
                reservaRepository.save(reserva);
                break;
            default:
                throw new IllegalArgumentException("Tipo de pago no válido");
        }
        pagoRepository.save(pago);
    }

    @Override
    public List<Pago> buscarPorReserva(Long reservaId) {
        return pagoRepository.findByReservaId(reservaId);
    }

}
