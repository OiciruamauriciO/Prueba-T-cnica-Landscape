package com.prueba.tecnica.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
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
    public GenericResponse saveUsuarios(@Validated @RequestBody Usuarios usuarios){
        return usuarioService.saveUsuario(usuarios);
    }
    
    @GetMapping("/usuarios") 
    public FetchUsersResponse fetchDepartmentList(){
        return usuarioService.fetchUsuariosList();
    }
 
    @PutMapping("/usuarios/{email}") 
    public GenericResponse updateUsuarios(@RequestBody UsuarioToUpdateDto usuarioToUpdateDto, @PathVariable("email") String email){        
        return usuarioService.updateUsuarios(usuarioToUpdateDto, email);
    }
    
    @DeleteMapping("/usuarios/{email}") 
    public GenericResponse deleteUsuariosByEmail(@PathVariable("email") String email){    	
        return usuarioService.deleteUsuariosByEmail(email);
    }

}
