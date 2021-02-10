package com.espe.salud.domain.entities.catalogo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "MZSTCCONNOC", schema = "SALUD" )
public class ConsumoNocivo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MZSTCCONNOC_CODIGO", updatable = false, nullable = false)
    private Long codigo;

    @Column(name = "MZSTCCONNOC_NOMBRE")
    private String nombre;
    
}