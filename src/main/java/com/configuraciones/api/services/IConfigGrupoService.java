package com.configuraciones.api.services;

import java.util.List;

import com.configuraciones.api.dtos.ConfigGrupoDTO;

public interface IConfigGrupoService {
	
	/**
	 * Crea un nuevo grupo de configuración utilizando la información proporcionada en el objeto DTO.
	 *
	 * @param dto Objeto ConfigGrupoDTO que contiene los datos del grupo de configuración a crear.
	 * @return Objeto ConfigGrupoDTO que representa el grupo de configuración recién creado.
	 */
	public ConfigGrupoDTO crearConfigGrupo(ConfigGrupoDTO dto);

	/**
	 * Obtiene una lista de todos los grupos de configuración activos.
	 *
	 * @return Lista de objetos ConfigGrupoDTO que representan los grupos de configuración activos.
	 */
	public List<ConfigGrupoDTO> obtenerActivos();

	/**
	 * Obtiene un grupo de configuración por su ID, solo si está activo.
	 *
	 * @param id Identificador único del grupo de configuración.
	 * @return Objeto ConfigGrupoDTO que representa el grupo de configuración activo encontrado.
	 */
	public ConfigGrupoDTO obtenerConfigGrupoByConfigGrupoIdByActivo(long id);


	/**
	 * Obtiene un grupo de configuración por su nombre, solo si está activo.
	 *
	 * @param nombre Nombre del grupo de configuración a buscar.
	 * @return Objeto ConfigGrupoDTO que representa el grupo de configuración activo encontrado por nombre.
	 */
	public ConfigGrupoDTO obtenerConfigGrupoByNombreAndActivo(String nombre);

	/**
	 * Actualiza un grupo de configuración existente con la información proporcionada en el objeto DTO.
	 *
	 * @param id Identificador único del grupo de configuración a actualizar.
	 * @param dto Objeto ConfigGrupoDTO que contiene los datos actualizados del grupo de configuración.
	 * @return Objeto ConfigGrupoDTO que representa el grupo de configuración actualizado.
	 */
	public ConfigGrupoDTO actualizarConfigGrupo(long id, ConfigGrupoDTO dto);

	/**
	 * Elimina un grupo de configuración por su ID.
	 *
	 * @param id Identificador único del grupo de configuración a eliminar.
	 */
	public void eliminarConfigGrupo(long id);

	/**
	 * Desactiva un grupo de configuración por su ID.
	 *
	 * @param id Identificador único del grupo de configuración a desactivar.
	 */
	public void desactivarConfigGrupo(long id);

}
