package com.espe.salud.domain.entities.catalogo;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "MZSTCSEGSAL", schema = "SALUD")
public class SeguroSalud {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MZSTCSEGSAL_CODIGO", updatable = false, nullable = false)
    private Long codigo;

    @Column(name = "MZSTCSEGSAL_NOMBRE")
    private String nombre;

}
