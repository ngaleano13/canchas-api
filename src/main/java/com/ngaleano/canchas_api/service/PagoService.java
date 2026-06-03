package com.ngaleano.canchas_api.service;

import java.util.List;

import com.ngaleano.canchas_api.model.Pago;

public interface PagoService {
    void registrarPago(Pago pago);
    List<Pago> buscarPorReserva(Long reservaId);
}
