package com.eduardo.ForoAlura.entidad.topico;


import com.eduardo.ForoAlura.entidad.curso.Curso;
import com.eduardo.ForoAlura.entidad.respuesta.Respuesta;
import com.eduardo.ForoAlura.entidad.usuario.Usuario;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

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

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "autor_id", nullable = false)
    private Usuario autor;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "curso_id", nullable = false)
    private Curso curso;

    @OneToMany(mappedBy = "topico", cascade = CascadeType.ALL)
    private List<Respuesta> respuestas;


    public void actualizarDatosTopico(TopicoRespuestaDatos datos) {
        if (datos.mensaje() != null) {
            this.mensaje = datos.mensaje();
        }

        if (datos.titulo() != null) {
            this.titulo = datos.titulo();
        }
    }

    public void desactivarTopico() {
        this.status = false;
    }


}
