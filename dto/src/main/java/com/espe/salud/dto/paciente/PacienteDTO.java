package com.espe.salud.dto.paciente;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class PacienteDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;
    private String numeroArchivo;
    private String nombreCompleto;
    private Boolean esEstudiante;
    private Boolean esEmpleado;
    private Boolean aceptaTransfucion;
    private String lateralidad;
    private String tipoPaciente;
    private Long idDispensario;

    private String apellidoPaterno;
    private String apellidoMaterno;
    private String primerNombre;
    private String segundoNombre;
    private String cedula;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDateTime fechaNacimiento;
    private String sexo;
    private String estadoCivil;
    private String religion;
    private String grupoSanguineo;
    private String instruccion;
    private String profesion;
    private String vinculadoEspe;
    private String pueblos;
    private String etnia;
    private String seguroSalud;
    private String asociacionAfiliada;
    private String paisNacimiento;
    private String provinciaNacimiento;
    private Integer idProvinciaNacimiento;
    private String cantonNacimiento;
    private String idCantonNacimiento;
    private String nacionalidad;
    private String nacionalidad2;
    private String status;
    private ContactoDTO contacto;
    private List<ContactoEmergenciaDTO> contactosEmergencia;
    private EstudianteDTO estudiante;
    private EmpleadoDTO empleado;
}
