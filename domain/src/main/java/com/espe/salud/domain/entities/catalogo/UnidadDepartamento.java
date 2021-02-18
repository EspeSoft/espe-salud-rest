package com.espe.salud.domain.entities.catalogo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "MZSTCUNIDEP", schema = "SALUD")
public class UnidadDepartamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MZSTCUNIDEP_CODIGO", updatable = false, nullable = false)
    private Long codigo;

    @Column(name = "MZSTCUNIDEP_NOMBRE")
    private String nombre;
}
