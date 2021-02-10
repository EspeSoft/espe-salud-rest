package com.espe.salud.dto.paciente;

import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
public class PacienteExternoDTO implements Serializable {
    private String numeroArchivo;
    private Boolean esEstudiante;
    private Boolean esEmpleado;
    private Boolean accesoBanner;
    private String apellidoPaterno;

    @Valid
    private ContactoDTO contacto;
    private List<@Valid ContactoEmergenciaDTO> contactosEmergencia;
}
