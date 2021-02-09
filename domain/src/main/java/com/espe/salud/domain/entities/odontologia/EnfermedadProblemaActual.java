package com.espe.salud.domain.entities.odontologia;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Entity
@Table(name = "MZSTENFPROACT", schema = "SALUD")
public class EnfermedadProblemaActual {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name="MZSTENFPROACT_CODIGO")
    private Long codigo;

    @Column(name="MZSTENFPROACT_DESCRIPCION")
    @NotEmpty
    private String descripcion;

    @Column(name="MZSTENFPROACT_CODIGO_CIE")
    @Size(max=12)
    @NotEmpty
    private String codigoCie;

    @Column(name="MZSTENFPROACT_CODIGO_HISTORIA")
    @NotNull
    private Long historiaId;

}
