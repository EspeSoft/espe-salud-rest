package com.espe.salud.domain.entities.catalogo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "MZSTCTIPCONNOC", schema = "SALUD")
public class TipoConsumoNocivo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MZSTCTIPCONNOC_CODIGO", updatable = false, nullable = false)
    private Long codigo;

    @Column(name = "MZSTCTIPCONNOC_NOMBRE")
    private String nombre;

}