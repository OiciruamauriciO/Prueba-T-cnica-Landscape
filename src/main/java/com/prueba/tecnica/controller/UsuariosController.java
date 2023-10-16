package com.prueba.tecnica.controller;

import org.springframework.beans.factory.annotation.Autowired;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.tecnica.domain.AuthUserDto;
import com.prueba.tecnica.domain.UsuarioToUpdateDto;
import com.prueba.tecnica.entity.Usuarios;
import com.prueba.tecnica.response.FetchUsersResponse;
import com.prueba.tecnica.response.GenericResponse;
import com.prueba.tecnica.service.UsuarioService;
import com.prueba.tecnica.utils.GetJwtToken;

@RestController
public class UsuariosController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@PostMapping("/auth")
	public AuthUserDto login(@RequestParam String usuario, @RequestParam String contraseña) {
		GetJwtToken getJwtToken = new GetJwtToken();
		getJwtToken.setUsername(usuario);
		return new AuthUserDto(usuario, contraseña, getJwtToken.getJWTToken());		
	}
	
    @PostMapping("/usuarios")    
    public ResponseEntity<GenericResponse> saveUsuarios(HttpServletResponse response, @Validated @RequestBody Usuarios usuarios) throws Exception {
    	GenericResponse genericResponse = usuarioService.saveUsuario(usuarios);
    	int statuscode = response.getStatus();    	
    	if(statuscode==200) {
    		genericResponse.setMessage("Usuario creado en base de datos correctamente.");
    		genericResponse.setStatus(statuscode);
    		return ResponseEntity.status(HttpStatus.OK).body(genericResponse);
    	} else {
    		genericResponse.setMessage("Problema detectado en el Servidor, favor intente más tarde.");
    		genericResponse.setStatus(statuscode);
    		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(genericResponse);
    	}
    }    
    @GetMapping("/usuarios") 
    public ResponseEntity<FetchUsersResponse> fetchDepartmentList(HttpServletResponse response) throws Exception {
    	FetchUsersResponse fetchUsersResponse = usuarioService.fetchUsuariosList();
    	int statuscode = response.getStatus();    	
    	if(statuscode==200) {
    		fetchUsersResponse.getGenericResponse().setMessage("Usuario listados correctamente");
    		fetchUsersResponse.getGenericResponse().setStatus(statuscode);
    		return ResponseEntity.status(HttpStatus.OK).body(fetchUsersResponse);
    	} else {
    		fetchUsersResponse.getGenericResponse().setMessage("Problema detectado en el Servidor, favor intente más tarde.");
    		fetchUsersResponse.getGenericResponse().setStatus(statuscode);
    		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(fetchUsersResponse);
    	}
    } 
    @PutMapping("/usuarios/{email}") 
    public ResponseEntity<GenericResponse> updateUsuarios(HttpServletResponse response, @RequestBody UsuarioToUpdateDto usuarioToUpdateDto, @PathVariable("email") String email) throws Exception {        
    	GenericResponse genericResponse = usuarioService.updateUsuarios(usuarioToUpdateDto, email);
    	int statuscode = response.getStatus();    	
    	if(statuscode==200) {
    		genericResponse.setMessage("Usuario actualizado correctamente.");
    		genericResponse.setStatus(statuscode);
    		return ResponseEntity.status(HttpStatus.OK).body(genericResponse);
    	} else {
    		genericResponse.setMessage("Problema detectado en el Servidor, favor intente más tarde.");
    		genericResponse.setStatus(statuscode);
    		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(genericResponse);
    	}
    }    
    @DeleteMapping("/usuarios/{email}") 
    public ResponseEntity<GenericResponse> deleteUsuariosByEmail(HttpServletResponse response, @PathVariable("email") String email) throws Exception {    	
    	GenericResponse genericResponse = usuarioService.deleteUsuariosByEmail(email);
    	int statuscode = response.getStatus();    	
    	if(statuscode==200) {
    		genericResponse.setMessage("Usuario eliminado de la base de datos correctamente.");
    		genericResponse.setStatus(statuscode);
    		return ResponseEntity.status(HttpStatus.OK).body(genericResponse);
    	} else {
    		genericResponse.setMessage("Problema detectado en el Servidor, favor intente más tarde.");
    		genericResponse.setStatus(statuscode);
    		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(genericResponse);
    	}
    }

}
