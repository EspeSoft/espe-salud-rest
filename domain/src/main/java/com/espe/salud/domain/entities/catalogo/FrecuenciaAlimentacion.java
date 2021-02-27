package com.espe.salud.domain.entities.catalogo;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "MZSTCFREALI", schema = "SALUD")
public class FrecuenciaAlimentacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MZSTCFREALI_CODIGO", updatable = false, nullable = false)
    private Long codigo;

    @Column(name = "MZSTCFREALI_NOMBRE")
    private String nombre;
}
