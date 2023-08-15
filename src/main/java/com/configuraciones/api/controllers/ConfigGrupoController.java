package com.configuraciones.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.configuraciones.api.dtos.ConfigGrupoDTO;
import com.configuraciones.api.services.IConfigGrupoService;

@RestController
@RequestMapping("api/config-grupo")
public class ConfigGrupoController {
	
	@Autowired
	private IConfigGrupoService service;
	
	@GetMapping
	public ResponseEntity<List<ConfigGrupoDTO>> obtenerTodosGrupos(){
		List<ConfigGrupoDTO> configGrupos = service.obtenerActivos();
        return ResponseEntity.ok(configGrupos);
	}
	
	@GetMapping("/{nombre}")
	public ResponseEntity<ConfigGrupoDTO> obtenerGrupoPorNombre(@PathVariable String nombre){
		
		ConfigGrupoDTO configGrupo = service.obtenerConfigGrupoByNombreAndActivo(nombre);

        if (configGrupo != null) {
            return ResponseEntity.ok(configGrupo);
        } else {
            return ResponseEntity.notFound().build();
        }
	};
	
	@PostMapping
	public ResponseEntity<ConfigGrupoDTO> guardarConfigGrupo(
			@Valid @RequestBody ConfigGrupoDTO dto){
		
		return new ResponseEntity<>(service.crearConfigGrupo(dto), HttpStatus.CREATED);
	};
	
	@DeleteMapping("/eliminar/{id}")
	public ResponseEntity<String> eliminarConfigGrupo(@PathVariable long id) {
        boolean eliminado = service.eliminarConfigGrupo(id);
        if (eliminado) {
            return ResponseEntity.ok("Grupo de configuración eliminado exitosamente.");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("No se pudo eliminar el grupo de configuración.");
        }
    }
	
	@PutMapping("/desactivar/{id}")
    public ResponseEntity<String> desactivarConfigGrupo(@PathVariable long id) {
        boolean desactivado = service.desactivarConfigGrupo(id);
        if (desactivado) {
            return ResponseEntity.ok("Grupo de configuración desactivado exitosamente.");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("No se pudo desactivar el grupo de configuración.");
        }
    }
	
	 @PutMapping("/actualizar/{id}")
	    public ResponseEntity<String> actualizarConfigGrupo(@PathVariable long id, @RequestBody ConfigGrupoDTO dto) {
	        ConfigGrupoDTO configGrupoDTO = service.actualizarConfigGrupo(id, dto);
	        if (configGrupoDTO != null) {
	            return ResponseEntity.ok("Grupo de configuración actualizado exitosamente.");
	        } else {
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
	                .body("No se pudo actualizar el grupo de configuración.");
	        }
	    }
	

}
