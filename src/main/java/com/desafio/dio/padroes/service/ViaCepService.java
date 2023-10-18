package com.desafio.dio.padroes.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.desafio.dio.padroes.domain.endereco.AdressDTO;

@FeignClient(name = "viacep", url = "https://viacep.com.br/ws")
public interface ViaCepService {
  @GetMapping("/{cep}/json/")
	AdressDTO findByCep(@PathVariable("cep") String cep);
}
