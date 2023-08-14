package com.configuraciones.api.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.configuraciones.api.entities.ConfigParam;

@Repository
public interface ConfigParamRepository extends CrudRepository<ConfigParam, Long>, PagingAndSortingRepository<ConfigParam, Long> {

}
