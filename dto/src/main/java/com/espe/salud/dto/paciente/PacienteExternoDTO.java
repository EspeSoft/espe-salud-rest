package com.espe.salud.dto.paciente;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class PacienteExternoDTO implements Serializable {

    @NotEmpty
    private String numeroArchivo;
    private Boolean esEstudiante;
    private Boolean esEmpleado;

    @NotNull
    private Boolean aceptaTransfucion;

    @NotEmpty
    private String lateralidad;

    @NotNull
    private Long idDispensario;

    @NotEmpty
    private String apellidoPaterno;

    @NotEmpty
    private String apellidoMaterno;

    @NotEmpty
    private String primerNombre;

    @NotEmpty
    private String segundoNombre;

    @NotEmpty
    private String cedula;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @PastOrPresent
    private LocalDate fechaNacimiento;

    @NotEmpty
    private String sexo;

    @NotEmpty
    private String estadoCivil;

    @NotEmpty
    private String religion;

    @NotEmpty
    private String grupoSanguineo;

    private String instruccion;
    private String profesion;
    private String vinculadoEspe;
    private String pueblos;
    private String grupoCultural;
    private String seguroSalud;
    private String asociacionAfiliada;

    @NotEmpty
    private String paisNacimiento;

    @NotEmpty
    private String provinciaNacimiento;

    @NotEmpty
    private String cantonNacimiento;

    @NotEmpty
    private String nacionalidad;
    private String nacionalidad2;

    @Valid
    private ContactoDTO contacto;
    private List<@Valid ContactoEmergenciaDTO> contactosEmergencia;
}
