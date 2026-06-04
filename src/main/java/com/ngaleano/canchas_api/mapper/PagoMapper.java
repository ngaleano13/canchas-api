package com.ngaleano.canchas_api.mapper;

import com.ngaleano.canchas_api.dto.PagoResponse;
import com.ngaleano.canchas_api.model.Pago;

public class PagoMapper {
    public static PagoResponse toResponse(Pago pago) {
        return new PagoResponse(
            pago.getId(),
            pago.getReserva().getId(),
            pago.getMonto(),
            pago.getTipoPago(),
            pago.getMetodoPago(),
            pago.getFechaPago()
        );
    }
}