package com.configuraciones.api.services;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.configuraciones.api.entities.ConfigParam;
import com.configuraciones.api.repositories.ConfigParamRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ConfigParamServiceImpl  implements IConfigParamService{
	
	public static final String NOMBRE_CLASE = ConfigParamServiceImpl.class.getName();

	@Autowired
	private ConfigParamRepository repository;
	
	@Override
	public List<ConfigParam> obtenerTodos() {
		String msg = NOMBRE_CLASE + "::crearConfigGrupo()";
		log.info(msg + " - init");

		List<ConfigParam> listaConfigGrupo = StreamSupport.stream(repository.findAll().spliterator(), false)
                .collect(Collectors.toList());
		log.info(msg + "Resultado lista: " + (listaConfigGrupo != null ? listaConfigGrupo.size() : listaConfigGrupo));
		log.info(msg + " - init");

		return listaConfigGrupo;
	}

}
