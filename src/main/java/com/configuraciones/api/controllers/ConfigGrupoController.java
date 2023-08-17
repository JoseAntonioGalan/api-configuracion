package com.configuraciones.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.configuraciones.api.dtos.ConfigGrupoDTO;
import com.configuraciones.api.services.IConfigGrupoService;

/**
 * Controlador para manejar las operaciones relacionadas con los grupos de configuración.
 */
@CrossOrigin
@RestController
@RequestMapping("api/config-grupo")
public class ConfigGrupoController {

    @Autowired
    private IConfigGrupoService service;

    /**
     * Obtiene todos los grupos de configuración activos.
     *
     * @return Lista de objetos ConfigGrupoDTO en ResponseEntity
     */
    @GetMapping
    public ResponseEntity<List<ConfigGrupoDTO>> obtenerTodosGrupos() {
        List<ConfigGrupoDTO> configGrupos = service.obtenerActivos();
        return ResponseEntity.ok(configGrupos);
    }

    /**
     * Obtiene un grupo de configuración por su ID si está activo.
     *
     * @param id ID del grupo de configuración a buscar
     * @return Objeto ConfigGrupoDTO en ResponseEntity si se encuentra, de lo contrario, ResponseEntity.notFound()
     */
    @GetMapping("/{id}")
    public ResponseEntity<ConfigGrupoDTO> obtenerGrupoPorId(@PathVariable long id) {

        ConfigGrupoDTO configGrupo = service.obtenerConfigGrupoByConfigGrupoIdByActivo(id);

        if (configGrupo != null) {
            return ResponseEntity.ok(configGrupo);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Obtiene un grupo de configuración por su nombre si está activo.
     *
     * @param nombre Nombre del grupo de configuración a buscar
     * @return Objeto ConfigGrupoDTO en ResponseEntity si se encuentra, de lo contrario, ResponseEntity.notFound()
     */
    @GetMapping("/{nombre}")
    public ResponseEntity<ConfigGrupoDTO> obtenerGrupoPorNombre(@PathVariable String nombre) {

        ConfigGrupoDTO configGrupo = service.obtenerConfigGrupoByNombreAndActivo(nombre);

        if (configGrupo != null) {
            return ResponseEntity.ok(configGrupo);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
