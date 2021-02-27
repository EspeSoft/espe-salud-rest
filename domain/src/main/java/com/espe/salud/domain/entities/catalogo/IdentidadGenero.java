package com.espe.salud.domain.entities.catalogo;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "MZSTCIDEGEN", schema = "SALUD")
public class IdentidadGenero {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MZSTCIDEGEN_CODIGO", updatable = false, nullable = false)
    private Long codigo;

    @Column(name = "MZSTCIDEGEN_NOMBRE")
    private String nombre;
}
