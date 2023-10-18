package com.desafio.dio.padroes.domain.endereco;

public record AdressDTO(String cep, String logradouro, String complemento, String bairro, String localidade, String uf,
    String ibge, String gia, String ddd, String siafi) {
}
