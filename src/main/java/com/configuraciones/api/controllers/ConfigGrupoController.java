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

import lombok.extern.slf4j.Slf4j;

/**
 * Controlador para manejar las operaciones relacionadas con los grupos de
 * configuración.
 */
@CrossOrigin
@RestController
@RequestMapping("api/config-grupo")
@Slf4j
public class ConfigGrupoController {

    @Autowired
    private IConfigGrupoService service;

    
    /**
     * Obtiene todos los grupos de configuración.
     *
     * @return Lista de objetos ConfigGrupoDTO en ResponseEntity
     */
    @GetMapping
    public ResponseEntity<List<ConfigGrupoDTO>> obtenerTodosGrupos() {
        String msg = this.getClass().getSimpleName() + "::obtenerTodosGrupos()";
        log.info(msg + " - init.");

        List<ConfigGrupoDTO> configGrupos = service.obtenerTodos();

        ResponseEntity<List<ConfigGrupoDTO>> respuesta = null;

        if (configGrupos != null && !configGrupos.isEmpty()) {
            respuesta = ResponseEntity.ok(configGrupos);
        } else {
            respuesta = ResponseEntity.notFound().build();
        }

        log.info(msg + " - end.");
        return respuesta;
    }

    /**
     * Obtiene todos los grupos de configuración activos.
     *
     * @return Lista de objetos ConfigGrupoDTO en ResponseEntity
     */
    @GetMapping("/activos")
    public ResponseEntity<List<ConfigGrupoDTO>> obtenerTodosGruposActivos() {
        String msg = this.getClass().getSimpleName() + "::obtenerTodosGruposActivos()";
        log.info(msg + " - init.");

        List<ConfigGrupoDTO> configGrupos = service.obtenerTodosActivos();

        ResponseEntity<List<ConfigGrupoDTO>> respuesta = null;

        if (configGrupos != null && !configGrupos.isEmpty()) {
            respuesta = ResponseEntity.ok(configGrupos);
        } else {
            respuesta = ResponseEntity.notFound().build();
        }

        log.info(msg + " - end.");
        return respuesta;
    }

    /**
     * Obtiene un grupo de configuración por su ID si está activo.
     *
     * @param id ID del grupo de configuración a buscar
     * @return Objeto ConfigGrupoDTO en ResponseEntity si se encuentra, de lo
     *         contrario, ResponseEntity.notFound()
     */
    @GetMapping("/{id}")
    public ResponseEntity<ConfigGrupoDTO> obtenerGrupoPorId(@PathVariable Long id) {
        String msg = this.getClass().getSimpleName() + "::obtenerGrupoPorId( id: " + id + " )";
        log.info(msg + " - init.");

        ConfigGrupoDTO configGrupo = service.obtenerConfigGrupoByConfigGrupoIdByActivo(id);

        ResponseEntity<ConfigGrupoDTO> respuesta = null;

        if (configGrupo != null) {
            respuesta = ResponseEntity.ok(configGrupo);
        } else {
            respuesta = ResponseEntity.notFound().build();
        }

        log.info(msg + " - end.");
        return respuesta;
    }

    /**
     * Obtiene un grupo de configuración por su nombre si está activo.
     *
     * @param nombre Nombre del grupo de configuración a buscar
     * @return Objeto ConfigGrupoDTO en ResponseEntity si se encuentra, de lo
     *         contrario, ResponseEntity.notFound()
     */
    @GetMapping("/{nombre}")
    public ResponseEntity<ConfigGrupoDTO> obtenerGrupoPorNombre(@PathVariable String nombre) {
        String msg = this.getClass().getSimpleName() + "::obtenerGrupoPorNombre( nombre: " + nombre + " )";
        log.info(msg + " - init.");

        ConfigGrupoDTO configGrupo = service.obtenerConfigGrupoByNombreAndActivo(nombre);

        ResponseEntity<ConfigGrupoDTO> respuesta = null;

        if (configGrupo != null) {
            respuesta = ResponseEntity.ok(configGrupo);
        } else {
            respuesta = ResponseEntity.notFound().build();
        }

        log.info(msg + " - end.");
        return respuesta;
    }
}
