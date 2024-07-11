package com.eduardo.ForoAlura.seguridad;


import com.eduardo.ForoAlura.repositorio.UsuarioRepositorio;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class FiltroSeguridad extends OncePerRequestFilter {

    @Autowired
    TokenServicio tokenServicio;

    @Autowired
    UsuarioRepositorio usuarioRepositorio;


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        var authHeader = request.getHeader("Authorization");

        if (authHeader != null || authHeader == "") {

            var token = authHeader.replace("Bearer ", "");
            var nombreUsuario = tokenServicio.getSubject(token);
            if (nombreUsuario != null){
                var usuario = usuarioRepositorio.findByEmail(nombreUsuario);
                var authentication = new UsernamePasswordAuthenticationToken(usuario, null, usuario.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(authentication);

            }
        }

        filterChain.doFilter(request, response);
    }
}


