package com.espe.salud.domain.entities.catalogo;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "MZSTCMOTATE", schema = "SALUD")
public class MotivoAtencion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MZSTCMOTATE_CODIGO", updatable = false, nullable = false)
    private Long codigo;

    @Column(name = "MZSTCMOTATE_NOMBRE")
    private String nombre;
}
