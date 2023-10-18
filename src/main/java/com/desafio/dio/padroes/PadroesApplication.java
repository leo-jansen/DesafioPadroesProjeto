package com.desafio.dio.padroes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class PadroesApplication {

	public static void main(String[] args) {
		SpringApplication.run(PadroesApplication.class, args);
	}

}
