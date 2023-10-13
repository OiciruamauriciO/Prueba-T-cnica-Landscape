package com.prueba.tecnica.service;

import com.prueba.tecnica.domain.UsuarioToUpdateDto;
import com.prueba.tecnica.entity.Usuarios;
import com.prueba.tecnica.response.FetchUsersResponse;
import com.prueba.tecnica.response.GenericResponse;

public interface UsuarioService {	
	GenericResponse saveUsuario(Usuarios usuario);
	FetchUsersResponse fetchUsuariosList();
	GenericResponse updateUsuarios(UsuarioToUpdateDto usuarioToUpdateDto, String email);
	GenericResponse deleteUsuariosById(Long accesosIdUsuario);
	GenericResponse deleteUsuariosByEmail(String email);
}
