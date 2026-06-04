package com.ngaleano.canchas_api.mapper;

import com.ngaleano.canchas_api.dto.ReservaResponse;
import com.ngaleano.canchas_api.model.Reserva;

public class ReservaMapper {
    public static ReservaResponse toResponse(Reserva reserva) {
        return new ReservaResponse(
            reserva.getId(),
            reserva.getUsuario().getId(),
            reserva.getTurno().getId(),
            reserva.getEstado(),
            reserva.getFechaCreacion(),
            reserva.getFechaLimiteSeña(),
            reserva.getMontoTotal(),
            reserva.getMontoSeña()
        );
    }
}
