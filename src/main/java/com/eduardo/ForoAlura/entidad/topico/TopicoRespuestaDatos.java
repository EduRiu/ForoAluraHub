package com.eduardo.ForoAlura.entidad.topico;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record TopicoRespuestaDatos(

        @NotNull
        Long id,
        String titulo,
        String mensaje,
        LocalDateTime creacion) {

}
