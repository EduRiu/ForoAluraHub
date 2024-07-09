package com.eduardo.ForoAlura.entidad.respuesta;

import com.eduardo.ForoAlura.entidad.topico.Topico;
import com.eduardo.ForoAlura.entidad.usuario.Usuario;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity(name = "respuesta")
@Table(name = "respuestas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Respuesta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    private String mensaje;
    private Topico topico;
    private LocalDateTime creacion;
    private Usuario autor;
    private Boolean solucion;


}
