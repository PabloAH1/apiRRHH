package com.formacion.app.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "empleados")
public class Empleado implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long CodEmpleado;
	
	@Column(nullable = false, unique = true)
	private String dni;

	@Column(nullable = false)
	private String nombre;
	
	@Column(nullable = false)
	private double salario;
	
	@Column(nullable = true)
	private String telefono;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Departamento departamento;

	public Long getCodEmpleado() {
		return CodEmpleado;
	}

	public void setCodEmpleado(Long codEmpleado) {
		CodEmpleado = codEmpleado;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}
	
	
	
	
	
}
