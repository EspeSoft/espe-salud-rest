package com.espe.salud.domain.entities.evolucion;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "MZSTREP", schema = "SALUD")
public class Reposo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MZSTREP_CODIGO")
    private Long codigo;

    @Column(name = "MZSTREP_FECHA_INICIO")
    private LocalDate fechaInicio;

    @Column(name = "MZSTREP_FECHA_FIN")
    private LocalDate fechaFin;

    @Column(name = "MZSTREP_CONDICION_PACIENTE")
    private String condicionPaciente;

    @Column(name = "MZSTREP_RECOMENDACION")
    private String recomendacion;


}
