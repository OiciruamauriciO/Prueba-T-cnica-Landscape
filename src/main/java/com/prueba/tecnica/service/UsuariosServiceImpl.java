package com.prueba.tecnica.service;

import java.util.ArrayList;
import java.util.List;
import com.prueba.tecnica.domain.AccesosDto;
import com.prueba.tecnica.domain.PermisosDto;
import com.prueba.tecnica.domain.UsuarioDto;
import com.prueba.tecnica.domain.UsuarioToUpdateDto;
import com.prueba.tecnica.entity.Accesos;
import com.prueba.tecnica.entity.Permisos;
import com.prueba.tecnica.entity.Usuarios;
import com.prueba.tecnica.repository.AccesosRepository;
import com.prueba.tecnica.repository.PermisosRepository;
import com.prueba.tecnica.repository.UsuariosRepository;
import com.prueba.tecnica.response.FetchUsersResponse;
import com.prueba.tecnica.response.GenericResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuariosServiceImpl implements UsuarioService {
	
	@Autowired
	private UsuariosRepository usuariosRepository;	
	@Autowired
	private AccesosRepository accesosRepository;	
	@Autowired
	private PermisosRepository permisosRepository;
	
	@SuppressWarnings("null")
	@Override
	public GenericResponse saveUsuario(Usuarios usuario) {			
		GenericResponse genericResponse = null;		
		try {
			usuariosRepository.save(usuario);
			genericResponse.setStatus(200);
			genericResponse.setMessage("Usuario registrado exitosamente");
		}catch(Exception e) {
			e.printStackTrace();
		}		
		return genericResponse;
	}

	@SuppressWarnings("null")
	@Override
	public FetchUsersResponse fetchUsuariosList() {				
		FetchUsersResponse fetchUsersResponse = null;		
		List<Usuarios> usuariosLista = new ArrayList<Usuarios>(); 
		List<UsuarioDto> usuariosDtoLista = new ArrayList<UsuarioDto>();		 
		try {			
			usuariosLista = (List<Usuarios>) usuariosRepository.findAll();		    
		    for(Usuarios usuarios :usuariosLista) {		    	
		    	UsuarioDto usuarioDto = new UsuarioDto();
		    	usuarioDto.setId(usuarios.getId());
		    	usuarioDto.setNombre(usuarios.getNombre());
		    	usuarioDto.setEmail(usuarios.getEmail());
		    	usuarioDto.setContraseña(usuarios.getContraseña());	    	
		    	List<AccesosDto> listaAccesos = new ArrayList<AccesosDto>();
		    	List<PermisosDto> listaPermisos = new ArrayList<PermisosDto>();		    	
		    	for(Accesos accesos :usuarios.getAccesos()){
		    		AccesosDto accesoDto = new AccesosDto();
		    		accesoDto.setIdAcceso(accesos.getIdUsuario());
		    		accesoDto.setTimestamp(accesos.getTimestamp());
		    		listaAccesos.add(accesoDto);
		    	}		    	
		    	for(Permisos permisos :usuarios.getPermisos()){
		    		PermisosDto permisosDto = new PermisosDto();
		    		permisosDto.setIdPermiso(permisos.getIdUsuario());
		    		permisosDto.setPermiso(permisos.getPermiso());
		    		listaPermisos.add(permisosDto);
		    	}			    
			    usuarioDto.setAccesos(listaAccesos);
			    usuarioDto.setPermisos(listaPermisos);
			    usuariosDtoLista.add(usuarioDto);			    
			    fetchUsersResponse.setGenericResponse(new GenericResponse(200, "Usuarios listados correctamente"));
			    fetchUsersResponse.setUsuarioDto(usuariosDtoLista);
		    }			
		}catch(Exception e) {
			e.printStackTrace();
		}		
	    return fetchUsersResponse;
	}

	@SuppressWarnings("null")
	@Override
	public GenericResponse updateUsuarios(UsuarioToUpdateDto usuarioToUpdateDto, String email) {		
		GenericResponse genericResponse = null;		
		try {
			usuariosRepository.updateByEmail(usuarioToUpdateDto.getNombre(), usuarioToUpdateDto.getEmail(), usuarioToUpdateDto.getContraseña(), email);		
			accesosRepository.updateTimestamp(usuarioToUpdateDto.getTimestamp(), usuariosRepository.findByEmail(usuarioToUpdateDto.getEmail()).getAccesos().get(0).getIdUsuario());
			permisosRepository.updatePermiso(usuarioToUpdateDto.getPermiso(), usuariosRepository.findByEmail(usuarioToUpdateDto.getEmail()).getAccesos().get(0).getIdUsuario());
			genericResponse.setStatus(200);
			genericResponse.setMessage("Usuario actualizado exitosamente");
		} catch (Exception e) {
			e.printStackTrace();
		}		
	    return genericResponse;
	}

	@SuppressWarnings("null")
	@Override
	public GenericResponse deleteUsuariosById(Long accesosIdUsuario) {
		GenericResponse genericResponse = null;
		try {
			usuariosRepository.deleteById(accesosIdUsuario);
			genericResponse.setStatus(200);
			genericResponse.setMessage("Usuario eliminado exitosamente");
		} catch(Exception e) {
			e.printStackTrace();
		}		
		return genericResponse;
	}
	
	@SuppressWarnings("null")
	@Override
	public GenericResponse deleteUsuariosByEmail(String email) {
		GenericResponse genericResponse = null;		
		try{			
			Usuarios usuario = usuariosRepository.findByEmail(email);
			usuariosRepository.delete(usuario);
			genericResponse.setStatus(200);
			genericResponse.setMessage("Usuario eliminado exitosamente");
		} catch(Exception e) {
			e.printStackTrace();
		}		
		return genericResponse;
	}
}
