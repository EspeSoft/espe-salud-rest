package com.espe.salud.domain.entities.catalogo;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "MZSTCPLU", schema = "SALUD")
public class Plurinacionalidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MZSTCPLU_CODIGO", updatable = false, nullable = false)
    private Long codigo;

    @Column(name = "MZSTCPLU_NOMBRE")
    private String nombre;
}
