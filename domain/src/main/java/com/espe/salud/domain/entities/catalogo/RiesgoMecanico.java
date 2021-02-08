package com.espe.salud.domain.entities.catalogo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "MZSTCRIEMEC", schema = "SALUD")
public class RiesgoMecanico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MZSTCRIEMEC_CODIGO", updatable = false, nullable = false)
    private Long codigo;

    @Column(name = "MZSTCRIEMEC_NOMBRE")
    private String nombre;
}
