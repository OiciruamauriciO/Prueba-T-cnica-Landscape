package com.prueba.tecnica.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.prueba.tecnica.domain.UsuarioDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FetchUsersResponse {

	@JsonProperty("response")
	private GenericResponse genericResponse;
	
	@JsonProperty("usuarios")
	private List<UsuarioDto> usuarioDto;
}
