package com.espe.salud.domain.entities.catalogo;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "MZSTCDESACTENF", schema = "SALUD")
public class DescripcionActividadEnfermeria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MZSTCDESACTENF_CODIGO", updatable = false, nullable = false)
    private Long codigo;

    @Column(name = "MZSTCDESACTENF_NOMBRE")
    private String nombre;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FK_TIPACTENF_DESACTENF")
    private TipoActividadEnfermeria tipoActividadEnfermeria;
}
