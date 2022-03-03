package com.formacion.app.service;

import java.util.List;

import com.formacion.app.entity.Usuario;

public interface UsuarioService {

	public List<Usuario> findAll();	
	public Usuario findById(Long id);	
	public Usuario save(Usuario usuario);	
	public void delete(Long id);
	public Usuario login(String name, String password );
}
