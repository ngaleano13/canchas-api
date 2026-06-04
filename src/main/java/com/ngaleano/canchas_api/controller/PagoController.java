package com.ngaleano.canchas_api.controller;

import org.springframework.web.bind.annotation.RestController;

import com.ngaleano.canchas_api.dto.PagoResponse;
import com.ngaleano.canchas_api.model.Pago;
import com.ngaleano.canchas_api.service.PagoService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/api/pagos")
public class PagoController {

    @Autowired
    private PagoService pagoService;

    @GetMapping("/reserva/{id}")
    public ResponseEntity<List<PagoResponse>> getPagoByReservaId(@PathVariable Long id) {
        return ResponseEntity.ok(pagoService.buscarPorReservaResponse(id));
    }

    @PostMapping
    public ResponseEntity<Void> crearPago(@RequestBody Pago pago) {
        pagoService.registrarPago(pago);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
