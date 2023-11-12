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

import lombok.extern.slf4j.Slf4j;

/**
 * Controlador para manejar las operaciones relacionadas con los parámetros de configuración.
 */
@CrossOrigin
@RestController
@RequestMapping("api/config-param")
@Slf4j
public class ConfigParamController {

    @Autowired
    private IConfigParamService service;


   /**
     * Obtiene todos los grupos de configuración.
     *
     * @return Lista de objetos ConfigGrupoDTO en ResponseEntity
     */
    @GetMapping
    public ResponseEntity<List<ConfigParamDTO>> obtenerTodosParametros() {
        String msg = this.getClass().getSimpleName() + "::obtenerTodosParametros()";
        log.info(msg + " - init.");
        List<ConfigParamDTO> listaParametros = service.obtenerTodos();

        ResponseEntity<List<ConfigParamDTO>> respuesta = null;

        if (listaParametros != null && !listaParametros.isEmpty()) {
            respuesta = ResponseEntity.ok(listaParametros);
        } else {
            respuesta = ResponseEntity.notFound().build();
        }

        log.info(msg + " - end.");
        return respuesta;
    }

    /**
     * Obtiene un parámetro de configuración por su nombre si está activo.
     *
     * @param nombre Nombre del parámetro a buscar
     * @return Objeto ConfigParamDTO en ResponseEntity si se encuentra, de lo contrario, ResponseEntity.notFound()
     */
    @GetMapping("/{nombre}")
    public ResponseEntity<ConfigParamDTO> obtenerParametroPorNombre(@PathVariable String nombre) {
        String msg = this.getClass().getSimpleName() + "::obtenerParametroPorNombre( id: " + nombre + " )";
        log.info(msg + " - init.");

        ConfigParamDTO configParam = service.obtenerPorNombreYActivo(nombre);

        ResponseEntity<ConfigParamDTO> respuesta = null;

        if (configParam != null) {
            respuesta = ResponseEntity.ok(configParam);
        } else {
            respuesta = ResponseEntity.notFound().build();
        }

        log.info(msg + " - end.");
        return respuesta;
    }

    /**
     * Obtiene una lista de parámetros de configuración por el ID del grupo si están activos.
     *
     * @param id ID del grupo de configuración para filtrar los parámetros
     * @return Lista de objetos ConfigParamDTO en ResponseEntity
     */
    @GetMapping("/grupo/{id}")
    public ResponseEntity<List<ConfigParamDTO>> obtenerParametroPorGrupo(@PathVariable Long id) {
        String msg = this.getClass().getSimpleName() + "::obtenerParametroPorGrupo( idGrupo: " + id + " )";
        log.info(msg + " - init.");

        List<ConfigParamDTO> configParam = service.obtenerPorConfigGrupoIdYActivo(id);
        ResponseEntity<List<ConfigParamDTO>> respuesta = null;

        if (configParam != null && !configParam.isEmpty()) {
            respuesta = ResponseEntity.ok(configParam);
        } else {
            respuesta = ResponseEntity.notFound().build();
        }

        log.info(msg + " - end.");
        return respuesta;
    }

     
}
