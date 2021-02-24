package com.espe.salud.domain.entities.catalogo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "MZSTCEXALAB", schema = "SALUD")
public class        ExamenLaboratorio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MZSTCEXALAB_CODIGO", updatable = false, nullable = false)
    private Long codigo;

    @Column(name = "MZSTCEXALAB_NOMBRE")
    private String nombre;


}
