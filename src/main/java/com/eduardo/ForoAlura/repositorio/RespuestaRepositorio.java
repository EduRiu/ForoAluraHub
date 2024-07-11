package com.eduardo.ForoAlura.repositorio;

import com.eduardo.ForoAlura.entidad.respuesta.Respuesta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RespuestaRepositorio extends JpaRepository<Respuesta, Long> {
}
