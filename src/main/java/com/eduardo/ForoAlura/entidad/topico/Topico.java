package com.eduardo.ForoAlura.entidad.topico;


import com.eduardo.ForoAlura.entidad.curso.Curso;
import com.eduardo.ForoAlura.entidad.respuesta.Respuesta;
import com.eduardo.ForoAlura.entidad.usuario.Usuario;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity(name = "topico")
@Table(name = "topicos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    private String titulo;
    private String mensaje;
    private LocalDateTime creacion;
    private Boolean status;
    private Usuario autor;
    private Curso curso;
    private Respuesta respuesta;


}
