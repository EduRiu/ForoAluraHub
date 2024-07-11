package com.eduardo.ForoAlura.entidad.topico;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record TopicoListar(@NotNull
                           Long id,
                           String titulo,
                           String mensaje,
                           LocalDateTime creacion

) {
    public TopicoListar(Topico topico) {
        this(topico.getId(),
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getCreacion());
    }
}
