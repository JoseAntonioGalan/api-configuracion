package com.configuraciones.api.services;

import java.util.List;

import com.configuraciones.api.dtos.ConfigParamDTO;

public interface IConfigParamService {
    
	public ConfigParamDTO obtenerPorIdYActivo(long id);
	
	public ConfigParamDTO obtenerPorNombreYActivo(String nombre);
	
	public List<ConfigParamDTO> obtenerPorConfigGrupoIdYActivo(long id);
    
}
