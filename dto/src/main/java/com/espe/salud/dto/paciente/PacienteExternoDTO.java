package com.espe.salud.dto.paciente;

import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class PacienteExternoDTO implements Serializable {
    private String numeroArchivo;
    private Boolean esEstudiante;
    private Boolean esEmpleado;
    private Boolean accesoBanner;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String primerNombre;
    private String segundoNombre;
    private String cedula;
    private LocalDate fechaNacimiento;
    private String sexo;
    private String estadoCivil;
    private String religion;
    private Boolean aceptaTransfucion;
    private String grupoSanguineo;
    private String lateralidad;
    private String instruccion;
    private String profesion;
    private String vinculadoEspe;
    private String pueblos;
    private String grupoCultural;
    private String seguroSalud;
    private String asociacionAfiliada;
    private String ciuo;
    private Long idDispensario;
    private String paisNacimiento;
    private String provinciaNacimiento;
    private String cantonNacimiento;
    private String nacionalidad;
    private String nacionalidad2;

    @Valid
    private ContactoDTO contacto;
    private List<@Valid ContactoEmergenciaDTO> contactosEmergencia;
}
