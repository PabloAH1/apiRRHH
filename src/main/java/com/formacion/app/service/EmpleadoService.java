package com.formacion.app.service;

import java.util.List;

import com.formacion.app.entity.Empleado;

public interface EmpleadoService {

	public List<Empleado> findAll();
	
	public Empleado findById(Long id);
	
	public Empleado save(Empleado empleado);
	
	public void delete(Long id);
}

