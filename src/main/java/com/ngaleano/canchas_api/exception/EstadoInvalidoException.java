package com.ngaleano.canchas_api.exception;

public class EstadoInvalidoException extends RuntimeException {
    public EstadoInvalidoException(String mensaje) {
        super(mensaje);
    }
}
