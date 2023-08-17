package com.configuraciones.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.configuraciones.api.dtos.ConfigParamDTO;
import com.configuraciones.api.services.IConfigParamService;

@CrossOrigin
@RestController
@RequestMapping("api/config-param")
public class ConfigParamController {

	@Autowired
	private IConfigParamService service;
	
	@GetMapping("/{nombre}")
	public ResponseEntity<ConfigParamDTO> obtenerParametroPorNombre(@PathVariable String nombre) {

		ConfigParamDTO configParam = service.obtenerPorNombreYActivo(nombre);

		if (configParam != null) {
			return ResponseEntity.ok(configParam);
		} else {
			return ResponseEntity.notFound().build();
		}
	};
	
	@GetMapping("/grupo/{id}")
	public ResponseEntity<List<ConfigParamDTO>> obtenerParametroPorGrupo(@PathVariable long id) {
		List<ConfigParamDTO> configParam = service.obtenerPorConfigGrupoIdYActivo(id);
		return ResponseEntity.ok(configParam);
	}
	

}
