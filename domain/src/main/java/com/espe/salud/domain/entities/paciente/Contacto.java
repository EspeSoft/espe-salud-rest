package com.espe.salud.domain.entities.paciente;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Data
@Embeddable
public class Contacto {

    @Column(name = "MZSTPER_CALLE_PRINCIPAL")
    @NotEmpty
    private String callePrincipal;

    @Column(name = "MZSTPER_CALLE_SECUNDARIA")
    private String calleSecundaria;

    @Column(name = "MZSTPER_ZONA_GEOGRAFICA")
    private String zonaGeografica;

    @Column(name = "MZSTPER_DIRECCION_REFERENCIA")
    private String direccionReferencia;

    @Column(name = "MZSTPER_NUMERO_CELULAR")
    @NotEmpty
    private String numeroCelular;

    @Column(name = "MZSTPER_NUMERO_CONVENCIONAL")
    private String numeroConvencional;

    @Column(name = "MZSTPER_EXTENSION")
    private String extension;

    @Column(name = "MZSTPER_CORREO_PERSONAL")
    @NotEmpty
    private String correoPersonal;

    @Column(name = "MZSTPER_CORREO_INSTITUCIONAL")
    private String correoInstitucional;

    @Column(name = "MZSTPER_PARROQUIA_RESIDENCIA")
    private String parroquiaResidencia;

    @Column(name = "MZSTPER_BARRIO")
    private String barrio;

    @Column(name = "MZSTPER_CANTON_RESIDENCIA")
    private String cantonResidencia;

    @Column(name = "MZSTPER_ID_CANTON_RESIDENCIA")
    private String idCantonResidencia;

    @Column(name = "MZSTPER_PROVINCIA_RESIDENCIA")
    private String provinciaResidencia;

    @Column(name = "MZSTPER_ID_PROVINCIA_RESIDENCIA")
    private Integer idProvinciaResidencia;
}
