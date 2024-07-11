package com.eduardo.ForoAlura.controladores;

import com.eduardo.ForoAlura.entidad.usuario.DatosAutentificacion;
import com.eduardo.ForoAlura.entidad.usuario.Usuario;
import com.eduardo.ForoAlura.seguridad.DTOJwToken;
import com.eduardo.ForoAlura.seguridad.TokenServicio;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutenticacionControlador {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenServicio tokenServicio;

    @PostMapping
    public ResponseEntity autenticarUsuario(@RequestBody @Valid DatosAutentificacion usuario) {
        Authentication autentificacionToken = new UsernamePasswordAuthenticationToken
                (usuario.email(), usuario.pass());
        var usuarioAutenticado = authenticationManager.authenticate(autentificacionToken);
        var jwToken = tokenServicio.generarToken((Usuario) usuarioAutenticado.getPrincipal());

        return ResponseEntity.ok(new DTOJwToken(jwToken));
    }
}
