package com.ngaleano.canchas_api.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.FutureOrPresent;
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
@Table(name = "reservas")
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    @NotNull(message = "El usuario no puede ser nulo")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "turno_id", nullable = false)
    @NotNull(message = "El turno no puede ser nulo")
    private Turno turno;

    @Column(nullable = false)
    @NotNull(message = "La fecha no puede ser nula")
    @FutureOrPresent(message = "La fecha no puede ser en el pasado")
    private LocalDate fecha;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EstadoReserva estado;

    @Column(nullable = false)
    private LocalDateTime fechaCreacion;

    @Column(nullable = false)
    private LocalDateTime fechaLimiteSeña;

    @Column(nullable = false, precision = 10, scale = 2)
    @NotNull(message = "El monto total no puede ser nulo")
    @Positive(message = "El monto total debe ser mayor a 0")
    private BigDecimal montoTotal;

    @Column(nullable = false, precision = 10, scale = 2)
    @NotNull(message = "El monto de seña no puede ser nulo")
    @Positive(message = "El monto de seña debe ser mayor a 0")
    private BigDecimal montoSeña;
}
