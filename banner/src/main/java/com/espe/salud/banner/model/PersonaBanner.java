package com.espe.salud.banner.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class PersonaBanner implements Serializable {
    private static final long serialVersionUID = 1L;

    @JsonProperty("id_banner")
    private String idBanner;
    private String apellidos;
    private String nombres;
    private String numeroDocumento;

    @JsonProperty("fecha_nacimiento")
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss.S")
    private LocalDateTime fechaNacimiento;
    
    private String sexo;
    private String estadoCivil;
    private String grupoSanguineo;
    private String religion;
    private String identificacionEtnia;
    private String prefijo;
    private String titulo;
    private String codeOrgn;
    private String tipoEmpleado;
    private String estadoEmpleado;
    private String nacionalidad;
    private String paisNacimiento;
    private String paisResidencia;
    private String provincia;
    private String canton;
    private String cantonNacimiento;
    private String cantonResidencia;
    private String cantonCampus;
    private String parroquia;
    private String parroquiaNacimiento;
    private String parroquiaResidencia;
}
