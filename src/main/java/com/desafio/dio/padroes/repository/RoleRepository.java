package com.desafio.dio.padroes.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.desafio.dio.padroes.domain.usuario.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{
  Optional<Role> findByName(String name);
}
