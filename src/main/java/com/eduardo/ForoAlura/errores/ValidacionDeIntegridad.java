package com.eduardo.ForoAlura.errores;

public class ValidacionDeIntegridad extends RuntimeException {
    public ValidacionDeIntegridad(String NoEncontrado) {
        super(NoEncontrado);
    }
}