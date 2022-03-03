package com.formacion.app.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "departamentos")
public class Departamento implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long CodDepartamento;
	
	@Column(nullable = false)
	private String nombre;
	
	@Column(nullable = false)
	private String ubicacion;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CodEmpleado")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private Empleado empleado;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CodJefe")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private Jefe jefe;

	public Long getCodDepartamento() {
		return CodDepartamento;
	}

	public void setCodDepartamento(Long codDepartamento) {
		CodDepartamento = codDepartamento;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public Jefe getJefe() {
		return jefe;
	}

	public void setJefe(Jefe jefe) {
		this.jefe = jefe;
	}
	
	
}
