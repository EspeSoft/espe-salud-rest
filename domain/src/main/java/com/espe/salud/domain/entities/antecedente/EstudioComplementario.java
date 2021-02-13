package com.espe.salud.domain.entities.antecedente;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "MZSTCESTCOM", schema = "SALUD")
public class EstudioComplementario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MZSTCESTCOM_CODIGO", updatable = false, nullable = false)
    private Long codigo;

    @Column(name = "MZSTCESTCOM_NOMBRE_ESTUDIO")
    private String nombreEstudio;

    @Column(name = "MZSTCESTCOM_FECHA_ESTUDIO")
    private LocalDate fechaEstudio;

    @Column(name = "MZSTCESTCOM_DESCRIPCION_ESTUDIO")
    private String descripcionEstudio;
}
