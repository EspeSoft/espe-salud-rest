package com.espe.salud.domain.entities.ocupacional;

import com.espe.salud.domain.enums.RiesgoLaboral;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.MappedSuperclass;
import java.time.LocalDate;
import java.util.List;

@Data
@MappedSuperclass
public abstract class DetalleTrabajo {

    @Column(name = "MZSTDETTRA_EMPRESA")
    private String empresa;

    @Column(name = "MZSTDETTRA_PUESTO_TRABAJO")
    private String puestoTrabajo;

    @Column(name = "MZSTDETTRA_ACTIVIDAD")
    private String actividad;

    @Column(name = "MZSTDETTRA_MESES")
    private Float meses;
    
    @Column(name = "MZSTDETTRA_USABAN_SEGURIDAD")
    private Boolean usabanSeguridad;
    
    @Column(name = "MZSTDETTRA_VIGILANCIA_SALUD")
    private Boolean vigilanciaSalud;

    @Column(name = "MZSTDETTRA_OBSERVACION")
    private String observacion;

    @Enumerated(EnumType.STRING)
    @Column(name = "MZSTDETTRA_RIESGO")
    private RiesgoLaboral riesgo;
}
