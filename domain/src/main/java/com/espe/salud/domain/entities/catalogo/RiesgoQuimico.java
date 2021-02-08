package com.espe.salud.domain.entities.catalogo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "MZSTCRIEQUI", schema = "SALUD")
public class RiesgoQuimico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MZSTCRIEQUI_CODIGO", updatable = false, nullable = false)
    private Long codigo;

    @Column(name = "MZSTCRIEQUI_NOMBRE")
    private String nombre;
}
