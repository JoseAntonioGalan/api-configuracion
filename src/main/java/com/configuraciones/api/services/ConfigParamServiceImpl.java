package com.configuraciones.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.configuraciones.api.dtos.ConfigParamDTO;
import com.configuraciones.api.entities.ConfigParam;
import com.configuraciones.api.repositories.ConfigParamRepository;
import com.configuraciones.api.utils.UtilsDTO;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ConfigParamServiceImpl  implements IConfigParamService{
	
	public static final String NOMBRE_CLASE = ConfigParamServiceImpl.class.getName();

	@Autowired
	private ConfigParamRepository repository;

	/**
     * {@inheritDoc}
     */
	@Override
	public ConfigParamDTO obtenerPorIdYActivo(long id) {
		String msg = NOMBRE_CLASE + "::obtenerPorIdYActivo()";
		log.info(msg + " - init");
		
		ConfigParam configParamEntidad = repository.findByConfigParamIdAndActivoTrue(id);
		
		ConfigParamDTO configParam = null;
		if(configParamEntidad != null) {
			configParam = new ConfigParamDTO(configParamEntidad);
		}
		
		log.info(msg + " - ConfigGrupoId = " + (configParam != null ? configParam.getConfigParamId() : null));
		log.info(msg + " - end");
		return configParam;
	}

	/**
     * {@inheritDoc}
     */
	@Override
	public ConfigParamDTO obtenerPorNombreYActivo(String nombre) {
		String msg = NOMBRE_CLASE + "::obtenerPorNombreYActivo()";
		log.info(msg + " - init");
		
		ConfigParam configParamEntidad = repository.findByNombreAndActivoTrue(nombre);
		
		ConfigParamDTO configParam = null;
		if(configParamEntidad != null) {
			configParam = new ConfigParamDTO(configParamEntidad);
		}
		
		log.info(msg + " - ConfigGrupoId = " + (configParam != null ? configParam.getConfigParamId() : null));
		log.info(msg + " - end");
		return configParam;
	}

	/**
     * {@inheritDoc}
     */
	@Override
	public List<ConfigParamDTO> obtenerPorConfigGrupoIdYActivo(long id) {
		String msg = NOMBRE_CLASE + "::obtenerPorConfigGrupoIdYActivo()";
		log.info(msg + " - init");
		
		List<ConfigParamDTO> listaConfigParam = UtilsDTO.obtenerListaDeEntidadConfigParam(repository.findByConfigGrupoIdAndActivoTrue(id));
		
		log.info(msg + "Resultado lista: "+ (listaConfigParam != null ? listaConfigParam.size() : listaConfigParam));
		log.info(msg + " - end");
		return listaConfigParam;
	}

}
