package com.espe.salud.dto.paciente;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class ContactoEmergenciaDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;
    private String nombreContacto;
    private String direccion;
    private String telefonoCelular;
    private String telefonoConvencional;
    private String parentesco;
}
