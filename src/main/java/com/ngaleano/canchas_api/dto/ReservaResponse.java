package com.ngaleano.canchas_api.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.ngaleano.canchas_api.model.EstadoReserva;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ReservaResponse {
    private Long id;
    private Long usuarioId;
    private Long turnoId;
    private EstadoReserva estado;
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaLimiteSeña;
    private BigDecimal montoTotal;
    private BigDecimal montoSeña;
}
