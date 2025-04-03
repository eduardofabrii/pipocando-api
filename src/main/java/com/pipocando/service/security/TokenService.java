package com.pipocando.service.security;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.pipocando.domain.user.User;

// Serviço responsável pela geração e validação de tokens JWT.
@Service
public class TokenService {

    // Secret key
    @Value("${api.security.token.secret}")
    private String secret;
    
    // Tempo de expiração do token em horas
    public String generateToken(User user) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);

            // Token
            return JWT.create()
            .withIssuer("pipocando_api")
            .withSubject(user.getName())
            .withClaim("role", user.getRole().name())
            .withClaim("id", user.getId().toString())
            .withExpiresAt(this.generateExpirationDate())
            .sign(algorithm);

        } catch (JWTCreationException exception) {
            throw new RuntimeException("Error while authenticating", exception);
        }
    }

    // Verifica se o token é válido e não expirou
    public String validateToken(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            return JWT.require(algorithm)
            .withIssuer("pipocando_api")
            .build()
            .verify(token)
            .getSubject(); // Pega o subject do token
        } catch (JWTVerificationException e) {
            return null;
        }
    }

    private Instant generateExpirationDate() {
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }
}
