package com.espe.salud.banner.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class PersonaBanner implements Serializable {
    private static final long serialVersionUID = 1L;

    @JsonProperty("id_banner")
    private String idBanner;

    private String apellidos;

    private String nombres;

    @JsonProperty("numero_documento")
    private String numeroDocumento;

    @JsonProperty("fecha_nacimiento")
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss.S")
    private LocalDateTime fechaNacimiento;
    
    private String sexo;

    @JsonProperty("estado_civil")
    private String estadoCivil;

    @JsonProperty("grupo_sanguineo")
    private String grupoSanguineo;

    private String religion;

    @JsonProperty("identificacion_etnia")
    private String identificacionEtnia;

    private String prefijo;

    private String titulo;

    @JsonProperty("code_orgn")
    private String codeOrgn;

    @JsonProperty("tipo_empleado")
    private String tipoEmpleado;

    @JsonProperty("estado_empleado")
    private String estadoEmpleado;

    private String nacionalidad;

    @JsonProperty("pais_dn")
    private String paisNacimiento;

    @JsonProperty("pais_pr")
    private String paisResidencia;

    private String provincia;

    private String canton;

    @JsonProperty("canton_dn")
    private String cantonNacimiento;

    @JsonProperty("canton_pr")
    private String cantonResidencia;

    @JsonProperty("canton_campus")
    private String cantonCampus;

    private String parroquia;

    @JsonProperty("parroquia_dn")
    private String parroquiaNacimiento;

    @JsonProperty("parroquia_pr")
    private String parroquiaResidencia;

    @JsonProperty("contacto_apellido")
    private String contactoEmergenciaApellido;

    @JsonProperty("contacto_nombre")
    private String contactoEmergenciaNombre;

    @JsonProperty("contacto_parentesco")
    private String contactoEmergenciaParentesco;

    @JsonProperty("contacto_telefono")
    private String contactoEmergenciaTelefono;

    @JsonProperty("contacto_celular")
    private String contactoEmergenciaCelular;

    @JsonProperty("contacto_provincia")
    private String contactoEmergenciaProvincia;

    @JsonProperty("contacto_parroquia")
    private String contactoEmergenciaParroquia;

    @JsonProperty("contacto_direccion")
    private String contactoEmergenciaDireccion;

    @JsonProperty("contacto_direccion_calle_principal")
    private String direccionCallePrincipal;

    @JsonProperty("contacto_direccion_calle_secundaria")
    private String direccionCalleSecundaria;

    @JsonProperty("contacto_direccion_referencia")
    private String direccionReferencia;

    @JsonProperty("referencia")
    private String referencia;

    @JsonProperty("fecha_original")
    private String fechaIngresoESPE;

    @JsonProperty("seccion")
    private String seccion;

    @JsonProperty("ubicacion")
    private String ubicacion;

    @JsonProperty("departamento")
    private String departamento;

    @JsonProperty("campus")
    private String campus;

    @JsonProperty("provincia_campus")
    private String provinciaCampus;

    @JsonProperty("puesto")
    private String puesto;

    @JsonProperty("correo_institucional")
    private String correoInstitucional;

    @JsonProperty("correo_personal")
    private String correoPersonal;

    @JsonProperty("provincia_dn")
    private String provinciaNacimiento;

    @JsonProperty("provincia_pr")
    private String provinciaResidencia;

    @JsonProperty("tipo_parroquia")
    private String tipoParroquia;

    private String plurinacionalidad;

    private String telefono;

    private String celular;

    private String extension;

    private String status;

    private String nivel;

    private String programa;

    private String escuela;

    @JsonProperty("direccion_campus")
    private String direccionCampus;

    public String getFullName(){
        return this.nombres + " " + this.apellidos;
    }
}
