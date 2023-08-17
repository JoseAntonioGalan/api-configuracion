package com.configuraciones.api.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.configuraciones.api.entities.ConfigGrupo;

public interface ConfigGrupoRepository extends CrudRepository<ConfigGrupo, Long>, PagingAndSortingRepository<ConfigGrupo, Long> {

	List<ConfigGrupo> findByActivoTrue();
	
	ConfigGrupo findByNombreAndActivoTrue(String nombre);
	
	ConfigGrupo findByConfigGrupoIdAndActivoTrue(long id);
	
}
