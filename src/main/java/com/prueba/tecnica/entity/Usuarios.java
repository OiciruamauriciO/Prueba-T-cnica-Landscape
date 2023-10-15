package com.prueba.tecnica.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import java.util.UUID;

@Entity
@Table(name="USUARIOS")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Usuarios implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "id", updatable = false, nullable = false, columnDefinition = "VARCHAR(255)")
    @Type(type = "uuid-char")
	private UUID id;
	
    @Column(name = "NOMBRE")
    private String nombre;    
    @Column(name = "EMAIL")
    private String email;    
    @Column(name = "CONTRASEÑA")
    private String contraseña;        
    @OneToMany(cascade = CascadeType.ALL, targetEntity = Accesos.class, orphanRemoval = true)
    @Column(name = "ACCESOS")
    private List<Accesos> accesos;    
    @OneToMany(cascade = CascadeType.ALL, targetEntity = Permisos.class, orphanRemoval = true)
    @Column(name = "PERMISOS")
    private List<Permisos> permisos;
}
