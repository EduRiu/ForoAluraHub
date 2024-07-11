package com.eduardo.ForoAlura.entidad.topico;

import com.eduardo.ForoAlura.entidad.curso.Curso;
import com.eduardo.ForoAlura.entidad.usuario.Usuario;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


public record TopicoEnvioDatos(

        @NotNull
        Long id,

        @NotNull
        String mensaje,

        @NotNull
        String nombre,

        @NotNull
        String titulo

) {
}
