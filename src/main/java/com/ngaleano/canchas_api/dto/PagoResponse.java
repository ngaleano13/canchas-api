package com.ngaleano.canchas_api.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.ngaleano.canchas_api.model.MetodoPago;
import com.ngaleano.canchas_api.model.TipoPago;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PagoResponse {
    private Long id;
    private Long reservaId;
    private BigDecimal monto;
    private TipoPago tipoPago;
    private MetodoPago metodoPago;
    private LocalDateTime fechaPago;
}
