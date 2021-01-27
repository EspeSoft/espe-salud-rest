package com.espe.salud.dto.paciente;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Size;
import java.io.Serializable;

@Getter
@Setter
public class ContactoDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String callePrincipal;
    private String calleSecundaria;
    private String zonaGeografica;
    private String numeroCelular;
    private String numeroConvencional;
    private String extension;
    private String correoPersonal;
    private String correoInstitucional;
    private String parroquia;
    private String barrio;
    private Long idCantonResidencia;
    private Long idProvinciaResidencia;
}
