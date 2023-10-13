package com.prueba.tecnica.domain;

import java.util.List;
import java.util.UUID;

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
public class UsuarioDto {

	@JsonProperty(value = "id")
	UUID id;
	@JsonProperty(value = "nombre")
	String nombre;
	@JsonProperty(value = "email")
	String email;
	@JsonProperty(value = "contraseña")
	String contraseña;
	@JsonProperty(value = "accesos")
	List<AccesosDto> accesos;
	@JsonProperty(value = "permiso")
	List<PermisosDto> permisos;
	
}
