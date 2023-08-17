package com.configuraciones.api.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.configuraciones.api.entities.ConfigParam;
import java.util.List;



@Repository
public interface ConfigParamRepository extends CrudRepository<ConfigParam, Long>, PagingAndSortingRepository<ConfigParam, Long> {

	ConfigParam findByNombreAndActivoTrue(String nombre);
	
	ConfigParam findByConfigParamIdAndActivoTrue(Long configParamId);
	
	@Query(value = "SELECT * FROM config_param cp WHERE cp.config_grupo_id = :configGrupoId and cp.activo = true", nativeQuery = true)
    List<ConfigParam> findByConfigGrupoIdAndActivoTrue(@Param("configGrupoId") Long configGrupoId);
	
}
