package com.prueba.tecnica.repository;

import java.sql.Timestamp;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.prueba.tecnica.entity.Accesos;

@Transactional
@Repository
public interface AccesosRepository extends CrudRepository<Accesos, Long>{
	@Modifying
	@Query(value="UPDATE Accesos a SET a.timestamp=:timestamp WHERE a.id_usuario=:id", nativeQuery = true)
	void updateTimestamp(@Param("timestamp") Timestamp timestamp, @Param("id") Long id);
}
