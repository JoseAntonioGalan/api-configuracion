package com.configuraciones.api.dtos;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.configuraciones.api.entities.ConfigParam;

import lombok.Data;

/**
 * DTO para representar los parámetros de configuración.
 */
@Data
public class ConfigParamDTO {

    /**
     * Identificador del parámetro de configuración.
     */
    private Long configParamId;

    /**
     * Nombre del parámetro de configuración.
     */
    @NotEmpty
    @Size(max = 255)
    private String nombre;

    /**
     * Descripción del parámetro de configuración.
     */
    @NotEmpty
    @Size(max = 255)
    private String descripcion;

    /**
     * Valor del parámetro de configuración.
     */
    @NotEmpty
    @Size(max = 255)
    private String valor;

    /**
     * Información adicional del parámetro de configuración.
     */
    @Size(max = 255)
    private String informacionAdicional;

    /**
     * Estado de activación del parámetro de configuración.
     */
    @NotEmpty
    private boolean activo;
    
    /**
     * Nombre del grupo de configuración al que pertenece este parámetro.
     */
    @NotEmpty
    private String nombreConfigGrupo;

    /**
     * Constructor que convierte una entidad ConfigParam a un DTO ConfigParamDTO.
     *
     * @param configParam Entidad ConfigParam.
     */
    public ConfigParamDTO(ConfigParam configParam) {
        this.setConfigParamId(configParam.getConfigParamId());
        this.setNombre(configParam.getNombre());
        this.setDescripcion(configParam.getDescripcion());
        this.setValor(configParam.getValor());
        this.setInformacionAdicional(configParam.getInformacionAdicional());
        this.setActivo(configParam.isActivo());
        this.setNombreConfigGrupo(configParam.getConfigGrupo() != null ? configParam.getConfigGrupo().getNombre() : null);
    }
}

