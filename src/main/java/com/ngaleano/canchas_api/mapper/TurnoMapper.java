package com.ngaleano.canchas_api.mapper;

import com.ngaleano.canchas_api.dto.TurnoResponse;
import com.ngaleano.canchas_api.model.Turno;

public class TurnoMapper {
    public static TurnoResponse toResponse(Turno turno) {
        return new TurnoResponse(
            turno.getId(),
            turno.getCancha().getId(),
            turno.getHoraInicio(),
            turno.getHoraFin(),
            turno.isDisponible()
        );
    }
}