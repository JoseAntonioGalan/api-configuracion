package com.configuraciones.api.services;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

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
	public ConfigParamDTO obtenerPorIdYActivo(Long id) {
		String msg = NOMBRE_CLASE + "::obtenerPorIdYActivo()";
		log.info(msg + " - init");
		
		ConfigParam entidad = repository.findByConfigParamIdAndActivoTrue(id);
		
		ConfigParamDTO dto = null;
		if(entidad != null) {
			dto = new ConfigParamDTO(entidad);
		}
		
		log.info(msg + " - ConfigGrupoId = " + (dto != null ? dto.getConfigParamId() : null));
		log.info(msg + " - end");
		return dto;
	}

	/**
     * {@inheritDoc}
     */
	@Override
	public ConfigParamDTO obtenerPorNombreYActivo(String nombre) {
		String msg = NOMBRE_CLASE + "::obtenerPorNombreYActivo()";
		log.info(msg + " - init");
		
		ConfigParam entidad = repository.findByNombreAndActivoTrue(nombre);
		
		ConfigParamDTO dto = null;
		if(entidad != null) {
			dto = new ConfigParamDTO(entidad);
		}
		
		log.info(msg + " - ConfigGrupoId = " + (dto != null ? dto.getConfigParamId() : null));
		log.info(msg + " - end");
		return dto;
	}

	/**
     * {@inheritDoc}
     */
	@Override
	public List<ConfigParamDTO> obtenerPorConfigGrupoIdYActivo(Long id) {
		String msg = NOMBRE_CLASE + "::obtenerPorConfigGrupoIdYActivo()";
		log.info(msg + " - init");
		
		List<ConfigParamDTO> listaDto = UtilsDTO.obtenerListaDeEntidadConfigParam(repository.findByConfigGrupoIdAndActivoTrue(id));
		
		log.info(msg + "Resultado lista: "+ (listaDto != null ? listaDto.size() : listaDto));
		log.info(msg + " - end");
		return listaDto;
	}

	@Override
	public List<ConfigParamDTO> obtenerTodos() {
		String msg = NOMBRE_CLASE + "::obtenerTodos()";
		log.info(msg + " - init");

		Iterable<ConfigParam> listaEntidad = repository.findAll();
		List<ConfigParamDTO> listaDto = null;

		if (listaEntidad != null) {
			listaDto = UtilsDTO.obtenerListaDeEntidadConfigParam(
					StreamSupport.stream(listaEntidad.spliterator(), false).collect(Collectors.toList()));
		}

		log.info(msg + " - end. Resultado lista: " + (listaDto != null ? listaDto.size() : listaDto));
		return listaDto;
	}

}
