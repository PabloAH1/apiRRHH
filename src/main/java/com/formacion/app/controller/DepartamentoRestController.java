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
import com.formacion.app.service.DepartamentoService;


@RestController
@RequestMapping("/api")
public class DepartamentoRestController {

	@Autowired
	private DepartamentoService servicio;

	@GetMapping("/departamentos")
	public List<Departamento> findAllCompras() {
		return servicio.findAll();
	}

	@GetMapping("/departamentos/{id}")
	public ResponseEntity<?> findComprasById(@PathVariable Long id) {
		Departamento departamento = null;
		Map<String, Object> response = new HashMap<>();

		try {
			departamento = servicio.findById(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta.");
			response.put("error", e.getMessage().concat(": ").concat(e.getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		if (departamento == null) {
			response.put("mensaje", "La compra ID: " + id.toString() + " no existe en la base de datos.");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Departamento>(departamento, HttpStatus.OK);
	}
	
	@PostMapping("/departamento")
	public ResponseEntity<?> saveCliente(@RequestBody Departamento departamento) {
		Departamento departamentoNew = null;
		Map<String, Object> response = new HashMap<>();
		try {
			departamentoNew = servicio.save(departamento);
		} catch (DataAccessException e) {
			// TODO: handle exception
			response.put("mensaje", "Error al realizar la consulta.");
			response.put("error", e.getMessage().concat(": ").concat(e.getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "Ha sido creada con éxito.");
		response.put("departamento", departamentoNew);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	@PutMapping("/departamento/{id}")
	public ResponseEntity<?> updateDepartamento(@RequestBody Departamento departamento, @PathVariable Long id) {
		Departamento departamentoActual = servicio.findById(id);
		Map<String, Object> response = new HashMap<>();

		if (departamentoActual == null) {
			response.put("mensaje", "El departamento ID: " + id.toString() + " no existe en la base de datos.");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		try {
			departamentoActual.setNombre(departamento.getNombre());
			departamentoActual.setUbicacion(departamento.getUbicacion());	
			servicio.save(departamentoActual);

		} catch (DataAccessException e) {
			// TODO: handle exception
			response.put("mensaje", "Error al realizar la consulta.");
			response.put("error", e.getMessage().concat(": ").concat(e.getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.put("mensaje", "Ha sido actualizada con éxito.");
		response.put("departamento", departamentoActual);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
}
