package com.eduardo.ForoAlura.repositorio;

import com.eduardo.ForoAlura.entidad.usuario.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findById(Long id);

    UserDetails findByEmail(String username);
}
