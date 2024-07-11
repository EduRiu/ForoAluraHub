package com.eduardo.ForoAlura.seguridad;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.eduardo.ForoAlura.entidad.usuario.Usuario;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenServicio {

    @Value("${api.seguridad.clave}")
    private String secreto;

    public String generarToken(Usuario usuario) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secreto);
            return JWT.create()
                    .withIssuer("ForoAlura")
                    .withSubject(usuario.getEmail())
                    .withClaim("id", usuario.getId())
                    .withExpiresAt(generarFechaExpiracion())
                    .sign(algorithm);
        } catch (JWTCreationException exception) {
            throw new RuntimeException();
        }
    }

    public String getSubject(String token) {

        if (token == null) {
            throw new RuntimeException();
        }
        DecodedJWT verificado = null;
        try {
            Algorithm algorithm = Algorithm.HMAC256(secreto);
            verificado = JWT.require(algorithm)
                    .withIssuer("ForoAlura")
                    .build()
                    .verify(token);
            verificado.getSubject();
        } catch (
                JWTVerificationException exception) {
        }
        if (verificado.getSubject() == null) {
            throw new RuntimeException("Token invalido");
        }
        return verificado.getSubject();
    }

    private Instant generarFechaExpiracion() {
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }

}
