package com.espe.salud.domain.entities.catalogo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "MZSTCASO", schema = "SALUD")
public class Asociacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MZSTCASO_CODIGO", updatable = false, nullable = false)
    private Long codigo;

    @Column(name = "MZSTCASO_NOMBRE")
    private String nombre;
}
