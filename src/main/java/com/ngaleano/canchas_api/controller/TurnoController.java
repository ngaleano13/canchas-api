package com.ngaleano.canchas_api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ngaleano.canchas_api.dto.TurnoResponse;
import com.ngaleano.canchas_api.model.Turno;
import com.ngaleano.canchas_api.service.TurnoService;

@RestController
@RequestMapping("/api/turnos")
public class TurnoController {

    @Autowired
    private TurnoService turnoService;

    @GetMapping("/{id}")
    public ResponseEntity<TurnoResponse> obtenerTurno(@PathVariable Long id) {
        return ResponseEntity.ok(turnoService.buscarPorIdResponse(id));
    }

    @GetMapping("/canchas/{canchaId}")
    public ResponseEntity<List<TurnoResponse>> listarTurnosPorCancha(@PathVariable Long canchaId) {
        return ResponseEntity.ok(turnoService.listarPorCanchaResponse(canchaId));
    }

    @PostMapping
    public ResponseEntity<Void> crearTurno(@RequestBody Turno turno) {
        turnoService.crear(turno);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarTurno(@PathVariable Long id) {
        turnoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
