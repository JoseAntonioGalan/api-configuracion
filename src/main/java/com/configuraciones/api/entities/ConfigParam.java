package com.configuraciones.api.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;

/**
 * Esta clase representa un parámetro de configuración en el sistema.
 */
@Data
@Entity
@Table(name = "config_param")
@NamedQuery(name = "ConfigParam.findAll", query = "SELECT c FROM ConfigParam c")
public class ConfigParam {

	 /**
     * Identificador único del parámetro de configuración.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "config_param_id")
    private Long configParamId;

    /**
     * Nombre del parámetro de configuración (debe ser único).
     */
    @Column(name = "nombre", unique = true, nullable = false, length = 255)
    private String nombre;

    /**
     * Descripción del parámetro de configuración.
     */
    @Column(name = "descripcion", unique = true, nullable = false, length = 255)
    private String descripcion;

    /**
     * Valor del parámetro de configuración.
     */
    @Column(name = "valor", nullable = false, length = 255)
    private String valor;

    /**
     * Información adicional asociada al parámetro de configuración (opcional).
     */
    @Column(name = "informacion_adicional", nullable = true, length = 255)
    private String informacionAdicional;

    /**
     * Indica si el parámetro de configuración está activo o no.
     */
    @Column(name = "activo", nullable = false)
    private boolean activo;

    /**
     * Grupo de configuración al que pertenece este parámetro.
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "config_grupo_id")
    @JsonBackReference
    private ConfigGrupo configGrupo;
}