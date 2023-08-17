package com.configuraciones.api.services;

import java.util.List;

import com.configuraciones.api.dtos.ConfigParamDTO;

/**
 * Interfaz para definir los métodos de servicio relacionados con los parámetros de configuración.
 */
public interface IConfigParamService {
    
    /**
     * Obtiene un parámetro de configuración por su ID si está activo.
     *
     * @param id ID del parámetro de configuración a buscar
     * @return DTO del parámetro de configuración si se encuentra, de lo contrario, null
     */
    public ConfigParamDTO obtenerPorIdYActivo(long id);
    
    /**
     * Obtiene un parámetro de configuración por su nombre si está activo.
     *
     * @param nombre Nombre del parámetro a buscar
     * @return DTO del parámetro de configuración si se encuentra, de lo contrario, null
     */
    public ConfigParamDTO obtenerPorNombreYActivo(String nombre);
    
    /**
     * Obtiene una lista de parámetros de configuración por el ID del grupo si están activos.
     *
     * @param id ID del grupo de configuración para filtrar los parámetros
     * @return Lista de DTOs de parámetros de configuración si se encuentran, de lo contrario, lista vacía
     */
    public List<ConfigParamDTO> obtenerPorConfigGrupoIdYActivo(long id);
    
}
