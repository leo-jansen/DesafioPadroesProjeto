package com.desafio.dio.padroes.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.desafio.dio.padroes.domain.endereco.Adress;

@Repository
public interface AdressRepository extends JpaRepository<Adress, String>{
  Optional<Adress> findByZipCode(String zipCode);
}
