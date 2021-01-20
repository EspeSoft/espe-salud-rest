package com.espe.salud.domain;

import com.espe.salud.domain.enums.TipoParentesco;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "MZSTPAR")
public class Parentesco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MZSTPAR_CODIGO")
    private Long codigo;

    @Column(name = "MZSTPAR_NOMBRE")
    private String nombre;

    @Column(name = "MZSTPAR_TIPO")
    @Enumerated(EnumType.STRING)
    private TipoParentesco tipo;
}