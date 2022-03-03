package com.formacion.app.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.formacion.app.entity.Departamento;
import com.formacion.app.entity.Jefe;
import com.formacion.app.entity.Usuario;
import com.formacion.app.service.DepartamentoService;
import com.formacion.app.service.UsuarioService;

@RestController
@RequestMapping("/api")
public class UsuarioRestController {

	@Autowired
	private UsuarioService servicio;

	@GetMapping("/usuarios")
	public List<Usuario> findAllCompras() {
		return servicio.findAll();
	}

	@GetMapping("/usuarios/{id}")
	public ResponseEntity<?> findComprasById(@PathVariable Long id) {
		Usuario usuario = null;
		Map<String, Object> response = new HashMap<>();

		try {
			usuario = servicio.findById(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta.");
			response.put("error", e.getMessage().concat(": ").concat(e.getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		if (usuario == null) {
			response.put("mensaje", "El usuario ID: " + id.toString() + " no existe en la base de datos.");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
	}
	
	@PostMapping("/usuario")
	public ResponseEntity<?> saveUsuario(@RequestBody Usuario usuario) {
		Usuario usuarioNew = null;
		Map<String, Object> response = new HashMap<>();
		try {
			usuarioNew = servicio.save(usuario);
		} catch (DataAccessException e) {		
			response.put("mensaje", "Error al realizar la consulta.");
			response.put("error", e.getMessage().concat(": ").concat(e.getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "Ha sido creada con éxito.");
		response.put("usuario", usuarioNew);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	@PutMapping("/usuario/{id}")
	public ResponseEntity<?> updateUsuario(@RequestBody Usuario usuario, @PathVariable Long id) {
		Usuario usuarioActual = servicio.findById(id);
		Map<String, Object> response = new HashMap<>();

		if (usuarioActual == null) {
			response.put("mensaje", "El usuario ID: " + id.toString() + " no existe en la base de datos.");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		try {
			usuarioActual.setName(usuario.getName());
			usuarioActual.setPassword(usuario.getPassword());	
			

		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta.");
			response.put("error", e.getMessage().concat(": ").concat(e.getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.put("mensaje", "Ha sido actualizada con éxito.");
		response.put("usuario", usuarioActual);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
}
