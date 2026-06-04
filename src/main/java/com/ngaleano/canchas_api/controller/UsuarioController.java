package com.ngaleano.canchas_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ngaleano.canchas_api.dto.UsuarioResponse;
import com.ngaleano.canchas_api.model.Usuario;
import com.ngaleano.canchas_api.service.UsuarioService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioResponse> obtenerUsuarioPorId(@PathVariable Long id) {
        return ResponseEntity.ok(usuarioService.buscarPorIdResponse(id));
    }

    @PostMapping("/registrar")
    public ResponseEntity<Void> registrarUsuario(@RequestBody Usuario usuario) {
        usuarioService.registrar(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
