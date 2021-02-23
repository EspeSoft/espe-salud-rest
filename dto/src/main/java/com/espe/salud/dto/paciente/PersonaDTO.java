package com.espe.salud.dto.paciente;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
public class PersonaDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String primerNombre;
    private String segundoNombre;
    private String cedula;
    private LocalDate fechaNacimiento;
    private String sexo;
    private String estadoCivil;
    private String religion;
    private boolean aceptaTransfucion;
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
    private Long idConsultorio;
    private Long idPaisNacimiento;
    private Long idProvinciaNacimiento;
    private Long idCantonNacimiento;
    private Long idNacionalidad;
    private Long idNacionalidad2;
    private ContactoDTO contacto;

}