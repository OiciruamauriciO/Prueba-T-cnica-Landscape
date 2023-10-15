package com.prueba.tecnica.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class AuthUserDto {
	@JsonProperty("usuario")
	String usuario;
	@JsonProperty("contraseña")
	String contraseña;
	@JsonProperty("token")
	String token;
}
