package com.configuraciones.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.configuraciones.api.constantes.Constantes;
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
		
		ConfigGrupoDTO objNuevoDTO = null;
		
		if(validarConfigGrupo(dto)) {
			ConfigGrupo configGrupo = dto.obtenerDeEntidad();
			ConfigGrupo configGrupoNuevo = repository.save(configGrupo);
			log.info(msg + " - Grupo creado correctamente");
			
			objNuevoDTO = configGrupoNuevo != null ? new ConfigGrupoDTO(configGrupoNuevo) : null;
			
		}else {
			log.error(msg + " - el dto no es válido");
		}
		
		log.info(msg + " - end");
		return objNuevoDTO;
	}

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
		
		ConfigGrupo configGrupoEntidad = repository.findByIdAndActivoTrue(id);
		
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

	/**
     * {@inheritDoc}
     */
	@Override
	public ConfigGrupoDTO actualizarConfigGrupo(long id, ConfigGrupoDTO dto) {
		
		String msg = NOMBRE_CLASE + "::actualizarConfigGrupo()";
		log.info(msg + " - init");
		
		ConfigGrupoDTO configGrupoActualizado = null;
		
		if(validarConfigGrupo(dto)) {
			ConfigGrupo configGrupoEntidad = repository.findByIdAndActivoTrue(id);
			configGrupoActualizado = new ConfigGrupoDTO(configGrupoEntidad);
			ConfigGrupo configGrupoGuardado = configGrupoActualizado.obtenerDeEntidad();
			repository.save(configGrupoGuardado);
			log.info(msg + " - Grupo actualizado correctamente");
			
		}else {
			log.error(msg + " - el dto no es válido");
		}
		
		log.info(msg + " - ConfigGrupoId = " + (configGrupoActualizado != null ? configGrupoActualizado.getConfigGrupoId() : null));
		log.info(msg + " - end");
		return configGrupoActualizado;
	}

	/**
     * {@inheritDoc}
     */
	@Override
	public boolean eliminarConfigGrupo(long id) {
		String msg = NOMBRE_CLASE + "::eliminarConfigGrupo()";
		log.info(msg + " - init");
		
		boolean eliminado = false;
		ConfigGrupo configGrupo = repository.findById(id).orElse(null);
		eliminado = configGrupo != null ? true : false;
		
		if(eliminado) {
			repository.delete(configGrupo);
		}
		
		log.info(msg + " - ConfigGrupoId = " + id + " , eliminado = " + eliminado);
		log.info(msg + " - end");
		return eliminado;
	}

	/**
     * {@inheritDoc}
     */
	@Override
	public boolean desactivarConfigGrupo(long id) {
		
		String msg = NOMBRE_CLASE + "::desactivarConfigGrupo()";
		log.info(msg + " - init");
		
		boolean desactivado = false;
		ConfigGrupo configGrupo = repository.findById(id).orElse(null);
		desactivado = configGrupo != null ? true : false;
		
		if(desactivado) {
			configGrupo.setActivo(Constantes.DESACTIVADO);
			repository.save(configGrupo);
		}
		
		log.info(msg + " - ConfigGrupoId = " + id + " , desactivado = " + desactivado);
		log.info(msg + " - end");
		return desactivado;
		
	}
	
	/**
	 * Valida la configuración de un grupo utilizando la información proporcionada en un objeto ConfigGrupoDTO.
	 *
	 * @param dto El objeto ConfigGrupoDTO que contiene la información del grupo a validar.
	 * @return {@code true} si la configuración del grupo es válida, {@code false} en caso contrario.
	 */
	private boolean validarConfigGrupo(ConfigGrupoDTO dto) {
		
		String msg = NOMBRE_CLASE + "::validarConfigGrupo()";
		log.info(msg + " - init");
		
		boolean valido = true;
		
		if(dto != null) {
			if(dto.getNombre() != null && dto.getNombre().isBlank()) {
				valido = false;
				log.warn(msg + " - el nombre no puede ser nulo o vacío");
			}
			
			if(dto.getDescripcion() != null && dto.getDescripcion().isBlank()) {
				valido = false;
				log.warn(msg + " - la descripción no puede ser nulo o vacío");
			}
		}else {
			valido = false;
			log.warn(msg + " - el dto es nulo");
		}
		
		log.info(msg + " - end");
		return valido;
	}

}
