package com.ngaleano.canchas_api.scheduler;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.ngaleano.canchas_api.model.EstadoReserva;
import com.ngaleano.canchas_api.model.Reserva;
import com.ngaleano.canchas_api.repository.ReservaRepository;

@Component
@EnableScheduling
public class ReservaScheduler {

    @Autowired
    private ReservaRepository reservaRepository;

    @Scheduled(fixedRate = 60000)
    public void expirarReservas() {
        List<Reserva> reservasPendientes = reservaRepository
            .findByEstado(EstadoReserva.PENDIENTE);
        
        for (Reserva reserva : reservasPendientes) {
            if (LocalDateTime.now().isAfter(reserva.getFechaLimiteSeña())) {
                reserva.setEstado(EstadoReserva.EXPIRADA);
                reservaRepository.save(reserva);
            }
        }
    }
}
