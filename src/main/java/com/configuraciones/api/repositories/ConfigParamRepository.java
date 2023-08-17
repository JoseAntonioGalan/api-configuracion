package com.configuraciones.api.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.configuraciones.api.entities.ConfigParam;
import java.util.List;

/**
 * Repositorio para la entidad ConfigParam.
 */
@Repository
public interface ConfigParamRepository extends CrudRepository<ConfigParam, Long>, PagingAndSortingRepository<ConfigParam, Long> {

    /**
     * Busca un parámetro de configuración por su nombre si está activo.
     *
     * @param nombre Nombre del parámetro a buscar
     * @return Parámetro de configuración si se encuentra, de lo contrario, null
     */
    ConfigParam findByNombreAndActivoTrue(String nombre);
    
    /**
     * Busca un parámetro de configuración por su ID si está activo.
     *
     * @param configParamId ID del parámetro de configuración a buscar
     * @return Parámetro de configuración si se encuentra, de lo contrario, null
     */
    ConfigParam findByConfigParamIdAndActivoTrue(Long configParamId);
    
    /**
     * Busca una lista de parámetros de configuración por el ID del grupo si están activos.
     *
     * @param configGrupoId ID del grupo de configuración para filtrar los parámetros
     * @return Lista de parámetros de configuración si se encuentran, de lo contrario, lista vacía
     */
    @Query(value = "SELECT * FROM config_param cp WHERE cp.config_grupo_id = :configGrupoId and cp.activo = true", nativeQuery = true)
    List<ConfigParam> findByConfigGrupoIdAndActivoTrue(@Param("configGrupoId") Long configGrupoId);
    
}
