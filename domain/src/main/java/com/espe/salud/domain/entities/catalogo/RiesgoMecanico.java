package com.espe.salud.domain.entities.catalogo;

import com.espe.salud.domain.entities.ocupacional.FactorRiesgoPuestoActual;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

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

    @ManyToMany(mappedBy = "riesgosMecanico")
    private List<FactorRiesgoPuestoActual> factores;
}
