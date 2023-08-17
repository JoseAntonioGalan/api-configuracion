package com.configuraciones.api.dtos;

import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.configuraciones.api.entities.ConfigGrupo;
import com.configuraciones.api.entities.ConfigParam;
import lombok.Data;

/**
 * DTO para representar los grupos de configuración.
 */
@Data
public class ConfigGrupoDTO {
	
    /**
     * Identificador del grupo de configuración.
     */
	private Long configGrupoId;

    /**
     * Nombre del grupo de configuración.
     */
	@NotEmpty
	@Size(max = 225)
	private String nombre;

    /**
     * Descripción del grupo de configuración.
     */
	@NotEmpty
	@Size(max = 225)
	private String descripcion;

    /**
     * Información adicional del grupo de configuración.
     */
	@Size(max = 225)
	private String informacionAdicional;

    /**
     * Estado de activación del grupo de configuración.
     */
	@NotEmpty
	private boolean activo;

    /**
     * Lista de parámetros de configuración asociados al grupo.
     */
	private List<ConfigParam> configParams;
	
    /**
     * Constructor que convierte una entidad ConfigGrupo a un DTO ConfigGrupoDTO.
     *
     * @param configGrupo Entidad ConfigGrupo.
     */
	public ConfigGrupoDTO(ConfigGrupo configGrupo) {
		this.configGrupoId = configGrupo.getConfigGrupoId();
		this.nombre = configGrupo.getNombre();
		this.descripcion = configGrupo.getDescripcion();
		this.informacionAdicional = configGrupo.getInformacionAdicional();
		this.activo = configGrupo.isActivo();
		this.configParams = configGrupo.getConfigParams();
	}
	
	/**
	 * Convierte un objeto DTO a una entidad ConfigGrupo.
	 *
	 * @return Entidad ConfigGrupo construida a partir de los datos del DTO
	 */
	public ConfigGrupo obtenerDeEntidad() {
		ConfigGrupo entidad = new ConfigGrupo();
		entidad.setConfigGrupoId(this.configGrupoId);
		entidad.setNombre(this.nombre);
		entidad.setDescripcion(this.descripcion);
		entidad.setActivo(this.activo);
		entidad.setInformacionAdicional(this.informacionAdicional);
		entidad.setConfigParams(this.configParams);
		return entidad;
	}
	
	
	
}

