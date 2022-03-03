package com.formacion.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.formacion.app.dao.JefeDao;

import com.formacion.app.entity.Jefe;

@Service
public class JefeServiceImpl implements JefeService{

	@Autowired
	JefeDao jefeDao;
	
	@Override
	@Transactional
	public List<Jefe> findAll() {
		return (List<Jefe>) jefeDao.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Jefe findById(Long id) {
		return jefeDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Jefe save(Jefe jefe) {
		return jefeDao.save(jefe);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		jefeDao.deleteById(id);			
	}
}
