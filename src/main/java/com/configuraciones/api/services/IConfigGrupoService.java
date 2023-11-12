package com.configuraciones.api.services;

import java.util.List;

import com.configuraciones.api.dtos.ConfigGrupoDTO;

public interface IConfigGrupoService {

	/**
	 * Obtiene una lista de todos los grupos de configuración activos.
	 *
	 * @return Lista de objetos ConfigGrupoDTO que representan los grupos de configuración activos.
	 */
	public List<ConfigGrupoDTO> obtenerTodosActivos();

	/**
	 * Obtiene un grupo de configuración por su ID, solo si está activo.
	 *
	 * @param id Identificador único del grupo de configuración.
	 * @return Objeto ConfigGrupoDTO que representa el grupo de configuración activo encontrado.
	 */
	public ConfigGrupoDTO obtenerConfigGrupoByConfigGrupoIdByActivo(Long id);


	/**
	 * Obtiene un grupo de configuración por su nombre, solo si está activo.
	 *
	 * @param nombre Nombre del grupo de configuración a buscar.
	 * @return Objeto ConfigGrupoDTO que representa el grupo de configuración activo encontrado por nombre.
	 */
	public ConfigGrupoDTO obtenerConfigGrupoByNombreAndActivo(String nombre);

}
