package com.ngaleano.canchas_api.service;

import java.util.List;

import com.ngaleano.canchas_api.dto.CanchaResponse;
import com.ngaleano.canchas_api.model.Cancha;

public interface CanchaService {
    void crear(Cancha cancha);
    Cancha buscarPorId(Long id);
    List<Cancha> listarTodas();
    void eliminar(Long id);
    CanchaResponse buscarPorIdResponse(Long id);
    List<CanchaResponse> listarTodasResponse();
}
