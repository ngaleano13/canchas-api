package com.ngaleano.canchas_api.service;
import com.ngaleano.canchas_api.model.Usuario;

public interface UsuarioService {
    void registrar(Usuario usuario);
    Usuario buscarPorEmail(String email);
    Usuario buscarPorId(Long id);
}
