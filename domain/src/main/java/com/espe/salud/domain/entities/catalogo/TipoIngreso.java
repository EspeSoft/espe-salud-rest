package com.espe.salud.domain.entities.catalogo;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "MZSTCTIPING", schema = "SALUD")
public class TipoIngreso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MZSTCTIPING_CODIGO", updatable = false, nullable = false)
    private Long codigo;

    @Column(name = "MZSTCTIPING_NOMBRE")
    private String nombre;
}
