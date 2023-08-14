package com.configuraciones.api.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Esta clase representa un grupo de configuración en el sistema.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "config_grupo")
@NamedQuery(name = "ConfigGrupo.findAll", query = "SELECT c FROM ConfigGrupo c")
public class ConfigGrupo {

    /**
     * Identificador único del grupo de configuración.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "config_grupo_id")
    private Long configGrupoId;

    /**
     * Nombre del grupo de configuración (debe ser único).
     */
    @Column(name = "nombre", unique = true, nullable = false, length = 255)
    private String nombre;

    /**
     * Descripción del grupo de configuración.
     */
    @Column(name = "descripcion", unique = true, nullable = false, length = 255)
    private String descripcion;

    /**
     * Información adicional asociada al grupo de configuración (opcional).
     */
    @Column(name = "informacion_adicional", nullable = true, length = 255)
    private String informacionAdicional;

    /**
     * Indica si el grupo de configuración está activo o no.
     */
    @Column(name = "activo", nullable = false)
    private boolean activo;

    /**
     * Conjunto de parámetros de configuración asociados a este grupo.
     */
    @OneToMany(mappedBy = "configGrupo",fetch = FetchType.EAGER, cascade = CascadeType.ALL ,orphanRemoval = true)
    @JsonManagedReference
    private List<ConfigParam> configParams = new ArrayList<>();
}

