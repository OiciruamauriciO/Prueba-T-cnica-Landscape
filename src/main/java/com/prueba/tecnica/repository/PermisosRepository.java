package com.prueba.tecnica.repository;

import java.sql.Timestamp;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.prueba.tecnica.entity.Permisos;

@Transactional
@Repository
public interface PermisosRepository extends CrudRepository<Permisos, Long>{
	@Modifying
	@Query(value="UPDATE Permisos p SET p.permiso=:permiso WHERE p.id_usuario=:id", nativeQuery = true)
	void updatePermiso(@Param("permiso") String permiso, @Param("id") Long id);
}
