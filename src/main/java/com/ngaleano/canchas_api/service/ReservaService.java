package com.ngaleano.canchas_api.service;

import java.util.List;

import com.ngaleano.canchas_api.model.Reserva;

public interface ReservaService {
    void crear(Reserva reserva);
    Reserva buscarPorId(Long id);
    List<Reserva> listarPorUsuario(Long usuarioId);
    void cancelar(Long id);
    void confirmar(Long id);
}
