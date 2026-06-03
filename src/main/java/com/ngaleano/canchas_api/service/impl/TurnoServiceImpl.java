package com.ngaleano.canchas_api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ngaleano.canchas_api.exception.RecursoNoEncontradoException;
import com.ngaleano.canchas_api.model.Turno;
import com.ngaleano.canchas_api.repository.TurnoRepository;
import com.ngaleano.canchas_api.service.TurnoService;

@Service
public class TurnoServiceImpl implements TurnoService {

    @Autowired
    private TurnoRepository turnoRepository;

    @Override
    public void crear(Turno turno) {
        turnoRepository.save(turno);
    }

    @Override
    public Turno buscarPorId(Long id) {
        return turnoRepository.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException("Turno no encontrado"));
    }

    @Override
    public List<Turno> listarPorCancha(Long canchaId) {
        return turnoRepository.findByCanchaId(canchaId);
    }

    @Override
    public void eliminar(Long id) {
        turnoRepository.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException("Turno no encontrado"));
        turnoRepository.deleteById(id);
    }

}
