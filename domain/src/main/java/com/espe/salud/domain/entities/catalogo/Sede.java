package com.espe.salud.domain.entities.catalogo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Getter
@Setter
@Entity
@Table(name = "MZSTCSED", schema = "SALUD")
public class Sede {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MZSTCSED_CODIGO", updatable = false, nullable = false)
    private Long codigo;

    @Column(name = "MZSTCSED_NOMBRE")
    @Size(max = 100)
    private String nombre;

    @Column(name = "MZSTCSED_CANTON")
    private String canton;

    @Column(name = "MZSTCSED_PROVINCIA")
    private String provincia;

    @Column(name = "MZSTCSED_PARROQUIA")
    private String parroquia;

    @Column(name = "MZSTCSED_DIRECCION")
    private String direccion;
}