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

    @Column(name = "MZSTPER_CALL_SECUNDARIA")
    private String calleSecundaria;

    @Column(name = "MZSTPER_ZONA_GEOGRAFICA")
    private String zonaGeografica;

    @Column(name = "MZSTPER_NUMERO_CELULAR")
    @NotEmpty
    private String numeroCelular;

    @Column(name = "MZSTPER_NUMERO_CONVENCIONAL")
    private String numeroConvencional;

    @Column(name = "MZSTPER_CODIGO_REGION")
    private String codigoRegion;

    @Column(name = "MZSTPER_CORREO_PERSONAL")
    @NotEmpty
    private String correoPersonal;

    @Column(name = "MZSTPER_CORREO_INSTITUCIONAL")
    private String correoInstitucional;

    @Column(name = "MZSTPER_PARROQUIA")
    private String parroquia;

    @Column(name = "MZSTPER_BARRIO")
    private String barrio;
//  TO DO
//    @Column(name = "MZSTCON_CODIDO_CANTON_RESIDENCIA")
//    private Long idCantonResidencia;
//
//    @Column(name = "MZSTCON_CODIGO_PROVINCIA_RESIDENCIA")
//    private Long idProvinciaResidencia;
}
