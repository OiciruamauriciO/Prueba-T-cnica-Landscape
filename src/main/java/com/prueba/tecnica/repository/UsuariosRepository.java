package com.prueba.tecnica.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.prueba.tecnica.entity.Usuarios;

@Transactional
@Repository
public interface UsuariosRepository extends CrudRepository<Usuarios, Long> {
	@Query(value="select c.* from Usuarios c where c.email=:email", nativeQuery = true)
	Usuarios findByEmail(@Param("email")String email);
	@Modifying
	@Query(value="update Usuarios u set u.nombre=:nombre, u.email=:email, u.contraseña=:contraseña where u.email=:firstemail", nativeQuery = true)
	void updateByEmail(@Param("nombre") String nombre, @Param("email") String email, @Param("contraseña") String contraseña, @Param("firstemail") String firstemail);
	@Modifying
	@Query(value="delete from Usuarios u where u.email=:email", nativeQuery = true)
	void deleteByEmail(@Param("email") String email);
}
