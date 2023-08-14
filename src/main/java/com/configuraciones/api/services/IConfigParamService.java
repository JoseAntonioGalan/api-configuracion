package com.configuraciones.api.services;

import java.util.List;

import com.configuraciones.api.entities.ConfigParam;

public interface IConfigParamService {

	List<ConfigParam> obtenerTodos();
	
}
