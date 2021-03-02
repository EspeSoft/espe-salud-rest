package com.espe.salud.domain.entities.catalogo;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "MZSTCORISEX", schema = "SALUD")
public class OrientacionSexual {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MZSTCORISEX_CODIGO", updatable = false, nullable = false)
    private Long codigo;

    @Column(name = "MZSTCORISEX_NOMBRE")
    private String nombre;
}
