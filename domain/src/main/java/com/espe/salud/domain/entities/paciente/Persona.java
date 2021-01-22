package com.espe.salud.domain.entities.paciente;

import com.espe.salud.domain.enums.Sexo;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "MZSTPER", schema = "SALUD")
public class Persona {
    @Column(name = "MZSTPER_APELLIDO_PATERNO")
    private String apellidoPaterno;

    @Column(name = "MZSTPER_APELLIDO_MATERNO")
    private String apellidoMaterno;

    @Column(name = "MZSTPER_PRIMER_NOMBRE")
    private String primerNombre;

    @Column(name = "MZSTPER_SEGUNDO_NOMBRE")
    private String segundoNombre;

    @Column(name = "MZSTPER_FECHA_NACIMIENTO")
    private LocalDate fechaNacimiento;

    @Column(name = "MZSTPER_SEXO")
    @Enumerated(EnumType.STRING)
    private Sexo sexo;

    @Column(name = "MZSTPER_ESTADO_CIVIL")
    private String estadoCivil;
}
