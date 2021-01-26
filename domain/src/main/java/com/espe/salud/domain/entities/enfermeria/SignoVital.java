package com.espe.salud.domain.entities.enfermeria;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.time.LocalDate;

@Data
@Embeddable
public class SignoVital {

    @Column(name = "MZSTNOTENF_PRESION_ARTERIAL")
    private String presionArterial;

    @Column(name = "MZSTNOTENF_FRECUENCIA_CARDIACA")
    private Double frecuenciaCardiaca;

    @Column(name = "MZSTNOTENF_FRECUENCIA_RESPIRATORIA")
    private Double frecuenciaRespiratoria;

    @Column(name = "MZSTNOTENF_TEMPERATURA")
    private Double temperatura;

    @Column(name = "MZSTNOTENF_SATURACION_OXIGENO")
    private Double saturacionOxigeno;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "MZSTNOTENF_FECHA_ULTIMA_MENSTRUACION")
    private LocalDate fechaUltimaMenstruacion;
}
