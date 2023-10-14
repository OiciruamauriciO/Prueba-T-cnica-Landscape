package com.prueba.tecnica.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.tecnica.domain.UsuarioToUpdateDto;
import com.prueba.tecnica.entity.Usuarios;
import com.prueba.tecnica.response.FetchUsersResponse;
import com.prueba.tecnica.response.GenericResponse;
import com.prueba.tecnica.service.UsuarioService;

@RestController
public class UsuariosController {
	
	@Autowired
	private UsuarioService usuarioService;
	
    @PostMapping("/usuarios")    
    public ResponseEntity<GenericResponse> saveUsuarios(@Validated @RequestBody Usuarios usuarios){
    	GenericResponse genericResponse = usuarioService.saveUsuario(usuarios);
    	if(genericResponse==null) {
    		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(genericResponse);
    	}else {
    		return ResponseEntity.status(HttpStatus.CREATED).body(genericResponse);
        }
    }    
    @GetMapping("/usuarios") 
    public ResponseEntity<FetchUsersResponse> fetchDepartmentList(){
    	FetchUsersResponse fetchUsersResponse = usuarioService.fetchUsuariosList();
    	if(fetchUsersResponse==null) {
    		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(fetchUsersResponse);
    	} else {
    		return ResponseEntity.status(HttpStatus.OK).body(fetchUsersResponse);
    	}    	
    } 
    @PutMapping("/usuarios/{email}") 
    public ResponseEntity<GenericResponse> updateUsuarios(@RequestBody UsuarioToUpdateDto usuarioToUpdateDto, @PathVariable("email") String email){        
    	GenericResponse genericResponse = usuarioService.updateUsuarios(usuarioToUpdateDto, email);
    	if(genericResponse==null) {
    		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(genericResponse);
    	}else {
    		return ResponseEntity.status(HttpStatus.CREATED).body(genericResponse);
        }
    }    
    @DeleteMapping("/usuarios/{email}") 
    public ResponseEntity<GenericResponse> deleteUsuariosByEmail(@PathVariable("email") String email){    	
    	GenericResponse genericResponse = usuarioService.deleteUsuariosByEmail(email);
    	if(genericResponse==null) {
    		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(genericResponse);
    	}else {
    		return ResponseEntity.status(HttpStatus.CREATED).body(genericResponse);
        }
    }

}
