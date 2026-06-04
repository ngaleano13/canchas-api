package com.ngaleano.canchas_api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.ngaleano.canchas_api.dto.CanchaResponse;
import com.ngaleano.canchas_api.model.Cancha;
import com.ngaleano.canchas_api.service.CanchaService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/api/canchas")
public class CanchaController {

    @Autowired
    private CanchaService canchaService;

    @GetMapping
    public ResponseEntity<List<CanchaResponse>> listarCanchas() {
        return ResponseEntity.ok(canchaService.listarTodasResponse());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CanchaResponse> obtenerCancha(@PathVariable Long id) {
        return ResponseEntity.ok(canchaService.buscarPorIdResponse(id));
    }

    @PostMapping
    public ResponseEntity<Void> crearCancha(@RequestBody Cancha cancha) {
        canchaService.crear(cancha);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCancha(@PathVariable Long id) {
        canchaService.eliminar(id);
        return ResponseEntity.noContent().build();
    }

}
