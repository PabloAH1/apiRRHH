package com.formacion.app.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.formacion.app.entity.Empleado;

@Repository
public interface EmpleadoDao extends CrudRepository<Empleado,Long> {

}
