package com.desafio.dio.padroes.domain.usuario;

import org.springframework.security.core.GrantedAuthority;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name = "permissions")
public class Permission implements GrantedAuthority{
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  private String description;

  @Override
  public String getAuthority() {
    return this.getName();
  }
}
