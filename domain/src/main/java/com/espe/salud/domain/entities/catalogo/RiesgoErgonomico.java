package com.espe.salud.domain.entities.catalogo;

import com.espe.salud.domain.entities.ocupacional.FactorRiesgoPuestoActual;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "MZSTCRIEERG", schema = "SALUD")
public class RiesgoErgonomico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MZSTCRIEERG_CODIGO", updatable = false, nullable = false)
    private Long codigo;

    @Column(name = "MZSTCRIEERG_NOMBRE")
    private String nombre;

    @ManyToMany(mappedBy = "riesgosErgonomico")
    private List<FactorRiesgoPuestoActual> factores;
}
