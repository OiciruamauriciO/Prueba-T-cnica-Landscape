package com.prueba.tecnica.domain;

import java.sql.Timestamp;

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
public class UsuarioToUpdateDto {
	
	@JsonProperty(value = "nombre")
	String nombre;
	@JsonProperty(value = "email")
	String email;
	@JsonProperty(value = "contraseña")
	String contraseña;
	@JsonProperty(value = "permiso")
	String permiso;
	@JsonProperty(value = "timestamp")
	Timestamp timestamp;
}
