package com.eduardo.ForoAlura.repositorio;

import com.eduardo.ForoAlura.entidad.curso.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CursoRepositorio extends JpaRepository<Curso, Long> {

    Optional<Curso> findByNombre(String  nombre);
}
