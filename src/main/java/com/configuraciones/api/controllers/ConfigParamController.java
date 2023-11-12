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

/**
 * Controlador para manejar las operaciones relacionadas con los parámetros de configuración.
 */
@CrossOrigin
@RestController
@RequestMapping("api/config-param")
public class ConfigParamController {

    @Autowired
    private IConfigParamService service;

    /**
     * Obtiene un parámetro de configuración por su nombre si está activo.
     *
     * @param nombre Nombre del parámetro a buscar
     * @return Objeto ConfigParamDTO en ResponseEntity si se encuentra, de lo contrario, ResponseEntity.notFound()
     */
    @GetMapping("/{nombre}")
    public ResponseEntity<ConfigParamDTO> obtenerParametroPorNombre(@PathVariable String nombre) {

        ConfigParamDTO configParam = service.obtenerPorNombreYActivo(nombre);

        if (configParam != null) {
            return ResponseEntity.ok(configParam);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Obtiene una lista de parámetros de configuración por el ID del grupo si están activos.
     *
     * @param id ID del grupo de configuración para filtrar los parámetros
     * @return Lista de objetos ConfigParamDTO en ResponseEntity
     */
    @GetMapping("/grupo/{id}")
    public ResponseEntity<List<ConfigParamDTO>> obtenerParametroPorGrupo(@PathVariable Long id) {
        List<ConfigParamDTO> configParam = service.obtenerPorConfigGrupoIdYActivo(id);
        return ResponseEntity.ok(configParam);
    }
}
