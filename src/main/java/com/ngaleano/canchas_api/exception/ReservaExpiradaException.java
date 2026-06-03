package com.ngaleano.canchas_api.exception;

public class ReservaExpiradaException extends RuntimeException {
        public ReservaExpiradaException(String mensaje) {
        super(mensaje);
    }
}
