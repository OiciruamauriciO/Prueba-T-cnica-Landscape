package com.prueba.tecnica.repository;

import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.prueba.tecnica.entity.UsuariosAccesos;

@Transactional
@Repository
public interface UsuariosAccesosRepository extends CrudRepository<UsuariosAccesos, Long>{
	@Modifying
	@Query(value="delete from Usuarios_accesos u where u.usuarios_id=:uuid", nativeQuery = true)
	void deleteRefUsuariosUUID(@Param("uuid") UUID uuid);
	@Modifying
	@Query(value="delete from Usuarios_accesos u where u.accesos_id_usuario=:id", nativeQuery = true)
	void deleteRefUsuariosID(@Param("id") Long id);
	@Query(value="select u.accesos_id_usuario from Usuarios_accesos u where u.usuarios_id=:uuid", nativeQuery = true)
	Long selectRefUsuariosId(@Param("uuid") UUID uuid);
}
