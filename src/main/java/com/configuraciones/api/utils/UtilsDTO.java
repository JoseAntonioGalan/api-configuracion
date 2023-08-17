package com.configuraciones.api.utils;

import java.util.ArrayList;
import java.util.List;

import com.configuraciones.api.dtos.ConfigGrupoDTO;
import com.configuraciones.api.dtos.ConfigParamDTO;
import com.configuraciones.api.entities.ConfigGrupo;
import com.configuraciones.api.entities.ConfigParam;

import lombok.extern.slf4j.Slf4j;

/**
 * Clase de utilidad para la conversión entre entidades y DTOs relacionados con Configuraciones.
 */
@Slf4j
public class UtilsDTO {
    
    /**
     * Convierte una lista de entidades ConfigGrupo a una lista de DTOs ConfigGrupoDTO.
     *
     * @param listaConfigGrupo Lista de entidades ConfigGrupo.
     * @return Lista de DTOs ConfigGrupoDTO.
     */
    public static List<ConfigGrupoDTO> obtenerListaDeEntidadConfigGrupo(List<ConfigGrupo> listaConfigGrupo) {
        String msg = "UtilsDTO::obtenerListaDeEntidadConfigGrupo()";
        log.info(msg + " - init");
        List<ConfigGrupoDTO> listaConfigGrupoDto = new ArrayList<>();
        
        for (ConfigGrupo configGrupo : listaConfigGrupo) {
            listaConfigGrupoDto.add(new ConfigGrupoDTO(configGrupo));
        }
        log.info(msg + " - Size: " + listaConfigGrupoDto.size());
        log.info(msg + " - end");
        return listaConfigGrupoDto;
    }
    
    /**
     * Convierte una lista de entidades ConfigParam a una lista de DTOs ConfigParamDTO.
     *
     * @param listaConfigParam Lista de entidades ConfigParam.
     * @return Lista de DTOs ConfigParamDTO.
     */
    public static List<ConfigParamDTO> obtenerListaDeEntidadConfigParam(List<ConfigParam> listaConfigParam) {
        String msg = "UtilsDTO::obtenerListaDeEntidadConfigParam()";
        log.info(msg + " - init");
        List<ConfigParamDTO> listaConfigParamDto = new ArrayList<>();
        
        for (ConfigParam configParam : listaConfigParam) {
            listaConfigParamDto.add(new ConfigParamDTO(configParam));
        }
        log.info(msg + " - Size: " + listaConfigParamDto.size());
        log.info(msg + " - end");
        return listaConfigParamDto;
    }
	
}
