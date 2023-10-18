package com.desafio.dio.padroes.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.desafio.dio.padroes.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class AuthorizationService implements UserDetailsService {
  @Autowired
  UserRepository repository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    Optional<UserDetails> user = repository.findByLogin(username);
    if(user.isPresent()) {
      return user.get();
    }
    log.trace("Usuario não encontrado");
    throw new UsernameNotFoundException("Usuario não encontrado na base de dados");
  }
}
