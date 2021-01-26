package com.espe.salud.domain.entities.catalogo;

import com.espe.salud.domain.enums.TipoParentesco;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "MZSTCPAR", schema = "SALUD")
public class Parentesco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MZSTCPAR_CODIGO", updatable = false, nullable = false)
    private Long codigo;

    @Column(name = "MZSTCPAR_NOMBRE")
    private String nombre;

    @Column(name = "MZSTCPAR_TIPO")
    @Enumerated(EnumType.STRING)
    private TipoParentesco tipo;
}