package com.ngaleano.canchas_api.model;

import java.math.BigDecimal;
import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Table(name = "canchas")
public class Cancha {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotBlank(message = "El nombre no puede estar vacio")
    private String nombre;

    @Column(nullable = false)
    @NotBlank(message = "La descripcion no puede estar vacia")
    private String descripcion;

    @Column(nullable = false, precision = 10, scale = 2)
    @NotNull(message = "El precio por hora no puede ser nulo")
    @Positive(message = "El precio debe ser mayor a 0")
    private BigDecimal precioPorHora;

    @Column(nullable = false)
    @NotNull(message = "El porcentaje de seña no puede ser nulo")
    @Min(value = 1, message = "El porcentaje debe ser mayor a 0")
    @Max(value = 100, message = "El porcentaje no puede ser mayor a 100")
    private Integer porcentajeSeña;

    @Column(nullable = false)
    @NotNull(message = "El horario de apertura no puede ser nulo")
    private LocalTime horarioApertura;

    @Column(nullable = false)
    @NotNull(message = "El horario de cierre no puede ser nulo")
    private LocalTime horarioCierre;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    @NotNull(message = "El tipo de cancha no puede ser nulo")
    private TipoCancha tipo;

}
