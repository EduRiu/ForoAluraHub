package com.eduardo.ForoAlura.entidad.curso;

import com.eduardo.ForoAlura.entidad.enums.Categoria;
import jakarta.persistence.*;
import lombok.*;

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
    private Categoria categoria;




}
