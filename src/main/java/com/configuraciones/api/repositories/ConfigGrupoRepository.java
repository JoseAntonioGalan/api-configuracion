package com.configuraciones.api.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.configuraciones.api.entities.ConfigGrupo;

/**
 * Repositorio para la entidad ConfigGrupo.
 */
@Repository
public interface ConfigGrupoRepository extends CrudRepository<ConfigGrupo, Long>, PagingAndSortingRepository<ConfigGrupo, Long> {

    /**
     * Busca todos los grupos de configuración activos.
     *
     * @return Lista de grupos de configuración activos
     */
    List<ConfigGrupo> findByActivoTrue();
    
    /**
     * Busca un grupo de configuración por su nombre si está activo.
     *
     * @param nombre Nombre del grupo de configuración a buscar
     * @return Grupo de configuración si se encuentra, de lo contrario, null
     */
    ConfigGrupo findByNombreAndActivoTrue(String nombre);
    
    /**
     * Busca un grupo de configuración por su ID si está activo.
     *
     * @param id ID del grupo de configuración a buscar
     * @return Grupo de configuración si se encuentra, de lo contrario, null
     */
    ConfigGrupo findByConfigGrupoIdAndActivoTrue(long id);
}
