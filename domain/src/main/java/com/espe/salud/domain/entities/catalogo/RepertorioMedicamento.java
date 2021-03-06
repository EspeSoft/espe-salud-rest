package com.espe.salud.domain.entities.catalogo;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "MZSTCREPMED", schema = "SALUD")
public class RepertorioMedicamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MZSTCREPMED_CODIGO", updatable = false, nullable = false)
    private Long codigo;

    @Column(name = "MZSTCREPMED_NOMBRE")
    private String nombre;
}
