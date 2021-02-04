package com.espe.salud.domain.entities.catalogo;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "MZSTCNECSOC", schema = "SALUD")
public class NecesidadSocial {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MZSTCNECSOC_CODIGO", updatable = false, nullable = false)
    private Long codigo;

    @Column(name = "MZSTCNECSOC_NOMBRE")
    private String nombre;
}
