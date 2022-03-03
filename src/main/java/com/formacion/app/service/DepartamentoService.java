package com.formacion.app.service;

import java.util.List;

import com.formacion.app.entity.Departamento;

public interface DepartamentoService {

	public List<Departamento> findAll();
	
	public Departamento findById(Long id);
	
	public Departamento save(Departamento departamento);
	
	public void delete(Long id);
}
