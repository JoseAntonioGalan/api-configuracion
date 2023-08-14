package com.configuraciones.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.configuraciones.api.dtos.ConfigGrupoDTO;
import com.configuraciones.api.services.IConfigGrupoService;

@RestController
@RequestMapping("api/config-grupo")
public class ConfigGrupoController {
	
	@Autowired
	private IConfigGrupoService configGrupoService;
	
	@PostMapping
	public ResponseEntity<ConfigGrupoDTO> guardarConfigGrupo(
			@Valid @RequestBody ConfigGrupoDTO dto){
		
		return new ResponseEntity<>(configGrupoService.crearConfigGrupo(dto), HttpStatus.CREATED);
	};
	
	@GetMapping
	public ResponseEntity<List<ConfigGrupoDTO>> obtenerTodosUsuarios(){
		List<ConfigGrupoDTO> configGrupos = configGrupoService.obtenerActivos();
        return ResponseEntity.ok(configGrupos);
	}
	

}
