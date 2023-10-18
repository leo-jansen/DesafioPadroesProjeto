package com.desafio.dio.padroes.domain.endereco;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Data
@Entity
@Table(name = "adress")
@AllArgsConstructor
public class Adress {
	@Id
	private String zipCode;
	private String place;
	private String placeComplement;
	private String neighborhood;
	private String city;
	@Column(length = 2)
	private String state;
	@Column(length = 2)
	private int zoneNumber;
}
