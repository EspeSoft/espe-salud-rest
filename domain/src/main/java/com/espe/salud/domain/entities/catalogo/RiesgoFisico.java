package com.espe.salud.domain.entities.catalogo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "MZSTCRIEFIS", schema = "SALUD")
public class RiesgoFisico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MZSTCRIEFIS_CODIGO", updatable = false, nullable = false)
    private Long codigo;

    @Column(name = "MZSTCRIEFIS_NOMBRE")
    private String nombre;
}
