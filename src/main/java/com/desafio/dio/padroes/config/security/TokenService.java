package com.desafio.dio.padroes.config.security;

import java.time.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.desafio.dio.padroes.domain.usuario.User;
import com.desafio.dio.padroes.service.AuthorizationService;

@Service
public class TokenService {
  @Value("${api.security.token.secret}")
  private String secret;

  @Value("${api.security.token.expire}")
  private int expireTime;

  @Autowired
  AuthorizationService authorizationService;

  public String generateToken(User user) {
    try {
      Algorithm algorithm = Algorithm.HMAC256(secret);
      String token = JWT.create()
          .withIssuer("auth-api")
          .withSubject(user.getLogin())
          .withExpiresAt(genExpirationDate())
          .sign(algorithm);
      return token;
    } catch (JWTCreationException exception) {
      throw new RuntimeException("Error ao criar o token", exception);
    }
  }

  public String validateToken(String token) {
    try {
      Algorithm algorithm = Algorithm.HMAC256(secret);
      return JWT.require(algorithm)
          .withIssuer("auth-api")
          .build()
          .verify(token)
          .getSubject();
    } catch (JWTVerificationException exception) {
      return "";
    }
  }

  public Authentication getAuthentication(String token) {
    var login = this.validateToken(token);
    UserDetails user = authorizationService.loadUserByUsername(login);
    return new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
  }

  private Instant genExpirationDate() {
    return LocalDateTime.now().plusHours(this.expireTime).toInstant(ZoneOffset.of("-03:00"));
  }
}
