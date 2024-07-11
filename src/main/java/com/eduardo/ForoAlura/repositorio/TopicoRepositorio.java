package com.eduardo.ForoAlura.repositorio;

import com.eduardo.ForoAlura.entidad.topico.Topico;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TopicoRepositorio extends JpaRepository<Topico, Long> {

    Page<Topico> findByStatusTrue(Pageable paginacion);
}
