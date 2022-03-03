package com.formacion.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.formacion.app.dao.UsuarioDao;
import com.formacion.app.entity.Usuario;

@Service
public class UsuarioServiceImpl implements UsuarioService {
	@Autowired
	UsuarioDao usuarioDao;
	
	@Override
	@Transactional
	public List<Usuario> findAll() {
		return (List<Usuario>) usuarioDao.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Usuario findById(Long id) {
	
		return usuarioDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Usuario save(Usuario usuario) {
		return usuarioDao.save(usuario);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		usuarioDao.deleteById(id);		
	}

	@Override
	@Transactional
	public Usuario login(String name, String password ) {		
		//usuarioDao.findAll();		
		return null;
	}
	
}
