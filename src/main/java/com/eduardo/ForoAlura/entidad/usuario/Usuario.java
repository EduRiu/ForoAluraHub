package com.eduardo.ForoAlura.entidad.usuario;

import com.eduardo.ForoAlura.entidad.enums.Perfil;
import jakarta.persistence.*;
import lombok.*;

@Entity(name = "usuario")
@Table(name = "usuarios")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")

public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    private String nombre;
    private String email;
    private String pass;
    private Perfil perfil;

}
