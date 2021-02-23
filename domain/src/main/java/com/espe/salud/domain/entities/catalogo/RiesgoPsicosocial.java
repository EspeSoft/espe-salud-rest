package com.espe.salud.domain.entities.catalogo;

import com.espe.salud.domain.entities.ocupacional.FactorRiesgoPuestoActual;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "MZSTCRIEPSI", schema = "SALUD")
public class RiesgoPsicosocial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MZSTCRIEPSI_CODIGO", updatable = false, nullable = false)
    private Long codigo;

    @Column(name = "MZSTCRIEPSI_NOMBRE")
    private String nombre;

    @ManyToMany(mappedBy = "riesgosPsicosocial")
    private List<FactorRiesgoPuestoActual> factores;
}
