package com.espe.salud.domain.entities.catalogo;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "MZSTCPROSOC", schema = "SALUD")
public class ProblemaSocial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MZSTCPROSOC_CODIGO", updatable = false, nullable = false)
    private Long codigo;

    @Column(name = "MZSTCPROSOC_NOMBRE")
    private String nombre;
}
