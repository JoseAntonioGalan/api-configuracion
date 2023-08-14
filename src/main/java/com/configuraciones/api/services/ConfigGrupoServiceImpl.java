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
	public ConfigGrupoDTO crearConfigGrupo(ConfigGrupoDTO dto) {
		String msg = NOMBRE_CLASE + "::crearConfigGrupo()";
		log.info(msg + " - init");
		
		ConfigGrupo configGrupo = dto.obtenerDeEntidad();
		ConfigGrupo configGrupoNuevo = repository.save(configGrupo);
		log.info(msg + " - Grupo creado correctamente");
		
		log.info(msg + " - end");
		return new ConfigGrupoDTO(configGrupoNuevo);
	}

	/**
     * {@inheritDoc}
     */
	@Override
	public List<ConfigGrupoDTO> obtenerActivos() {
		String msg = NOMBRE_CLASE + "::crearConfigGrupo()";
		log.info(msg + " - init");
		
		List<ConfigGrupoDTO> listaConfigGrupo = UtilsDTO.obtenerListaDeEntidadConfigGrupo(repository.findByActivoTrue());
		log.info(msg + "Resultado lista: "+ (listaConfigGrupo != null ? listaConfigGrupo.size() : listaConfigGrupo));
		log.info(msg + " - init");
		
		return listaConfigGrupo;
	}

	/**
     * {@inheritDoc}
     */
	@Override
	public ConfigGrupoDTO obtenerConfigGrupoByConfigGrupoIdByActivo(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
     * {@inheritDoc}
     */
	@Override
	public ConfigGrupoDTO obtenerConfigGrupoByNombreAndActivo(String nombre) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
     * {@inheritDoc}
     */
	@Override
	public ConfigGrupoDTO actualizarConfigGrupo(long id, ConfigGrupoDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
     * {@inheritDoc}
     */
	@Override
	public void eliminarConfigGrupo(long id) {
		// TODO Auto-generated method stub
		
	}

	/**
     * {@inheritDoc}
     */
	@Override
	public void desactivarConfigGrupo(long id) {
		// TODO Auto-generated method stub
		
	}

}
