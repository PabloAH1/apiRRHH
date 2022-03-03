package com.formacion.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.formacion.app.dao.EmpleadoDao;
import com.formacion.app.entity.Empleado;

@Service
public class EmpleadoServiceImpl implements EmpleadoService{

	@Autowired
	EmpleadoDao empleadoDao;
	
	@Override
	@Transactional
	public List<Empleado> findAll() {
		return (List<Empleado>) empleadoDao.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Empleado findById(Long id) {
	
		return empleadoDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Empleado save(Empleado empleado) {
		return empleadoDao.save(empleado);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		empleadoDao.deleteById(id);		
	}

}
