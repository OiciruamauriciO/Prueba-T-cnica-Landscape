package com.prueba.tecnica.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="PERMISOS")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Permisos implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_USUARIO")
	private Long idUsuario;
	
	@Column(name = "PERMISO")
    private String permiso;
	
	@Transient
	@ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
	@JoinColumn(name = "USUARIOSPERMISOS")
	private Usuarios usuarios;
	
}
