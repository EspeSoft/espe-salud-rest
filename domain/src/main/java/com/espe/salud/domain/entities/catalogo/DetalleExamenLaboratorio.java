package com.espe.salud.domain.entities.catalogo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "MZSTCDETEXALAB", schema = "SALUD")
public class DetalleExamenLaboratorio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MZSTCDETEXALAB_CODIGO", updatable = false, nullable = false)
    private Long codigo;

    @Column(name = "MZSTCDETEXALAB_NOMBRE")
    private String nombre;

    @Column(name = "MZSTCDETEXALAB_UNIDAD")
    private String unidad;
}
