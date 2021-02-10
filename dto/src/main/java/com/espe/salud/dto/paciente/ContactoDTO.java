package com.espe.salud.dto.paciente;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Getter
@Setter
public class ContactoDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotEmpty
    private String callePrincipal;
    private String calleSecundaria;
    private String zonaGeografica;
    private String numeroCelular;
    private String numeroConvencional;
    private String codigoRegion;

    @Email
    @NotEmpty
    private String correoPersonal;

    @Email
    private String correoInstitucional;
    private String parroquia;
    private String barrio;
//    private Long idCantonResidencia;
//    private Long idProvinciaResidencia;
}
