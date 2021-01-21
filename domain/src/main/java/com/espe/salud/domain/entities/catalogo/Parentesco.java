package com.espe.salud.domain.entities.catalogo;

import com.espe.salud.domain.enums.TipoParentesco;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "MZSTPAR", schema = "SALUD")
public class Parentesco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MZSTPAR_CODIGO", updatable = false, nullable = false)
    private Long codigo;

    @Column(name = "MZSTPAR_NOMBRE")
    private String nombre;

    @Column(name = "MZSTPAR_TIPO")
    @Enumerated(EnumType.STRING)
    private TipoParentesco tipo;
}