package com.ngaleano.canchas_api.dto;

import com.ngaleano.canchas_api.model.Rol;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UsuarioResponse {
    private Long id;
    private String nombre;
    private String email;
    private Rol rol;
}
