package com.configuraciones.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.configuraciones.api.dtos.ConfigParamDTO;
import com.configuraciones.api.services.IConfigParamService;
import com.configuraciones.api.utils.UtilsDTO;

@RestController
@RequestMapping("api/config-param")
public class ConfigParamController {

	@Autowired
	private IConfigParamService service;
	
	@GetMapping
	public ResponseEntity<List<ConfigParamDTO>> obtenerTodosUsuarios(){
		List<ConfigParamDTO> configParams = UtilsDTO.obtenerListaDeEntidadConfigParam(service.obtenerTodos());
        return ResponseEntity.ok(configParams);
	}
	
	

}
