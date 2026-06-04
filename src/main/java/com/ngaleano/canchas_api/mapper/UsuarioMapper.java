package com.ngaleano.canchas_api.mapper;

import com.ngaleano.canchas_api.dto.UsuarioResponse;
import com.ngaleano.canchas_api.model.Usuario;

public class UsuarioMapper {
    public static UsuarioResponse toResponse(Usuario usuario) {
        return new UsuarioResponse(
            usuario.getId(),
            usuario.getNombre(),
            usuario.getEmail(),
            usuario.getRol()
        );
    }
}
