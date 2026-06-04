package com.ngaleano.canchas_api.dto;

import java.math.BigDecimal;
import java.time.LocalTime;

import com.ngaleano.canchas_api.model.TipoCancha;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CanchaResponse {

    private Long id;
    private String nombre;
    private String descripcion;
    private BigDecimal precioPorHora;
    private Integer porcentajeSeña;
    private LocalTime horarioApertura;
    private LocalTime horarioCierre;
    private TipoCancha tipo;
}
