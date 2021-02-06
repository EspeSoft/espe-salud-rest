package com.espe.salud.domain.entities.catalogo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "MZSTCSUBDIVISION", schema = "SALUD" )
public class Subdivision {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MZSTCSUB_CODIGO", updatable = false, nullable = false)
    private Long codigo;

    @Column(name = "MZSTCSUB_ID_STRING")
    private String idString;

    @Column(name = "MZSTCSUB_NOMBRE")
    private String nombre;

    @Column(name = "MZSTCSUB_CODIGO1")
    private String codigo1;

    @Column(name = "MZSTCSUB_TIPO")
    private String tipo;
   
}
