package com.eduardo.ForoAlura.entidad.curso;

import com.eduardo.ForoAlura.entidad.enums.Categoria;
import com.eduardo.ForoAlura.entidad.topico.Topico;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity(name = "curso")
@Table(name = "cursos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    private String nombre;
    @Enumerated(EnumType.STRING)
    private Categoria categoria;

    @OneToMany(mappedBy = "curso", cascade = CascadeType.ALL)
    private List<Topico> topicos;




}
