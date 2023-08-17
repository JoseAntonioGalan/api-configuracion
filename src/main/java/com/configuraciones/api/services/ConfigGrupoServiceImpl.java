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
	public List<ConfigGrupoDTO> obtenerActivos() {
		String msg = NOMBRE_CLASE + "::obtenerActivos()";
		log.info(msg + " - init");
		
		List<ConfigGrupoDTO> listaConfigGrupo = UtilsDTO.obtenerListaDeEntidadConfigGrupo(repository.findByActivoTrue());
		
		log.info(msg + "Resultado lista: "+ (listaConfigGrupo != null ? listaConfigGrupo.size() : listaConfigGrupo));
		log.info(msg + " - end");
		return listaConfigGrupo;
	}

	/**
     * {@inheritDoc}
     */
	@Override
	public ConfigGrupoDTO obtenerConfigGrupoByConfigGrupoIdByActivo(long id) {
		String msg = NOMBRE_CLASE + "::obtenerConfigGrupoByConfigGrupoIdByActivo()";
		log.info(msg + " - init");
		
		ConfigGrupo configGrupoEntidad = repository.findByConfigGrupoIdAndActivoTrue(id);
		
		ConfigGrupoDTO configGrupo = null;
		if(configGrupoEntidad != null) {
			configGrupo = new ConfigGrupoDTO(configGrupoEntidad);
		}
		
		log.info(msg + " - ConfigGrupoId = " + (configGrupo != null ? configGrupo.getConfigGrupoId() : null));
		log.info(msg + " - end");
		return configGrupo;
	}

	/**
     * {@inheritDoc}
     */
	@Override
	public ConfigGrupoDTO obtenerConfigGrupoByNombreAndActivo(String nombre) {
		String msg = NOMBRE_CLASE + "::obtenerConfigGrupoByNombreAndActivo()";
		log.info(msg + " - init");
		
		ConfigGrupo configGrupoEntidad = repository.findByNombreAndActivoTrue(nombre);
		
		ConfigGrupoDTO configGrupo = configGrupoEntidad != null ? new ConfigGrupoDTO(configGrupoEntidad) : null;
		
		log.info(msg + " - ConfigGrupoId = " + (configGrupo != null ? configGrupo.getConfigGrupoId() : null));
		log.info(msg + " - end");
		return configGrupo;
	}

}
