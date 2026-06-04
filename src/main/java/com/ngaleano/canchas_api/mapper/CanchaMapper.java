package com.ngaleano.canchas_api.mapper;

import com.ngaleano.canchas_api.dto.CanchaResponse;
import com.ngaleano.canchas_api.model.Cancha;

public class CanchaMapper {
    public static CanchaResponse toResponse(Cancha cancha) {
        return new CanchaResponse(
            cancha.getId(),
            cancha.getNombre(),
            cancha.getDescripcion(),
            cancha.getPrecioPorHora(),
            cancha.getPorcentajeSeña(),
            cancha.getHorarioApertura(),
            cancha.getHorarioCierre(),
            cancha.getTipo()
        );
    }
}
