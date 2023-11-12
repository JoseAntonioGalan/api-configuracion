package com.configuraciones.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.configuraciones.api.dtos.ConfigGrupoDTO;
import com.configuraciones.api.entities.ConfigGrupo;
import com.configuraciones.api.repositories.ConfigGrupoRepository;
import com.configuraciones.api.utils.UtilsDTO;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ConfigGrupoServiceImpl implements IConfigGrupoService {
	
	private static final String NOMBRE_CLASE = ConfigGrupoServiceImpl.class.getName();
	
	@Autowired
	private ConfigGrupoRepository repository;

	/**
     * {@inheritDoc}
     */
	@Override
	public List<ConfigGrupoDTO> obtenerTodosActivos() {
		String msg = NOMBRE_CLASE + "::obtenerActivos()";
		log.info(msg + " - init");
		
		List<ConfigGrupoDTO> listaConfigGrupo = UtilsDTO.obtenerListaDeEntidadConfigGrupo(repository.findByActivoTrue());
	
		log.info(msg + " - end. Resultado lista: "+ (listaConfigGrupo != null ? listaConfigGrupo.size() : listaConfigGrupo));
		return listaConfigGrupo;
	}

	/**
     * {@inheritDoc}
     */
	@Override
	public ConfigGrupoDTO obtenerConfigGrupoByConfigGrupoIdByActivo(Long id) {
		String msg = NOMBRE_CLASE + "::obtenerConfigGrupoByConfigGrupoIdByActivo()";
		log.info(msg + " - init");
		
		ConfigGrupo entidad = repository.findByConfigGrupoIdAndActivoTrue(id);
		
		ConfigGrupoDTO dto = null;
		if(entidad != null) {
			dto = new ConfigGrupoDTO(entidad);
		}
		
		log.info(msg + " - end. ConfigGrupoId = " + (dto != null ? dto.getConfigGrupoId() : null));
		return dto;
	}

	/**
     * {@inheritDoc}
     */
	@Override
	public ConfigGrupoDTO obtenerConfigGrupoByNombreAndActivo(String nombre) {
		String msg = NOMBRE_CLASE + "::obtenerConfigGrupoByNombreAndActivo()";
		log.info(msg + " - init");
		
		ConfigGrupo entidad = repository.findByNombreAndActivoTrue(nombre);
		
		ConfigGrupoDTO dto = null;
		if(entidad != null) {
			dto = new ConfigGrupoDTO(entidad);
		}
		
		log.info(msg + " - end. ConfigGrupoId = " + (dto != null ? dto.getConfigGrupoId() : null));
		return dto;
	}

}
