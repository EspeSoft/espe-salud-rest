package com.espe.salud.domain.entities.odontologia;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "MZSTHISCLIODO", schema = "SALUD")
public class HistoriaClinicaOdontologica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name="MZSTHISCLIODO_CODIGO", updatable = false, nullable = false)
    private Long codigo;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @PastOrPresent
    @NotNull
    @Column(name = "MZSTHISCLIODO_FECHA_APERTURA")
    private LocalDate fechaApertura;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @PastOrPresent
    @NotNull
    @Column(name = "MZSTHISCLIODO_FECHA_CONTROL")
    private LocalDate fechaControl;

    @Size(max=50)
    @NotEmpty
    @Column(name = "MZSTHISCLIODO_PROFESIONAL")
    private String profesional;

    @Size(max=20)
    @NotEmpty
    @Column(name = "MZSTHISCLIODO_CODIGOPROFESIONAL")
    private String codigoProfesional;

    @NotNull
    @Column(name = "MZSTHISCLIODO_PACIENTE_ID")
    private Long pacienteId;

}
