package com.espe.salud.domain.entities.catalogo;

import com.espe.salud.domain.entities.ocupacional.FactorRiesgoPuestoActual;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "MZSTCRIEBIO", schema = "SALUD")
public class RiesgoBiologico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MZSTCRIEBIO_CODIGO", updatable = false, nullable = false)
    private Long codigo;

    @Column(name = "MZSTCRIEBIO_NOMBRE")
    private String nombre;

    @ManyToMany(mappedBy = "riesgosBiologico")
    private List<FactorRiesgoPuestoActual> factores;
}
