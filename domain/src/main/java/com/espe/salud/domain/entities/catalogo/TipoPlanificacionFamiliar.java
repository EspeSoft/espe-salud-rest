package com.espe.salud.domain.entities.catalogo;

import com.espe.salud.domain.enums.SexoTipoPlanificacionFamiliar;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "MZSTCTIPPLAFAM", schema = "SALUD")
public class TipoPlanificacionFamiliar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MZSTCTIPPLAFAM_CODIGO", updatable = false, nullable = false)
    private Long codigo;

    @Column(name = "MZSTCTIPPLAFAM_NOMBRE")
    private String nombre;

    @Column(name = "MZSTCTIPPLAFAM_SEXO")
    @Enumerated(EnumType.STRING)
    private SexoTipoPlanificacionFamiliar sexo;
}
