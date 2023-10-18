package com.desafio.dio.padroes.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.desafio.dio.padroes.domain.endereco.*;
import com.desafio.dio.padroes.domain.usuario.*;
import com.desafio.dio.padroes.repository.*;

@Service
public class UserService {
  @Autowired
  UserRepository repository;

  @Autowired
  RoleRepository roleRepository;

  @Autowired
  AdressRepository adressRepository;

  @Autowired
  ViaCepService viaCepService;

  public boolean existUser(String login) {
    Optional<UserDetails> user = repository.findByLogin(login);
    if (user.isPresent()) {
      return true;
    }
    return false;
  }

  public void createUser(User user, String zipCode) {
    Optional<Role> role = roleRepository.findByName("USER");
    if (role.isPresent())
      user.setRole(role.get());
    Optional<Adress> adress = adressRepository.findByZipCode(zipCode);
    if (adress.isPresent()) {
      user.setEndereco(adress.get());
    } else {
      AdressDTO adressDto = viaCepService.findByCep(zipCode);
      var newAdress = adressRepository.save(new Adress(adressDto.cep(), adressDto.logradouro(),
          adressDto.complemento(),
          adressDto.bairro(), adressDto.localidade(), adressDto.uf(), Integer.parseInt(adressDto.ddd())));
      user.setEndereco(newAdress);
    }
    repository.save(user);
  }
}
