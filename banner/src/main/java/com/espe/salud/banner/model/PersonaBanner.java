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

    /**DATOS GENERALES
     * Los siguientes datos son compartidos para cualquier tipo de usuario dentro de Banner
    **/
    @JsonProperty("id_banner")
    private String idBanner;

    private String apellidos;

    private String nombres;

    private String cedula;

    @JsonProperty("fecha_nacimiento")
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss.S")
    private LocalDateTime fechaNacimiento;
    
    private String sexo;

    private String genero;

    @JsonProperty("estado_civil")
    private String estadoCivil;

    @JsonProperty("grupo_sanguineo")
    private String grupoSanguineo;

    private String religion;

    private String prefijo;

    private String titulo;

    @JsonProperty("code_orgn")
    private String codeOrgn;

    @JsonProperty("fecha_original")
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss.S")
    private LocalDateTime fechaIngresoESPE;

    private String nacionalidad;

    @JsonProperty("identificacion_etnia")
    private String identificacionEtnia;

    @JsonProperty("pais_dn")
    private String paisNacimiento;

    @JsonProperty("provincia_dn")
    private String provinciaNacimiento;

    @JsonProperty("canton_dn")
    private String cantonNacimiento;

    @JsonProperty("parroquia_dn")
    private String parroquiaNacimiento;

    @JsonProperty("pais_pr")
    private String paisResidencia;

    @JsonProperty("provincia_pr")
    private String provinciaResidencia;

    @JsonProperty("canton_pr")
    private String cantonResidencia;

    @JsonProperty("parroquia_pr")
    private String parroquiaResidencia;

    @JsonProperty("calle_principal")
    private String callePrincipal;

    @JsonProperty("calle_secundaria")
    private String calleSecundaria;

    @JsonProperty("referencia")
    private String referencia;

    @JsonProperty("tipo_parroquia")
    private String tipoParroquia;

    private String plurinacionalidad;

    private String telefono;

    private String celular;

    private String extension;

    @JsonProperty("correo_institucional")
    private String correoInstitucional;

    @JsonProperty("correo_personal")
    private String correoPersonal;

    @JsonProperty("contacto_nombre")
    private String contactoEmergenciaNombre;

    @JsonProperty("contacto_parentesco")
    private String contactoEmergenciaParentesco;

    @JsonProperty("contacto_telefono")
    private String contactoEmergenciaTelefono;

    @JsonProperty("contacto_celular")
    private String contactoEmergenciaCelular;

    @JsonProperty("contacto_direccion")
    private String contactoEmergenciaDireccion;

    private String status;

    /** DATOS ESTUDIANTE
     * Los siguientes datos son especificamente de un estudiante
     **/

    private String nivel;

    private String programa;

    /** DATOS EMPLEADO
     * Los siguientes datos son especificamente de un empleado
     **/

    @JsonProperty("tipo_empleado")
    private String tipoEmpleado;

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

    @JsonProperty("canton_campus")
    private String cantonCampus;

    @JsonProperty("direccion_campus")
    private String direccionCampus;

    @JsonProperty("puesto")
    private String puesto;

    public String getFullName(){
        return this.nombres + " " + this.apellidos;
    }
}
