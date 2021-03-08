package com.espe.salud.domain.entities.catalogo;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "MZSTCFREMEDHAB", schema = "SALUD")
public class FrecuenciaMedicacionHabitual {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MZSTCFREMEDHAB_CODIGO", updatable = false, nullable = false)
    private Long codigo;

    @Column(name = "MZSTCFREMEDHAB_NOMBRE")
    private String nombre;
}
