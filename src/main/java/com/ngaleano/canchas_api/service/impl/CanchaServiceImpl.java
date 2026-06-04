package com.ngaleano.canchas_api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ngaleano.canchas_api.dto.CanchaResponse;
import com.ngaleano.canchas_api.exception.RecursoNoEncontradoException;
import com.ngaleano.canchas_api.mapper.CanchaMapper;
import com.ngaleano.canchas_api.model.Cancha;
import com.ngaleano.canchas_api.repository.CanchaRepository;
import com.ngaleano.canchas_api.service.CanchaService;

@Service
public class CanchaServiceImpl implements CanchaService {

    @Autowired
    private CanchaRepository canchaRepository;

    @Override
    public void crear(Cancha cancha) {
        canchaRepository.save(cancha);
    }

    @Override
    public Cancha buscarPorId(Long id) {
        return canchaRepository.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException("Cancha no encontrada"));
    }

    @Override
    public List<Cancha> listarTodas() {
        return canchaRepository.findAll();
    }

    @Override
    public void eliminar(Long id) {
        if (!canchaRepository.existsById(id)) {
            throw new RecursoNoEncontradoException("Cancha no encontrada");
        }
        canchaRepository.deleteById(id);
    }

    @Override
    public CanchaResponse buscarPorIdResponse(Long id) {
        return CanchaMapper.toResponse(buscarPorId(id));
    }

    @Override
    public List<CanchaResponse> listarTodasResponse() {
        return canchaRepository.findAll()
                .stream()
                .map(CanchaMapper::toResponse)
                .toList();
    }

}
