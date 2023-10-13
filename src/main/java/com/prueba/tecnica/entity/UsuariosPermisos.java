package com.prueba.tecnica.entity;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="USUARIOS_PERMISOS")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class UsuariosPermisos implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "USUARIOS_ID", updatable = false, nullable = false, columnDefinition = "VARCHAR(255)")
	private UUID usuariosId;
	
	@Column(name = "PERMISOS_ID_USUARIO")
	private Integer permisosIdUsuario;
}
