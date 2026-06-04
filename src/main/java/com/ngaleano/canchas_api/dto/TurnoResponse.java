package com.ngaleano.canchas_api.dto;

import java.time.LocalTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class TurnoResponse {
    private Long id;
    private Long canchaId;
    private LocalTime horaInicio;
    private LocalTime horaFin;
    private boolean disponible;
}
