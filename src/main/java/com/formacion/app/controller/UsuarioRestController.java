package com.formacion.app.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.formacion.app.entity.Jefe;
import com.formacion.app.entity.Usuario;
import com.formacion.app.service.UsuarioService;

@RestController
@RequestMapping("/api")
public class UsuarioRestController {

	@Autowired
	private UsuarioService servicio;
	
	
	@PostMapping("/usuario/guardar")
	public ResponseEntity<?> saveUsuario(@RequestBody Usuario usuario){

		Usuario usuarioNew=null;
		Map<String,Object> response = new HashMap<>();

		try {
			usuario=servicio.save(usuario);

		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar un insert a la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));

			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.put("mensaje", "El usuario ha sido creado con éxito");
		response.put("usuario", usuarioNew);

		return new ResponseEntity<Map<String,Object>>(response,HttpStatus.CREATED);
	}
	
	@PostMapping({"/usuarios","/todos"})
	public List<Usuario> index(){
		return servicio.findAll();
	}
	
	
	
	
}
