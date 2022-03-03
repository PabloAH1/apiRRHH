package com.formacion.app.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.formacion.app.entity.Departamento;

@Repository
public interface DepartamentoDao extends CrudRepository<Departamento,Long> {

}
