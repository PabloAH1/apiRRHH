package com.formacion.app.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.formacion.app.entity.Usuario;

@Repository
public interface UsuarioDao extends CrudRepository<Usuario,Long> {

	
}
