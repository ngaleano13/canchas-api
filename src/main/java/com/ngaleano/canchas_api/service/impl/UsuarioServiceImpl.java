package com.ngaleano.canchas_api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ngaleano.canchas_api.dto.UsuarioResponse;
import com.ngaleano.canchas_api.exception.EmailYaRegistradoException;
import com.ngaleano.canchas_api.exception.RecursoNoEncontradoException;
import com.ngaleano.canchas_api.mapper.UsuarioMapper;
import com.ngaleano.canchas_api.model.Usuario;
import com.ngaleano.canchas_api.repository.UsuarioRepository;
import com.ngaleano.canchas_api.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public void registrar(Usuario usuario) {
        if (usuarioRepository.existsByEmail(usuario.getEmail())) {
            throw new EmailYaRegistradoException("El email ya está registrado");
        }
        usuarioRepository.save(usuario);
    }

    @Override
    public Usuario buscarPorEmail(String email) {
        return usuarioRepository.findByEmail(email)
                .orElseThrow(() -> new RecursoNoEncontradoException("Usuario no encontrado"));
    }

    @Override
    public Usuario buscarPorId(Long id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException("Usuario no encontrado"));
    }

    @Override
    public UsuarioResponse buscarPorIdResponse(Long id) {
        Usuario usuario = buscarPorId(id);
        return UsuarioMapper.toResponse(usuario);
    }
}