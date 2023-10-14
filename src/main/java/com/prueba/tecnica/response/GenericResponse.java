package com.prueba.tecnica.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GenericResponse {
	@JsonProperty("status")
	private int status;	
	@JsonProperty("message")
	private String message;
}
