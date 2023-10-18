package com.desafio.dio.padroes.config.doc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;

@Configuration
@OpenAPIDefinition(info = @Info(title = "Desafio DIO", version = "v1"))
public class OpenApiConfiguration {
  @Bean
  public OpenAPI custoOpenAPI() {
    return new OpenAPI()
        .components(new Components())
        .info(new io.swagger.v3.oas.models.info.Info().title("Desafio DIO").version("v1"));
  }
}