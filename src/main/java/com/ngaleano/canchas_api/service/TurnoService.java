package com.ngaleano.canchas_api.service;

import java.util.List;

import com.ngaleano.canchas_api.model.Turno;

public interface TurnoService {
    void crear(Turno turno);
    Turno buscarPorId(Long id);
    List<Turno> listarPorCancha(Long canchaId);
    void eliminar(Long id);
}
