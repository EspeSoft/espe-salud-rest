package com.espe.salud.domain.entities.catalogo;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "MZSTCRELESP", schema = "SALUD")
public class RelacionEspe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MZSTCRELESP_CODIGO", updatable = false, nullable = false)
    private Long codigo;

    @Column(name = "MZSTCRELESP_NOMBRE")
    private String nombre;
}
