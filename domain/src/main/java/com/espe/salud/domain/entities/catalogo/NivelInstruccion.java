package com.espe.salud.domain.entities.catalogo;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "MZSTCNIVINS", schema = "SALUD")
public class NivelInstruccion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MZSTCNIVINS_CODIGO", updatable = false, nullable = false)
    private Long codigo;

    @Column(name = "MZSTCNIVINS_NOMBRE")
    private String nombre;
}
