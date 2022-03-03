package com.formacion.app.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.formacion.app.entity.Jefe;

@Repository
public interface JefeDao extends CrudRepository<Jefe,Long> {

}
